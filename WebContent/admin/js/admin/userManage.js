/*---------------------------页面初始化代码--------------------------------*/
/**
 * <summary>页面加载时获取引导页信息</summary>
 */
$(document).ready(function(){
  var objName = "#tbl_user";
  var URL = "ReaderAction/get.do";
  searchRecords(objName,URL);
})

//格式化用户
function formatUserName(val,row){
  val = row.user.name;
  return val;
}
/*---------------------------页面按钮相关代码--------------------------------*/
/**
 * <summary>点击查询按钮事件</summary>
 */
$(document).ready(function(){
  $("#a_search").click(function(){
    var condition = $("#title").textbox('getValue');
    $("#tbl_user").datagrid({
      url:"ReaderAction/searchch.do",
      queryParams:{condition:condition},
      onLoadSuccess:function(data){}
    });
  })
})

/**
 * <summary>点击修改按钮事件</summary>
 */
$(document).ready(function(){
  $("#a_update").click(function(){
	var row = $("#tbl_user").datagrid("getSelected");
    if (row == null){showMessage("提示","请选择需要修改的记录",2000);return;}
    $("#fm_user").form("load",row);
    var id = row.id;
    var url = row.headUrl;
    var userName = row.user.name;
    var showUrl = url.substring(32,url.length);
    $("#dlg_url").val(url);
    $("#dlg_id").val(id);
    $("#txt_dlg_imgUrl").textbox("setValue",showUrl);
    $("#txt_dlg_userName").textbox("setValue",userName);
    var code = '<img src="'+url+'" alt="" class="div-head">';
    $("#imgHeadBox").html(code);
    $("#dlg_user").dialog("open");
  })
})

/**
 * <summary>点击删除按钮事件</summary>
 */
$(document).ready(function(){
  $("#a_delete").click(function(){
	var row = $("#tbl_user").datagrid("getSelected");
    if (row == null){showMessage("提示","请选择需要删除的记录",2000);return;}
    var id = row.id;
    $.messager.confirm('提示', '确认要删除吗?', function(r){
      if(r){
        $.post("ReaderAction/delete.do",{id:id},function(result){
          var data = JSON.parse(result);
          showMessage("提示","删除成功",2000);
          $("#tbl_user").datagrid("reload");  
        });
      }
    })
  })
})

/*---------------------页面dialog对话框按钮相关代码--------------------------*/
/**
 * <summary>点击保存按钮事件</summary>
 */
$(document).ready(function(){
  $("#a_save").click(function(){
	var id = $("#dlg_id").val();
	var name = $("#txt_dlg_name").textbox('getValue');
	var sex = $("#cmb_dlg_sex").combobox('getValue');
	var signature = $("#txt_dlg_signature").textbox('getValue');
	var url = $("#dlg_url").val();
	console.log(name+": sex = "+sex+" : "+signature+" : url = "+url+" Id="+id);
	$.post(
	  "ReaderAction/update.do",
	  {name:name,sex:sex,signature:signature,headUrl:url,id:id},
	  function(result){
		var data = JSON.parse(result);
        showMessage("提示","修改成功",2000);
        $("#tbl_user").datagrid("reload"); 
        $("#dlg_user").dialog("close");
	  }
	)
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
        timestamp = (new Date()).valueOf();
        key = timestamp + "." + file.type.split("/")[1]; // file.type的格式举例：“Image/jpg”
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
    	console.log(url)
    	var code = '<img src="'+url+'" alt="" class="div-head">';
    	$("#imgHeadBox").html(code);
    	$("#dlg_url").val(url); //隐藏域存放完整url
    	console.log("all url:"+url);
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