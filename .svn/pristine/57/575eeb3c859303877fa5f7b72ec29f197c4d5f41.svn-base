<div id="dlg_user" class="easyui-dialog" data-options="closable:false,title:'读者管理',buttons:'#bt_dlg_user'" style="width:550px;height:300px;padding:10px;overflow:hidden" closed="true" >
  <div style="float:left;width:60%;height:100%;">
  <form id="fm_user" method="post">
    <div class="fitem">
      <input name="id" id="dlg_id" type="hidden">
    </div>
    <div class="fitem">
      <label>账号:</label>
      <input id="txt_dlg_userName" name="userName" class="easyui-textbox" style="width:240px" prompt="必填项" />
    </div>
    <div class="fitem">
      <label>昵称:</label>
      <input id="txt_dlg_name" name="name" class="easyui-textbox" style="width:240px" prompt="必填项" />
    </div>
    <div class="fitem">
      <label>性别:</label>
      <input id="cmb_dlg_sex" name="sex" class="easyui-combobox" style="width:240px" data-options="url:'jsondata/user_sex.json',valueField:'id',textField:'text',editable:false" />
    </div>
    <div class="fitem" id="dlgImg">
      <label>头像地址:</label>
      <input id="dlg_url" type="hidden">
      <input id="txt_dlg_imgUrl" name="headUrl" class="easyui-textbox" style="width:155px" prompt="必填项" />
      <a class="easyui-linkbutton" data-options="iconCls:'icon-upload'" id="a_upload" style="height:21px;">上传</a>
    </div>
    <div class="fitem">
      <label>个性签名:</label>
      <textarea id="txt_dlg_signature" name="signature" class="easyui-textbox" data-options="multiline:true" style="width:240px;height:76px;"></textarea>
    </div>
  </form>
  </div>
  <div style="float:left;width:40%;height:100%;">
    <div class="fitem">
      <label>头像预览:</label>
      <div class="imgHeadBox" id="imgHeadBox"></div>
    </div>
  </div>
</div>
  <div id="bt_dlg_user">
    <a class="easyui-linkbutton" iconCls="icon-email" id="a_save">保存</a>
    <a class="easyui-linkbutton" iconCls="icon-no" onclick="javascript:$('#dlg_user').dialog('close')">关闭</a>
  </div>