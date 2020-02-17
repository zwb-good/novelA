/**
 * <summary>浏览器中显示提示信息</summary>
 * 右下方显示
 */
function showMessage(title,msg,timeout){
  $.messager.show({
    title:title,
    msg:msg,
    showType:'slide',
    timeout:timeout,
    style:{
      top:'',
      right:0,
      bottom:document.body.scrollTop+document.documentElement.scrollTop,
      left:''
    }
  });
}

/**
 * <summary>清除cookies</summary>
 */  
function clearCookie(){  
  var myDate=new Date();    
  myDate.setTime(-1000);//设置时间    
  var data=document.cookie;    
  var dataArray=data.split("; ");    
  for(var i=0;i<dataArray.length;i++){ 
    var varName=dataArray[i].split("=");    
    document.cookie=varName[0]+"=''; expires="+myDate.toGMTString()+";path=/";    
  }    
}