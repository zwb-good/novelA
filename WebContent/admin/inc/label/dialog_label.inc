  <div id="dlg_label" class="easyui-dialog" data-options="closable:false,title:'标签管理',buttons:'#bt_dlg_label'" style="width:350px;height:146px;padding:10px;overflow:hidden" closed="true" >
    <form id="fm_label" method="post">
      <div class="fitem">
        <input name="id" id="dlg_id" type="hidden">
      </div>
      <div class="fitem">
        <label>标签名称:</label>
        <input id="txt_dlg_name" name="name" class="easyui-textbox" style="width:236px" prompt="必填项" />
      </div>
    </form>
  </div>
  <div id="bt_dlg_label">
    <a class="easyui-linkbutton" iconCls="icon-email" id="a_save">保存</a>
    <a class="easyui-linkbutton" iconCls="icon-no" onclick="javascript:$('#dlg_label').dialog('close')">关闭</a>
  </div>