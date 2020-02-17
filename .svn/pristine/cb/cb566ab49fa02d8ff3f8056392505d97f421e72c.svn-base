/**
 * <summary>各类操作相关脚本</summary>
 * <param name="addRecord()">添加
 * <param name="deleteRecords()">删除
 * <param name="updateRecord()">修改
 * <param name="saveRecord("#a_save")">保存
 * <param name="searchRecords()">查询
 * <param name="exportRecords()">导出
 * <param name="xxxFormatter()">数据格式化
 * $.messager.alert("警告","警告语句","warning")
 * $.messager.alert("提示","提示语句","info")
*/

/** 
 * <summary>id命名规范</summary>
 * <param name="jspName.jsp">JSP文件名，其中jspName与该页面对应的数据表同名
 * 
 * <summary>常量及变量的命名必须与所在文件的文件名保持一致</summary>
 * <param type="dialog" id="dlg_jspName.inc">JSP文件中的对话框片段
 * <param type="form" id="fm_jspName">JSP文件中的表单
 * <param type="table" id="tbl_jspName">JSP文件中的表格
 * <param type="toolbar" id="tb_jsp|inc文件名_buttons">表格中的工具栏
 * <param type="combobox" id="cmb_对应字段名">jsp文件中的下拉框
 * <param type="combobox" id="combo_对应字段名">inc文件中的下拉框
 * <param type="textbox" id="txt_对应字段名">jsp文件中的文本框
 * <param type="textbox" id="txt_dlg_对应字段名">dialog片段中的文本框
 * <param type="numberbox" id="num_对应字段名">jsp文件中的数字框
 * <param type="numberbox" id="num_dlg_对应字段名">dialog片段中的数字框
 * 
 * <summary>命名示例<\summary>
 * <jsp name="employee.jsp">名为employee的jsp文件
 * <inc belong="employee.jsp" name="dialog_employee.inc">jsp中名为dialog_employee的inc文件
 * <div belong="dialog_employee.inc" id="dlg_employee">dialog_employee.inc中顶层div的id
 * <form belong="dialog_employee.inc" id="fm_employee">dialog_employee.inc中form的id
 * <table belong="dialog_employee.inc" id="tbl_employee">dialog_employee.inc中table的id
 * <toolbar belong="dialog_employee.inc" id="$('#tb_dlg_employee')">dialog_employee.inc中的toolbar
 * 
 * <summary>引用示例</summary>
 * <param name="$("#dlg_"+fileName)">对象的引用方式
 * 即employee.jsp中顶层div的引用方式为"$('#dlg_employee')"
*/

/**
 * <summary>变量初始化</summary>
*/
//全局变量
var fileName = ""; //接收参数
var QueryUrl = "";
var AddUrl = "";
var UpdateUrl = "";
var DeleteUrl = "";
var ExportUrl = "";
var UploadUrl = "";
var ImportUrl = "";
var ActionUrl = "";
var strQuery = "";
var fmName = "";
var tblName = "";
var dlgName = "";

