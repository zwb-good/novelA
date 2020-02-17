<div class="head-top">
  <span class="system-name">
    <img src="img/logo-small-gray.png" style="width:32px;float:left;margin-top:10px;margin-right:5px;"></img>
    <span class="title">書年APP</span>
    <span class="subTitle">综合业务管理系统</span>
  </span>
  <div id="mm" class="user-icon">
    <img src="img/user-default.png" art="用户头像">
    <div id="operate-menu" class="operate-list">
      <div class="operate-options">
        <ul class="clear-fix">
          <li class="op-option">
            <a href="javascript:void(0)" id="a_changePassword">
            <i class="icon-survey1"></i>修改密码</a>
          </li>
          <li class="op-option">
            <a href="javascript:void(0);" id="a_exitLogin">
            <i class="icon-wrong"></i>安全退出</a>
          </li>
        <ul>
      </div>
     </div>
  </div>
</div>

<style>
  /*禁止鼠标选中文字 */
  html,body{
    -moz-user-select:none;
    -khtml-user-select:none;
    user-select:none;
  }
  /*清除浮动 */
  .clear-fix:after{
    display:block;
    width:0;
    height:0;
    content:"";
    clear:both;
  }
  h4,ul{
    color:#333;
    font-weight:400;
  }
  .head-top{
    width:100%;
    height:55px;
    background:#333c4c;
    background-repeat:no-repeat;
    overflow:visible;
  }
  .system-name{
    display:inline-block;
    padding:0 40px;
    color:#ddd;
    text-align:left;
    display:block;
    float:left;
    font-weight:200;
    letter-spacing:2px;
  }
  .title{
    font-size:24px;
    line-height:56px;
  }
  .subTitle{
    font-size:16px;
    line-height:40px;
  }
  .operate-right a{
    color:#ddd;
    text-decoration:none;
  }
  a:vlink{
    color:#ddd;
  }
  a:hover{
    color:#27abe0;
  }
  label{
    color:#103667;
  }
  .logo-name{
    width:150px;
    line-height:65px;
    background-color:red;
    text-align:left;
    font-size:26px;
    color:#3186d1;
    font-weight:bolder;
    font-family:'楷体';
    text-shadow:0 0 0.2em #c5d5ec, 0 0 0.2em #c5d5ec;
  }
  .user-icon{
    float:right;
    display:inline-block;
    width:28px;
    height:28px;
    border-radius:50%;
    margin-top:13px;
    margin-right:20px;
    cursor:pointer;
  }
  .user-icon>img{
    display:block;
    width:100%;
    height:100%;
    border-radius:50%;
  }
  #operate-title{
    background-color:#4f5a6f;
    color:#F0E68C;
    font-size:8px;
    text-align:center;
    padding:10px 20px;
    position:relative;
  }
  .role-tips{
    position:absolute;
    top:0;
    right:0;
  }
  .title-pic{
    float:left;
    margin-right:20px;
    width:45px;
    height:45px;
    position:relative;
  }
  .user-status{
    display:inline-block;
    position:absolute;
    bottom:2px;
    right:0;
    width:7px;
    height:7px;
    background:#26bf59;
    border-radius:50%;
    border:1px solid #fff;
  }
  .title-desc{
    float:left;
  }
  .title-desc>h4{
    max-width:130px;
    color:#ddd;
    font-size:16px;
    font-weight:200;
    padding:3px 0 5px 0;
    overflow:hidden;
    text-overflow:ellipsis;
    -webkit-line-clamp:1;
    white-space: nowrap;
    text-align:left;
  }
  .title-desc>span{
    display:block;
    text-align:left;
  }
  .operate-list{
    position:absolute;
    top:43px;
    right:20px;
    width:200px;
    height:auto;
    background-color:#fff;
    z-index:100000;
    font-size:14px;
    box-shadow: 0 1px 2px #c7c5c5;
    padding:0px 0px 6px 0px;
    display:none;
  }
  .operate-options>ul{
    overflow:hidden;
  }
  .operate-options>ul>li{
    width:50%;
    float:left;
    margin-top:10px;
    padding:0 10px;
    box-sizing:border-box;
  }
  .operate-options>ul>li>a{
    display:block;
    height:36px;
    line-height:36px;
    border-radius:3px;
  }
  .operate-options>ul>li>a>i{
    font-size:14px;
    margin-right:10px;
  }
  .operate-options>ul>li>a:hover{
    background-color:#4c5667;
    color:#eee;
  }
  
  
  /* 右侧帮助面板相关样式  */
  .page-help{
    padding:5px 10px;
  }
  .page-help .help-item{
    margin-bottom:10px;
  }
  .help-item .item-desc{
    padding-left:10px;
  }
  .page-help h5{
    margin-bottom:10px;
    font-family:微软雅黑;
  }
  .page-help p{
    line-height:1.7;
    margin-bottom:10px;
  }
  .operator-text{
    display:inline-block;
    padding:0 5px;
    background-color:#66c37952;
    border-radius:3px;
    color:#4a8c58;
  }
  .operator-desc{
    display:inline-block;
    max-width:127px;
    vertical-align:top;
    margin-left:10px;
  }
  .operator-icon{
    display:inline-block;
    padding:2px 3px;
    font-size:12px;
    background-color:#333;
    color:#ff0;
    line-height:1;
    font-style:normal;
    border-radius:2px;
    margin:0 3px;
  }
  .operator-icon>i{
    font-size:12px;
    margin-right:3px;
  }
  .line-height-2{
    line-height:2.0 !important;
  }
  .text-warning{
    color:red;
  }
