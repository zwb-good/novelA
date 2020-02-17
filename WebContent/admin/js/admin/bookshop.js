/*---------------------------页面初始化代码--------------------------------*/
/**
 * <summary>页面加载时获取引导页信息</summary>
 */
$(document).ready(function(){
  var objName = "#tbl_bookshop";
  var URL = "BookshopAction/getBook.do";
  searchRecords(objName,URL);
})

//格式化位置
function formatPosition(val,row){
  var position = row.position;
  switch(position){
    case 0:
      val = "精品推荐";
      break;
    case 1:
      val = "最好看的书";
      break;
    case 2:
      val = "口碑精选";
      break;
    case 3:
      val = "猜你喜欢";
      break;
  }
  return val;
}

//格式化书名
function formatBookName(val,row){
  val = row.book.name;
  return val;
}

//格式化作者
function formatAuthor(val,row){
  val = row.book.author;
  return val;
}
/*---------------------------页面按钮相关代码--------------------------------*/
var op; //1-添加;2-修改;

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
	$("#fm_bookshop").form("reset");//清除表单数据
	$("#bookId").val("");
	$("#bookshopId").val("");
	getBook();
	$("#dlg_bookshop").dialog("open");
	op = 1;
  })
})

/**
 * <summary>点击修改按钮事件</summary>
 */
$(document).ready(function(){
  $("#a_update").click(function(){
	$("#fm_bookshop").form("reset");//清除表单数据
	var row = $("#tbl_bookshop").datagrid("getSelected");
    if (row == null){showMessage("提示","请选择需要修改的记录",2000);return;}
    getBook();
	var bookshopId = row.id;
	var bookId = row.bookId;
	var bookName = row.book.name;
	var position = row.position;
	var url = row.book.url + '/img';
	var code = '<img src="'+url+'" alt="" class="div-img">';
	$("#imgBox").html(code);
	$("#bookId").val(bookId);
	$("#bookshopId").val(bookshopId);
	$("#txt_dlg_book").textbox('setValue',bookName);
	var data = $('#txt_dlg_position').combobox('getData');
	var dex = 0;
	switch(position){
	  case 0:
	    dex = 1; 
	    break;
	  case 1:
	    dex = 2;
	    break;
	  case 2:
	    dex = 3;
	    break;
	  case 3:
	    dex = 4;
	    break;
	}
	$("#txt_dlg_position").combobox('select',data[dex].id);
	//console.log("bookshopId = "+bookshopId+"bookId = "+bookId+"position = "+position)
    $("#dlg_bookshop").dialog("open");
	op = 2;
  })
})

//获取数据库小说
function getBook(){
  var objName = "#dlg_tbl_book";
  var URL = "BookAction/select.do";
  searchRecords(objName,URL);
}
/**
 * <summary>点击删除按钮事件</summary>
 */
$(document).ready(function(){
  $("#a_delete").click(function(){
	var row = $("#tbl_bookshop").datagrid("getSelected");
    if(row <= 0){showMessage("提示","请选择需要删除的记录",2000);return;}
    var id = row.id;
    $.messager.confirm('提示', '确认要删除吗?', function(r){
        if(r){
          $.post("BookshopAction/delete.do",{ids:id},function(result){
            var data = JSON.parse(result);
            showMessage("提示",data.msg,2000);
            $("#tbl_bookshop").datagrid("reload");  
          });
        }
      });
  })
})

/*---------------------页面dialog对话框按钮相关代码--------------------------*/
//双击添加小说
function addToBookshop(index,row){
  var name = row.name;
  var id = row.id;
  var url = row.url+'/img';
  $("#txt_dlg_book").textbox('setValue',name);
  $("#bookId").val(id);
  var code = '<img src="'+url+'" alt="" class="div-img">';
  $("#imgBox").html(code);
}

/**
 * <summary>点击保存按钮事件</summary>
 */
$(document).ready(function(){
  $("#a_save").click(function(){
	var temp = $("#txt_dlg_position").combobox('getValue');
	var position = parseInt(temp) - 1;
	var bookId = $("#bookId").val();
	if(op == 1){
	  $.post(
		"BookshopAction/insert.do",
		{position:position,bookId:bookId},
		function(result){
		  var data = JSON.parse(result);
		  var success = data.success;
		  showMessage("提示",data.msg,2000);
		  if (success){
            $("#tbl_bookshop").datagrid("reload");  
            $("#dlg_bookshop").dialog("close"); 
          }  
		}
	  )
	}
	if(op == 2){
	  var bookshopId = $("#bookshopId").val();
	  $.post(
		"BookshopAction/update.do",
		{position:position,bookId:bookId,id:bookshopId},
		function(result){
		  var data = JSON.parse(result);
		  var success = data.success;
		  showMessage("提示",data.msg,2000);
		  if (success){
		    $("#tbl_bookshop").datagrid("reload");  
		    $("#dlg_bookshop").dialog("close"); 
		  }  
		}
	  )
	}
  })
})