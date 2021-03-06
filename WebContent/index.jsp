<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>管理员登录</title>
  <!-- 第三方样式文件 -->
  <link rel="stylesheet" type="text/css" href="insdep/easyui.css">
  <link rel="stylesheet" type="text/css" href="insdep/easyuiplus.css"/>

  <!-- 基于EasyUI框架的insdep样式-->
  <link rel="stylesheet" type="text/css" href="insdep/insdep_tables.css"/>
  <link rel="stylesheet" type="text/css" href="insdep/iconfont/iconfont.css"/>
  <link rel="stylesheet" type="text/css" href="insdep/insdep_theme_default.css"/>
  <script type="text/javascript" src="easyui/jquery.min.js"></script>
  <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
  <script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
  <script type="text/javascript" src="easyui/jquery-easyui-datagridview/datagrid-detailview.js"></script>

  <!-- 自定义脚本文件 -->
  <script type="text/javascript" src="admin/js/option.js"></script>
  <script type="text/javascript" src="admin/js/util.js"></script>	<!-- 工具 -->
</head>
<body>
  <div style="text-align:center;padding:300px;">
    <div class="fitem">
      <label>用户名:</label>
      <input id="name" name="name" class="easyui-textbox" style="width:180px"/>
    </div>
    <div class="fitem">
      <label>密码:</label>
      <input type="password" name="password" class="easyui-textbox" style="width:180px"/>
    </div>
    <div class="fitem">
      <a class="easyui-linkbutton" style="margin-left:50px" id="a_login">登　录</a>
    </div>
  </div>
</body>
<script type="text/javascript">
  $(document).ready(function(){
	$("#a_login").click(function(){
	  window.location.href = "/novel/admin/bookshop.jsp";
	})
  })
</script>
</html>