/**
 * <summary>点击“查找”时执行查询</summary>
 *<param strQuery>拼接的condition，作为查询条件字符串
 *<param exp="$('#cmb').combobox('getValue')">取combobox的id值
 *<param exp="$('#cmb').combobox('getText')">取combobox的name值
 *<param exp="$("#txt_value").val()">取textbox的value值
*/
function setCondition(fileName){
  var elemId = "";//节点id
  var elemName = "";//节点name对应的字段名，例如：节点名称为cmb_sex，则elemName='sex'
  var elemClass = "";//节点class
  var elemCondition = "";//由elemId分割的数组。例如：elemId为employeeId_name_py，则elemCondition={"employeeId"，"name"，"py"}，用于将来的condition拼接
  var strText = "";//保存textbox拼接的condition
  var strCombo = "";//保存combobox拼接的condition
  var strNum = "";//保存numberspinner拼接的condition
  var strDate = "";//保存easyui-datebox拼接的condition
  //文本框用于多列查询，拼接条件为or，其他控件之间均为and
  //所以文本框用strText来单独拼接
  var startDate = "";//保存开始日期
  var endDate = "";//保存结束日期
  var flag = 0;//保存datebox是否存在的状态：0-不存在；1-存在
  var elemName1 = "";//datebox节点name对应的字段名，例如：节点名称为dt_entryDate_start，则elemName1='entryDate'
  var elemName2 = "";//datebox节点name对应的字段名，例如：节点名称为dt_entryDate_start，则elemName2='start'
  //获取id=span_searchCondition每个input子节点
  $('#span_searchCondition>input').each(function(i,val){
    elemId = $(this).attr('id');
    elemName = elemId.split("_")[1];
    elemClass = $(this).attr('class').split(" ")[0];
    if(elemClass == "easyui-textbox" && $(this).val()!= ""){//拼接textbox中的condition
      elemCondition = elemId.split("_");
      //遍历elemCondition数组，并拼接条件
      strText += " and(";
      for(k in elemCondition){
        if(k != 0){strText += " or ";}
        strText += fileName + "." + elemCondition[k] + " like \'%" + $(this).val()+ "%\'";
      }
      strText += ")";
    }else if(elemClass == "easyui-combobox"){//拼接combobox中的condition
      var cmbValue = $(this).combobox('getValue');
      if(cmbValue != ""){strCombo += " and "+ fileName + "." + elemName + " = '" + cmbValue+"'";}
    }else if(elemClass == "easyui-numberspinner"){//拼接numberspinner中的condition
      var nspValue = $(this).val();
      if(nspValue != ""){strNum += " and "+ fileName + "." + elemName + " = " + nspValue;}
    }else if(elemClass == "easyui-datebox"){//拼接easyui-datebox中的condition
      var dateText = $(this).datebox('getValue');
      elemName1 = elemId.split("_")[1];
      elemName2 = elemId.split("_")[2];
      if(elemName2.toString()== "start"){
        if(dateText == ""){startDate = "0000-00-00";}
        else{startDate = dateText;}
      }else if(elemName2.toString()== "end"){
        if(dateText == ""){endDate = "9999-12-31";}
        else{endDate = dateText;}
      }
    }
  });
  if(elemName1 != ""){
    strDate = " and " + fileName + "." + elemName1 + " between \'" + startDate + "\' and \'" + endDate +"\'";
  }
  strQuery =(strCombo + strNum + strDate + strText).substring(4);//去掉最前面的" and "
  console.log(strQuery)
  $("#hid_relation").attr("value",strQuery);//将拼接的条件字符串保存到隐藏域 
}

/**
* <summary>input中禁止输入特殊字符</summary>
*/
var isSpecialChar;
var val;
function specialChar(str){
 isSpecialChar = true;
 $(str+">input").each(function(){//遍历指定元素下所有的input 
  if(isSpecialChar == false){return}
   val = $(this).val();
   if(val == "" || val == null){
     isSpecialChar = true;
   }else{
     var reg = /^[<>\"&\'\%]+$/;//不允许特殊字符
     var isError = reg.test(val);
     if(isError){isSpecialChar = false;
     alert($(this).attr("id"));return;}
   }
 });
}

/**
 * <summary>查询</summary>
 * 本来打算在查询的回调函数中对响应的结果data进行处理，将data中的null转换为空串
 * 但是之后的增删改操作都无法再刷新datagrid
 * 考虑原因，可能是datagrid已将数据封装，无法再通过reload刷新修改后的数据
 * 此方法暂时弃用，将处理方法移至各formatter中执行
*/
function searchRecords(tblName,QueryUrl){
  var condition = $("#hid_relation").attr("value");
  //判断用户输入数据的合法性
  specialChar("#span_searchCondition");
  if(!isSpecialChar){$.messager.alert("警告","输入的内容包含非法字符","warning");return;}
  $(tblName).datagrid({
    url:QueryUrl,
    queryParams:{"condition":condition},
    onLoadSuccess:function(data){}
  });
}