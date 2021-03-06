/*---------------------------页面初始化代码--------------------------------*/
var labelData = [];
/**
 * <summary>页面加载时获取引导页信息</summary>
 */
$(document).ready(function(){
  getAllLabel();
  var objName = "#tbl_novelType";
  var URL = "NoveltypeAction/get.do";
  searchRecords(objName,URL);
})

//格式化其他标签
function formatLabel(val,row){
  val = "";
  var arr = row.labelId.split(",");
  for(var i in arr){
	for(var j in labelData){
	  if(arr[i] == labelData[j].id){
		val +=  labelData[j].name + ",";
	  }
	}
  }
  return val.substring(0,val.length-1);
}

//获取标签数据
function getAllLabel(){
  $.ajaxSetup({async : false});
  $.post(
	"LabelAction/get.do",
	{},
	function(result){
	  var data = JSON.parse(result);
	  labelData = data.rows;
	}
  )
}
/*---------------------------页面按钮相关代码--------------------------------*/
var op; //1-添加;2-修改;

/**
 * <summary>点击添加按钮事件</summary>
 */
$(document).ready(function(){
  $("#a_insert").click(function(){
	$("#tbl_selected").datagrid("loadData",[]);
	$("#fm_sort").form("reset");//清除表单数据
	$("#dlg_sort").dialog("open");
	getLabel();
	op = 1;
  })
})

/**
 * <summary>点击修改按钮事件</summary>
 */
$(document).ready(function(){
  $("#a_update").click(function(){
	$("#fm_sort").form("reset");//清除表单数据
	var row = $("#tbl_novelType").datagrid("getSelected");
    if (row == null){showMessage("提示","请选择需要修改的记录",2000);return;}
    $("#tbl_selected").datagrid("loadData",[]);
    var id = row.id;
    $("#dlg_id").val(id);
    var name = row.name;
    $("#txt_dlg_name").textbox("setValue",name);
    var allUrl = row.url;
    $("#dlg_url").val(allUrl);
    var url = allUrl.substring(32,allUrl.length);
    $("#txt_dlg_imgUrl").textbox("setValue",url);
    $("#dlg_sort").dialog("open");
	getLabel();
	getHadLabel();
	op = 2;
  })
})

/**
 * <summary>点击删除按钮事件</summary>
 */
$(document).ready(function(){
  $("#a_delete").click(function(){
	var row = $("#tbl_novelType").datagrid("getSelected");
    if (row == null){showMessage("提示","请选择需要删除的记录",2000);return;}
    var id = row.id;
    $.messager.confirm('提示', '确认要删除吗?', function(r){
      if(r){
        $.post("NoveltypeAction/delete.do",{ids:id},function(result){
          var data = JSON.parse(result);
          showMessage("提示",'删除成功',2000);
          $("#tbl_novelType").datagrid("reload");  
        });
      }
    })
  })
})

//获取标签表格数据
function getLabel(){
  var objName = "#dlg_tbl_noSelected";
  var URL = "LabelAction/get.do";
  searchRecords(objName,URL);
}

//获取该分类已有标签
function getHadLabel(){
  var row = $("#tbl_novelType").datagrid("getSelected");
  var arr = row.labelId.split(",");
  for(var i in arr){
    for(var j in labelData){
	  if(arr[i] == labelData[j].id){
		$("#tbl_selected").datagrid('appendRow',{id:labelData[j].id,name:labelData[j].name});
	  }
	}
  }
}
/*---------------------页面dialog对话框按钮相关代码--------------------------*/
//双击添加小说
function addToLabel(index,row){
  var rows = $("#tbl_selected").datagrid('getRows');
  for(var i=0;i<=rows.length-1;i++){
    if(row.id==rows[i].id){$.messager.alert("提示","请勿重复加入！",'info');return;}
  }
  $("#tbl_selected").datagrid('appendRow',row);
}  
  
//双击右侧小说列表，移除小说
function removeFromLabel(index,row){      
  $("#tbl_selected").datagrid('deleteRow',index);
}
/**
 * <summary>点击保存按钮事件</summary>
 */
