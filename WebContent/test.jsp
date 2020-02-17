<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 基于EasyUI框架的insdep样式-->
  <link rel="stylesheet" type="text/css" href="insdep/insdep_tables.css"/>
  <link rel="stylesheet" type="text/css" href="insdep/iconfont/iconfont.css"/>
  <link rel="stylesheet" type="text/css" href="insdep/insdep_theme_default.css"/>
  <script type="text/javascript" src="easyui/jquery.min.js"></script>
  <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
  <script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
  <script type="text/javascript" src="easyui/jquery-easyui-datagridview/datagrid-detailview.js"></script>
<%-- 七牛官方脚本  --%>
  <script src="admin/Plupload/js/plupload.full.min.js"></script>
  <script src="admin/dist/qiniu.js"></script>  
</head>
<body>
<div class="fitem" id="dlgImg">
      <label>封面图片:</label>
      <input name="url" id="dlg_imgUrl" type="hidden">
      <input id="txt_dlg_imgName" name="imgUrl" class="easyui-textbox" style="width:190px" prompt="点击上传" data-options="editable:false"/>
      <a class="easyui-linkbutton" data-options="iconCls:'icon-upload'" id="a_upload" style="height:21px;">上传</a>
</div>
<script type="text/javascript">
//七牛云配置
var token = null;// 保存token
var key = null;// 保存上传的文件名
var timestamp = null;// 时间戳，用于重命名key
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
	    domain:'http://pry165fg6.bkt.clouddn.com/',//七牛云存储空间bucket域名，**必需**
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
	      var val = $("#dlg_imgUrl").val();//val用于保存上传文件的url
	      console.log("val = "+val)
	      //如果val不为空，使用原key
	      //否则创建新key
	      if(val){
	        key = val.split('/')[val.split('/').length - 1];
	      }else{
	        timestamp = (new Date()).valueOf();
	        key = timestamp + "." + file.name.split(".")[file.name.split(".").length-1];
	      }
	      getToken(key);
	      token = token.slice(1, token.length-1);
	      console.log("token = "+token)
	      return token;
	    },
	    filters:{
	      prevent_duplicates:false,//true:防止重复，过滤相同的文件
	      mime_types:[
	      {title:"Image files",extensions:"gif,jpg,png"}//文件类型过滤，这里限制为文件类型
	      ]
	    },
	    init:{
	      'FilesAdded':function(up,files){
	    	  console.log('FilesAdded');
	        plupload.each(files, function(file){
	          //文件添加进队列后,处理相关的事情
	          var type = file.type;//文件类型
	          var fileName = file.name;//文件名
	          $("#txt_dlg_imgName").textbox("setValue",fileName);
	          //var progress = new FileProgress(file, 'fsUploadProgress');
	          //progress.setStatus("等待...");
	        });
	        //if(up.files.length==2){up.files.shift();}
	      },
	      'BeforeUpload':function(up,file){
	        //每个文件上传前,处理相关的事情
	        //var progress = new FileProgress(file, 'fsUploadProgress');
	        //var chunk_size = plupload.parseSize(this.getOption('chunk_size'));
	        //if(up.runtime === 'html5' && chunk_size){progress.setChunkProgress(chunk_size);}
	      },
	      'UploadProgress':function(up,file){
	        //每个文件上传时,处理相关的事情
	        //上传进度
	        //添加控件：<button type="button" id="btn_percent" style="width: 1%"></button>
	        //控件代码：
	    	//$('#btn_percent').attr('style','width:'+file.percent+'%');
	        //var progress = new FileProgress(file,'btn_percent');
	        //var chunk_size = plupload.parseSize(this.getOption('chunk_size'));
	        //progress.setProgress(file.percent + "%", up.total.bytesPerSec, chunk_size);
	      },
	      'FileUploaded':function(up,file,info){
	        //每个文件上传成功后,处理相关的事情
	        //info为文件上传成功后，服务端返回的json，格式：
	        //{
	        //  "hash":"Fh8xVqod2MQ1mocfI4S4KpRL6D98",
	        //  "key":"test.jpg"
	        //}
	        //var domain = up.getOption("domain");
	        var res = JSON.parse(info);
	        var fileSize = file.size;//上传文件的大小，单位字节
	        var sourceLink = res.key; //获取上传成功后的文件的完整URL
	        console.log($("#dlg_imgUrl").val())
	        $("#dlg_imgUrl").val(sourceLink);
	        console.log($("#dlg_imgUrl").val())
	        //$("#fileSize").val((fileSize/1024/1024).toFixed(2));//保存时，把文件大小计算成MB再保存
	        //预览PDF
	        //$("#ifm").remove();
	        //var rnd = Math.random()
	        //$("#div_pdf").html('<iframe id="ifm" src='+AddStamp(sourceLink)+' style="width:360px;height:500px;"></iframe>');
	        //保存到数据库
	        //savePdfToMysql();
	      },
	      'Error':function(up,err,errTip){
	        //上传出错时,处理相关的事情
	        //console.log(up +" /"+err + "/?" + errTip);
	        //var progress = new FileProgress(err.file, 'fsUploadProgress');
	        //progress.setError();
	        //progress.setStatus(errTip);
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
	
function getToken(key) {
	console.log("key = "+key)
	  $.ajax({
		url : 'TokenAction/get.do',
		type : 'post',
		async : false,
		data : {"key" : key },
		success : function(data) {
			var obj = JSON.parse(data);
			token = obj.token;
		}
	  });
	}
</script>
</body>
</html>