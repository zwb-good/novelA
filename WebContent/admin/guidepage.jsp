<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>管理员首页</title>
  <%@include file="inc/link.inc"%>
  <script type="text/javascript" src="./js/admin/guidepage.js"></script>
</head>
<body>
  <div class="easyui-layout" data-options="fit:true" id="bookManage">
    <!-- 顶部导航 -->
  <div align="center"  data-options="region:'north',collapsible:false" title='' style="background-color:#D6E6DE;overflow:visible;">
    <%@ include file="inc/header.inc" %>
  </div>
	
	<!-- 左侧导航 -->
	<div data-options="region:'west',collapsible:false" title='功能导航' style="width: 190px;">
	  <%@include file="inc/nav.inc"%>
	</div>
    
    <!-- 主体部分 -->
    <div data-options="region:'center',title:'页面管理  | 引导管理'" style="background:#f2f2ea none repeat scroll 0% 0%;">
      <%@include file="inc/guidePage/guidePage_field.inc"%>
      <%@include file="inc/guidePage/dialog_guidePage.inc"%>
    </div>
    
  </div>
</body>
</html>