$(document).ready(function(){
  $("#a_save").click(function(){
	var name = $("#txt_dlg_name").textbox("getValue");
	var url = $("#dlg_url").val();
	console.log(url);
	var label = '';
	var rows = $("#tbl_selected").datagrid('getRows');
	for(var i=0;i<=rows.length-1;i++){
	  label += rows[i].id + ",";
	}
	console.log(name+":"+url);
	var labelId = label.substring(0,label.length-1);
	if(op == 1){
	  $.post(
		"NoveltypeAction/insert.do",
		{name:name,url:url,labelId:labelId},
		function(result){
		  var data = JSON.parse(result);
		  var success = data.success;
		  showMessage("提示",'添加成功',2000);
		  if (success){
		    $("#tbl_novelType").datagrid("reload");
		    $("#dlg_sort").dialog("close");
		  }
		}
	  )
	}
	if(op == 2){
	  var id = $("#dlg_id").val(); 
	  $.post(
		"NoveltypeAction/update.do",
		{name:name,url:url,labelId:labelId,id:id},
		function(result){
		  var data = JSON.parse(result);
		  var success = data.success;
		  showMessage("提示",'修改成功',2000);
		  if (success){
		    $("#tbl_novelType").datagrid("reload");
		    $("#dlg_sort").dialog("close");
		  }
		}
	  )
	}
  })
})

//初始化上传器
var token = null;//保存token
var key = null;//保存上传的文件名
var timestamp = null;//时间戳，用于重命名key
$(document).ready(function(){
  var uploader = Qiniu.uploader({
    runtimes:'html5,flash,html4',//上传模式,依次退化
    browse_button:'a_upload',//上传按钮ID，**必需**
    container:'dlgImg',//上传区域DOM ID，默认是browser_button的父元素，
    //dragdrop:true,//开启可拖曳上传
    //drop_element:'container',//拖曳上传区域元素的ID，拖曳文件或文件夹后可触发上传
    multi_selection:false,//只能上传单个文件 
    unique_names:false, //自动生成文件名,如果值为false则保留原文件名上传
    save_key:false,//默认 false。若在服务端生成uptoken的上传策略中指定了 `sava_key`，则开启，SDK会忽略对key的处理
    domain:'http://pth6t1mk7.bkt.clouddn.com/',//七牛云存储空间bucket域名，**必需**
    get_new_uptoken:true,//设置上传文件的时候是否每次都重新获取新的token
    max_file_size:'100mb',//最大文件体积限制
    //flash_swf_url:'js/plupload/Moxie.swf',//引入flash,相对路径
    max_retries:3,//上传失败最大重试次数
    chunk_size:'4mb',//分块上传时，每片的体积
    auto_start:true,//选择文件后自动上传，若关闭需要自己绑定事件触发上传
    //uptoken_url:'/token',//Ajax请求upToken的Url，**强烈建议设置**（服务端提供）
    //uptoken :'', //若未指定uptoken_url,则必须指定 uptoken ,uptoken由其他程序生成
    scope:{bucket:key},
    uptoken_func:function(file){//在需要获取uptoken时，该方法会被调用
    	var val = $("#txt_dlg_imgUrl").textbox('getValue');
        if (val){
          key = val.split('/')[val.split('/').length - 1];
        }else{
          timestamp = (new Date()).valueOf();
          key = timestamp + "." + file.type.split("/")[1]; // file.type的格式举例：“Image/jpg”
        }
        getToken(key);
        return token;
    },
    filters:{
      prevent_duplicates:false,//true:防止重复，过滤相同的文件
      mime_types:[
        {title :"Image files", extensions :"jpg,png,gif"}// 限定图片上传
      ]
    },
    init:{
      'FilesAdded':function(up,files){
        plupload.each(files, function(file){
          //文件添加进队列后,处理相关的事情
          var type = file.type;//文件类型
          var fileName = file.name;//文件名
          alert("选择了上传文件:"+fileName);
        });
      },
      'BeforeUpload':function(up,file){
        //每个文件上传前,处理相关的事情
      },
      'UploadProgress':function(up,file){
        //每个文件上传时,处理相关的事情
      },
      'FileUploaded':function(up,file,info){
        //每个文件上传成功后,处理相关的事情
    	var domain = up.getOption('domain');
    	var data = JSON.parse(info.response);
    	var url = domain + data.key;
    	$("#dlg_url").val(url); //隐藏域存放完整url
        $("#txt_dlg_imgUrl").textbox('setValue','/'+data.key); //时间戳的文件名
      },
      'Error':function(up,err,errTip){
        //上传出错时,处理相关的事情
      },
      'UploadComplete':function(){
        //队列文件处理完毕后,处理相关的事情
      },
      'Key':function(up,file){
        //若想在前端对每个文件的key进行个性化处理，可以配置该函数
        //该配置必须要在 unique_names:false和save_key:false时才生效
        return key;
      }
    }
  });
  uploader.start();
});

//获取token
function getToken(key){
  $.ajax({
    url:'TokenAction/get.do',
    type:'post',
    async:false,
    data:{"key" : key},
    success:function(data){
      var obj = JSON.parse(data);
      token = obj.token;
    }
  });
}