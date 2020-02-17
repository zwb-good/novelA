  <div id="dlg_bookshop" class="easyui-dialog" data-options="closable:false,title:'书城页面',buttons:'#bt_dlg_bookshop'" style="width:550px;height:350px;padding:10px;overflow:hidden" closed="true" >
    <div style="overflow:hidden;width:256px;height:100%;display:inline-block;float:left">
      <form id="fm_bookshop" method="post">
        <div class="fitem">
          <input name="id" id="bookshopId" type="hidden">
          <input name="bookId" id="bookId" type="hidden">
        </div>
        <div class="fitem">
          <label>所属栏目:</label>
          <input id="txt_dlg_position" name="position" class="easyui-combobox" style="width:180px" data-options="url:'jsondata/bookshop_position.json',valueField:'id',textField:'text',editable:false" />
        </div>
        <div class="fitem">
          <label>小说名称:</label>
          <input id="txt_dlg_book" name="name" class="easyui-textbox" style="width:180px" prompt="双击右侧列表添加" data-options="editable:false"/>
        </div>
      </form>
      <div class="fitem">
        <label>封面预览:</label>
        <div class="imgBox" id="imgBox">
        </div>
      </div>
    </div>
    <div style="width:256px;height:100%;margin-left:10px;display:inline-block;overflow:hidden;float:left">
      <table class="easyui-datagrid" id="dlg_tbl_book" title="操作提示：双击列表项添加小说" data-options="toolbar:'#tb_dlg_book',fit:true,onDblClickRow:addToBookshop">
        <thead>
          <tr>
            <th data-options="field:'selector',checkbox:true"></th>
      		<th data-options="field:'id',width:50,halign:'center',align:'center',hidden:true">编号</th>
      		<th data-options="field:'name',width:220,halign:'center',align:'center'">书名</th>
	      </tr>
        </thead>
      </table>
      <div id="tb_dlg_book">
    	<input class="easyui-textbox" style="width:150px;" id="book_name" name="book_name" data-options="prompt:'输入书名快速查找'"/>
    	<a class="easyui-linkbutton" iconCls="icon-search" id="a_text">查找</a>
	  </div>
    </div>
  </div>
  <div id="bt_dlg_bookshop">
    <a class="easyui-linkbutton" iconCls="icon-email" id="a_save">保存</a>
    <a class="easyui-linkbutton" iconCls="icon-no" onclick="javascript:$('#dlg_bookshop').dialog('close')">关闭</a>
  </div>