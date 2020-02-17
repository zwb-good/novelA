/*---------------------------页面初始化代码--------------------------------*/
/**
 * <summary>页面加载时获取引导页信息</summary>
 */
$(document).ready(function(){
  var objName = "#tbl_label";
  var URL = "LabelAction/get.do";
  searchRecords(objName,URL);
})

/*---------------------------页面按钮相关代码--------------------------------*/
var op; //1-添加;2-修改;

/**
 * <summary>点击添加按钮事件</summary>
 */
$(document).ready(function(){
  $("#a_insert").click(function(){
	$("#fm_label").form("clear");//清除表单数据
	$("#dlg_label").dialog("open");
	op = 1;
  })
})

/**
 * <summary>点击修改按钮事件</summary>
 */
$(document).ready(function(){
  $("#a_update").click(function(){
	$("#fm_label").form("clear");//清除表单数据
	var row = $("#tbl_label").datagrid("getSelected");
    if (row == null){showMessage("提示","请选择需要修改的记录",2000);return;}
    $("#fm_label").form("load",row);
    $("#dlg_label").dialog("open");
    op = 2;
  })
})

/**
 * <summary>点击删除按钮事件</summary>
 */
$(document).ready(function(){
  $("#a_delete").click(function(){
	var row = $("#tbl_label").datagrid("getSelected");
    if (row == null){showMessage("提示","请选择需要删除的记录",2000);return;}
    var id = row.id;
    $.messager.confirm('提示', '确认要删除吗?', function(r){
      if(r){
        $.post("LabelAction/delete.do",{ids:id},function(result){
          var data = JSON.parse(result);
          showMessage("提示",data.msg,2000);
          $("#tbl_label").datagrid("reload");  
        });
      }
    })
  })
})

/*---------------------页面dialog对话框按钮相关代码--------------------------*/
$(document).ready(function(){
  $("#a_save").click(function(){
	var name = $("#txt_dlg_name").textbox('getValue');
	console.log("name = "+name)
	if(op == 1){
	  $.post(
		"LabelAction/insert.do",
		{name:name},
		function(result){
		  var data = JSON.parse(result);
		  var success = data.success;
		  showMessage("提示",data.msg,2000);
		  if (success){
			$("#tbl_label").datagrid("reload");  
            $("#dlg_label").dialog("close");
	      }  
		}
	  )
	}
	if(op == 2){
	  var id = $("#dlg_id").val();
	  $.post(
		"LabelAction/update.do",
		{name:name,id:id},
		function(result){
		  var data = JSON.parse(result);
		  var success = data.success;
		  showMessage("提示",data.msg,2000);
		  if (success){
			$("#tbl_label").datagrid("reload");  
		    $("#dlg_label").dialog("close");
		  }  
		}
	  )
	}
  })
})