</style>

<script>
$(document).ready(function(){
  $("#operate-menu").hide();// 页面加载完毕时默认隐藏菜单
  var flag1 = "0";
  var flag2 = "0";
  $("#mm").mouseover(function(){// 鼠标滑到头像时显示菜单
    flag1="1";
    flag2="0";
    toggle(flag1,flag2);
  });
  $("#mm").mouseout(function(){// 鼠标滑开头像时显示菜单
      flag1="0";
      toggle(flag1,flag2);
    });
  $("#operate-menu").mouseover(function(){// 鼠标滑到头像时显示菜单
    flag1="0";
    flag2="1";
    toggle(flag1,flag2);
  });
  $("#operate-menu").mouseout(function(){// 鼠标移开菜单时隐藏
    flag2="0";
    toggle(flag1,flag2);
  });
});

function toggle(flag1,flag2) {
    if(flag1 == 0 && flag2 == 0) {
      $("#operate-menu").hide();
    }else {
      $("#operate-menu").show();
    }
}

$(document).ready(function(){//修改密码
  $("#a_changePassword").click(function(){
    $('#dlg_pwd').dialog('open');
    $("#form_pwd").form("clear");
  });
});



$(document).ready(function(){//安全退出
  $("#a_exitLogin").click(function(){
    clearCookie()//清除所有cookie
    window.location.href = "/novel/index.jsp";
  });
});
</script>

<!--加载动画css-->
<style type="text/css">
#loading{
  width:100%;
  height:100%;
  margin:0px;
  padding:0px;
  overflow:hidden;
  position:absolute;
  left:0px;
  top:0px;
  background-color:#eee;
  z-index:10000;
}

#loading-center{
  position:absolute;
  top:50%;
  left:50%;
  transform:translate(-50%,-60%);
}

.sk-circle {
  margin: 40px auto;
  width: 40px;
  height: 40px;
  position: relative; 
}

.sk-circle .sk-child {
  width: 100%;
  height: 100%;
  position: absolute;
  left: 0;
  top: 0; 
}

.sk-circle .sk-child:before {
  content: '';
  display: block;
  margin: 0 auto;
  width: 15%;
  height: 15%;
  background-color: #333;
  border-radius: 100%;
  -webkit-animation: sk-circleBounceDelay 1.2s infinite ease-in-out both;
  animation: sk-circleBounceDelay 1.2s infinite ease-in-out both; 
}

