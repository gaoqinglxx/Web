<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <meta name="Generator" content="EditPlus®">
  <meta name="Author" content="">
  <meta name="Keywords" content="">
  <meta name="Description" content="">
  <title>用户管理</title>
 </head>
 <body>
 	<script type="text/javascript">
 	function operationAuthUser(value,row,index) {
  		var a = "<a href='javascript:void(0);' onclick='delAuthUser("+row.auth_user_id+")'>删除</a>";
  		a += "&nbsp;"
  		a += "<a href='javascript:void(0);' onclick='updateAuthUser("+row.auth_user_id+",\""+row.auth_user_name+"\")'>编辑</a>";
  		a += "&nbsp;"
  		a += "<a href='javascript:void(0);' onclick='editGrantAuthUser("+row.auth_user_id+")'>分配权限</a>";
  		return a;
  	}
 	
 	function editGrantAuthUser(auth_user_id) {
 		$.post("authrole/getAuthRoleForSelect.do",function(data){
 			$("#dlg_add_yhgl_auth_role_id").empty();
 			$(data).each(function(i,v) {
 				$("#dlg_add_yhgl_auth_role_id").append('<option value="'+v.auth_role_id+'">'+v.auth_role_name+'</option>');
 			})
 		},"json");
 		$("#dlg_add_yhgl_auth_user_id").val(auth_user_id);
 		$("#dlg_add_yhgl").dialog("open");
 	}
 	
 	$(function() {
 		$("#addYhgl").click(function() {
 			var auth_user_id = $("#dlg_add_yhgl_auth_user_id").val();
 			var auth_role_id = $("#dlg_add_yhgl_auth_role_id").val();
 			$.post("authuserrole/updateAuthUserRole/"+auth_user_id+"/"+auth_role_id+".do",function(data){
 				if (data == 1) {
 					$.messager.alert('提示','角色分配成功','info',function() {
 						$("#dlg_add_yhgl").dialog("close");
 					});
 				} else {
 					$.messager.alert('提示','角色分配失败','info',function() {
 						$("#dlg_add_yhgl").dialog("close");
 					});
 				}
 			},"text");
 		});
 	});
 	</script>
  	<table id="dd_yhgl" class="easyui-datagrid" data-options="title:'系统管理 > 用户管理',fit:true,fitColumns:true,pagination:true,pageSize:10,toolbar:'#toolbar_yhgl',url:'authuser/getAuthUser.do'">
  		<thead>
  			<tr>
				<th data-options="field:'ck',width:100,checkbox:true"></th>
				<th data-options="field:'auth_user_id',width:100">用户编号</th>
				<th data-options="field:'auth_user_name',width:100">用户名称</th>
				<th data-options="field:'operation',width:100,formatter:operationAuthUser">操作</th>
			</tr>
  		</thead>
  	</table>
  	<!-- 给datagrid添加toolbar -->
	<div id="toolbar_yhgl">
	  <a id="toolbar_addYhgl" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:'true'">添加</a>
	  <a id="delBathYhgl" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:'true'">删除</a>
	  <a id="addRoleYhgl" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-2012080412263',plain:'true'">用户授权</a>
	</div>
	
	<!-- 添加用户权限分配的窗口 -->
  <div id="dlg_add_yhgl" class="easyui-dialog" data-options="title:'用户权限分配',modal:true,iconCls:'icon-add',width:300,height:150,closed:true,buttons:'#dlg_add_yhgl_buttons'" style="text-align:center;">
  	<p>
  		<label>角色名称:</label><select id="dlg_add_yhgl_auth_role_id"></select><input type="hidden" id="dlg_add_yhgl_auth_user_id">
  	</p>
  </div>
  <div id="dlg_add_yhgl_buttons">
  	<a id="addYhgl" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">确定</a>
    <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="javascript:$('#dlg_add_yhgl').dialog('close');">取消</a>
  </div>
 </body>
</html>
