/*---------------------------页面初始化代码--------------------------------*/
/**
 * <summary>页面加载时获取引导页信息</summary>
 */
$(document).ready(function(){
  var objName = "#tbl_book";
  var URL = "BookAction/select.do";
  searchRecords(objName,URL);
  getType();
})

//格式化类型
function formatType(val,row){
  val = row.noveltype.name;
  return val;
}

//格式化封面地址
function formatImg(val,row){
  var name = row.name;
  val = name + "/img";
  return val;
}

//格式化目录地址
function formatCatalogue(val,row){
  var name = row.name;
  val = name + "/catalogue";
  return val;
}

//格式化内容地址
function formatTxt(val,row){
  var name = row.name;
  val = name + "/txt";
  return val;
}
/*---------------------------页面按钮相关代码--------------------------------*/
var bookName = null;//用于重命名key
var op; //1-添加;2-修改;

/**
 * <summary>点击查询按钮事件</summary>
 */
$(document).ready(function(){
  $("#a_search").click(function(){
    var condition = $("#title").textbox('getValue');
    $("#tbl_book").datagrid({
      url:"BookAction/search.do",
      queryParams:{condition:condition},
      onLoadSuccess:function(data){}
    }); 
  })
})


/**
 * <summary>点击添加按钮事件</summary>
 */
$(document).ready(function(){
  $("#a_insert").click(function(){
	$("#fm_book").form("reset");//清除表单数据
	$("#dlg_book").dialog("open");
	op = 1;
  })
})

/**
 * <summary>点击修改按钮事件</summary>
 */
$(document).ready(function(){
  $("#a_update").click(function(){
	$("#fm_book").form("reset");//清除表单数据
	var row = $("#tbl_book").datagrid("getSelected");
    if (row == null){showMessage("提示","请选择需要修改的记录",2000);return;}
    var id = row.id;
    $("#dlg_id").val(id);
	var url = row.url;
	$("#dlg_bookUrl").val(url);
	var name = row.name;
	$("#txt_dlg_book").textbox("setValue",name);
	var author = row.author;
	$("#txt_dlg_author").textbox("setValue",author);
	var type = row.noveltype.name;
	$("#cmb_dlg_type").combobox('select',type);
	var imgUrl = row.name +"/img";
	$("#txt_dlg_imgName").textbox("setValue",imgUrl);
	//var catalogue = row.url + "/" + row.id +"/catalogue";
	//$("#txt_dlg_catalogueUrl").textbox("setValue",catalogue);
	var text = row.name +"/txt";
	$("#txt_dlg_txtUrl").textbox("setValue",text);
	var abstractText = row.abstractText;
	$("#txt_dlg_abstractText").textbox("setValue",abstractText);
	op = 2;
	$("#dlg_book").dialog("open");
  })
})

/**
 * <summary>点击删除按钮事件</summary>
 */
$(document).ready(function(){
  $("#a_delete").click(function(){
	var row = $("#tbl_book").datagrid("getSelected");
    if (row == null){showMessage("提示","请选择需要删除的记录",2000);return;}
    var id = row.id;
    $.messager.confirm('提示', '确认要删除吗?', function(r){
      if(r){
        $.post("BookAction/delete.do",{ids:id},function(result){
          var data = JSON.parse(result);
          showMessage("提示",data.msg,2000);
          $("#tbl_book").datagrid("reload");  
        });
      }
    })
  })
})

//获取分类表格数据
function getType(){
  $.post(
	"NoveltypeAction/get.do",
	{},
	function(result){
	  var data = JSON.parse(result);
	  if(data.success){
		datas = [];
		datas.push({"text":"请选择分类","id":"","selected":true});
		$.each(data.rows,function(idx,item){
	      datas.push({"text":item.name,"id":item.id}); 
	    });
		$("#cmb_dlg_type").combobox("loadData", datas);
	  }
	}
  )
}
/*---------------------页面dialog对话框按钮相关代码--------------------------*/
/**
 * <summary>点击保存按钮事件</summary>
 */
$(document).ready(function(){
  $("#a_save").click(function(){
	var name = $("#txt_dlg_book").textbox("getValue");
	var author = $("#txt_dlg_author").textbox("getValue");
	var url = $("#dlg_bookUrl").val();
	var novelTypeId = $("#cmb_dlg_type").combobox('getValue');
	var id = $("#dlg_id").val();
	var abstract = $("#txt_dlg_abstractText").textbox("getValue");
	if(op == 1){
	  $.post(
		"BookAction/insert.do",
		{name:name,author:author,url:url,novelTypeId:novelTypeId,abstractText:abstract},
		function(result){
		  var data = JSON.parse(result);
		  showMessage("提示",data.msg,2000);
		  if (data.success){
            $("#tbl_book").datagrid("reload");  
            $("#dlg_book").dialog("close"); 
          } 
		}
	  )	
	}
	if(op == 2){
	  $.post(
		"BookAction/update.do",
		{"name":name,"author":author,"url":url,"novelTypeId":novelTypeId,"abstractText":abstract,"id":id},
		function(result){
		  var data = JSON.parse(result);
		  showMessage("提示",data.msg,2000);
		  if (data.success){
			$("#tbl_book").datagrid("reload");  
			$("#dlg_book").dialog("close"); 
		  } 
		}
	  )	
	}
  })
})

//七牛云配置
//初始化上传器
var token = null;//保存token
var key = null;//保存上传的文件名
/**
 * <summary>上传封面</summary>
 */
$(document).ready(function(){
  var uploader1 = Qiniu.uploader({
    runtimes:'html5,flash,html4',//上传模式,依次退化
    browse_button:'a_upload_img',//上传按钮ID，**必需**
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
    	bookName = $("#txt_dlg_book").textbox('getValue');
    	key = bookName + "/" + "img"; // file.type的格式举例：“Image/jpg”
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
    	$("#dlg_imgUrl").val(url); //隐藏域存放完整url
    	console.log("url:"+$("#dlg_imgUrl").val());
        $("#txt_dlg_imgName").textbox('setValue',data.key); //时间戳的文件名
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
  uploader1.start();
});
/**
 * <summary>上传内容</summary>
 */
$(document).ready(function(){
  var uploader2 = Qiniu.uploader({
	runtimes:'html5,flash,html4',//上传模式,依次退化
	browse_button:'a_upload_content',//上传按钮ID，**必需**
	container:'dlgContent',//上传区域DOM ID，默认是browser_button的父元素，
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
		bookName = $("#txt_dlg_book").textbox('getValue');
		key = bookName + "/" + "txt"; // file.type的格式举例：“Image/jpg”
		getToken(key);
		return token;
	},
	filters:{
		prevent_duplicates:false,//true:防止重复，过滤相同的文件
		mime_types:[
			{title :"files", extensions :"txt"}// 限定图片上传
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
			var sqlUrl = domain + bookName;
			$("#dlg_txtUrl").val(url); //隐藏域存放完整url
			$("#dlg_bookUrl").val(sqlUrl);
			console.log("url:"+$("#dlg_txtUrl").val());
			$("#txt_dlg_txtUrl").textbox('setValue',data.key); //时间戳的文件名
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
  uploader2.start();
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