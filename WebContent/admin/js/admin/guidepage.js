/*---------------------------页面初始化代码--------------------------------*/
/**
 * <summary>页面加载时获取引导页信息</summary>
 */
$(document).ready(function(){
  var objName = "#tbl_guidepage";
  var URL = "GuidepageAction/get.do";
  searchRecords(objName,URL);
})

/*---------------------------页面按钮相关代码--------------------------------*/
/**
 * <summary>点击查询按钮事件</summary>
 */
$(document).ready(function(){
  $("#a_search").click(function(){
    alert("you chose a_search!")
  })
})

/**
 * <summary>点击添加按钮事件</summary>
 */
$(document).ready(function(){
  $("#a_insert").click(function(){
	$("#dlg_guidePage").dialog("open");
  })
})

/**
 * <summary>点击修改按钮事件</summary>
 */
$(document).ready(function(){
  $("#a_update").click(function(){
	$("#dlg_guidePage").dialog("open");
  })
})

/**
 * <summary>点击删除按钮事件</summary>
 */
$(document).ready(function(){
  $("#a_delete").click(function(){
	alert("you chose a_delete!")
  })
})

/*---------------------页面dialog对话框按钮相关代码--------------------------*/