.sk-circle .sk-circle2 {
  -webkit-transform: rotate(30deg);
  -ms-transform: rotate(30deg);
  transform: rotate(30deg); 
}

.sk-circle .sk-circle3 {
  -webkit-transform: rotate(60deg);
  -ms-transform: rotate(60deg);
  transform: rotate(60deg); 
}

.sk-circle .sk-circle4 {
  -webkit-transform: rotate(90deg);
  -ms-transform: rotate(90deg);
  transform: rotate(90deg); 
}

.sk-circle .sk-circle5 {
  -webkit-transform: rotate(120deg);
  -ms-transform: rotate(120deg);
  transform: rotate(120deg); 
}

.sk-circle .sk-circle6 {
  -webkit-transform: rotate(150deg);
  -ms-transform: rotate(150deg);
  transform: rotate(150deg); 
}

.sk-circle .sk-circle7 {
  -webkit-transform: rotate(180deg);
  -ms-transform: rotate(180deg);
  transform: rotate(180deg); 
}

.sk-circle .sk-circle8 {
  -webkit-transform: rotate(210deg);
  -ms-transform: rotate(210deg);
  transform: rotate(210deg); 
}

.sk-circle .sk-circle9 {
  -webkit-transform: rotate(240deg);
  -ms-transform: rotate(240deg);
  transform: rotate(240deg); 
}

.sk-circle .sk-circle10 {
  -webkit-transform: rotate(270deg);
  -ms-transform: rotate(270deg);
  transform: rotate(270deg); 
}

.sk-circle .sk-circle11 {
  -webkit-transform: rotate(300deg);
  -ms-transform: rotate(300deg);
  transform: rotate(300deg); 
}

.sk-circle .sk-circle12 {
  -webkit-transform: rotate(330deg);
  -ms-transform: rotate(330deg);
  transform: rotate(330deg); 
}

.sk-circle .sk-circle2:before {
  -webkit-animation-delay: -1.1s;
  animation-delay: -1.1s; 
}

.sk-circle .sk-circle3:before {
  -webkit-animation-delay: -1s;
  animation-delay: -1s; 
}

.sk-circle .sk-circle4:before {
  -webkit-animation-delay: -0.9s;
  animation-delay: -0.9s; 
}

.sk-circle .sk-circle5:before {
  -webkit-animation-delay: -0.8s;
  animation-delay: -0.8s; 
}

.sk-circle .sk-circle6:before {
  -webkit-animation-delay: -0.7s;
  animation-delay: -0.7s; 
}

.sk-circle .sk-circle7:before {
  -webkit-animation-delay: -0.6s;
  animation-delay: -0.6s; 
}

.sk-circle .sk-circle8:before {
  -webkit-animation-delay: -0.5s;
  animation-delay: -0.5s; 
}

.sk-circle .sk-circle9:before {
  -webkit-animation-delay: -0.4s;
  animation-delay: -0.4s; 
}

.sk-circle .sk-circle10:before {
  -webkit-animation-delay: -0.3s;
  animation-delay: -0.3s; 
}

.sk-circle .sk-circle11:before {
  -webkit-animation-delay: -0.2s;
  animation-delay: -0.2s; 
}

.sk-circle .sk-circle12:before {
  -webkit-animation-delay: -0.1s;
  animation-delay: -0.1s; 
}

@-webkit-keyframes sk-circleBounceDelay {
  0%, 80%, 100% {
    -webkit-transform: scale(0);
    transform: scale(0); 
  }
  40% {
    -webkit-transform: scale(1);
    transform: scale(1); 
  } 
}

@keyframes sk-circleBounceDelay {
  0%, 80%, 100% {
    -webkit-transform: scale(0);
    transform: scale(0); 
  }
  40% {
    -webkit-transform: scale(1);
    transform: scale(1); 
  } 
}

</style>