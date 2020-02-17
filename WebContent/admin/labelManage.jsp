<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>标签管理</title>
  <%@include file="inc/link.inc"%>
  <script type="text/javascript" src="./js/admin/labelManage.js"></script>
</head>
<body>
  <!-- easyUI布局 -->
  <div class="easyui-layout" data-options="fit:true" id="bookshop">
    <!-- 顶部导航 -->
    <div align="center"  data-options="region:'north',collapsible:false" title='' style="background-color:#D6E6DE;overflow:visible;">
      <%@ include file="inc/header.inc" %>
    </div>
	
    <!-- 左侧导航 -->
    <div data-options="region:'west',collapsible:false" title='功能导航' style="width: 190px;">
	  <%@include file="inc/nav.inc"%>
    </div>
    
    <!-- 主体部分 -->
    <div data-options="region:'center',title:' 书籍管理 | 标签管理'" style="background:#f2f2ea none repeat scroll 0% 0%;">
      <%@include file="inc/label/label_field.inc"%>
      <%@include file="inc/label/dialog_label.inc"%>
    </div>
  </div>
</body>
</html>