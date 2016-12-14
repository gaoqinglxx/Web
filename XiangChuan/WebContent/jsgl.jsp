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
  <title>角色管理</title>
 </head>
 <body>
   <script type="text/javascript">
  	$(function() {
  		$("#dd_jsgl").datagrid({
  			onSelect:function(rowIndex,rowData) {  //角色被选中了,就获取它的权限
  				$("#panel_jsgl").panel({
  					href:"authrolefunction/getAuthRoleFunctionById/"+rowData.auth_role_id+".do"
  				});
  			}
  		});
  		//点击分配权限
  		$("#grantJsgl").click(function() {
  			var rows = $("#dd_jsgl").datagrid("getSelected");
  			if (rows) {
  				grantJsgl(rows.auth_role_id);//角色被选中了,就执行权限更新操作
  			} else {
  				$.messager.alert('提示','没有选中要分配权限的角色');
  			}
  		});
  		
  	});
  	
  	function grantJsgl(auth_role_id) {  //角色权限更新操作
  		var grant_checked = [];
  		$("#jsgl_grant_form :checkbox").each(function(i,v) {
  			if ($(this).is(":checked")) {
  				grant_checked.push($(this).val());
  			}
  		});
  		grant_checked = grant_checked.join(",");
  		//提交的分配权限的请求到AuthRoleFunctionController
  		//1.没有分配权限, 完成insert操作
  		//2.已经分配权限, 完成update操作
  		$.post("authrolefunction/updateAuthRoleFunction.do", {"auth_role_id": auth_role_id, "auth_function_id": grant_checked},function(data) {
  			if (data == 1) {
  				$.messager.alert('提示','权限分配成功');
  			} else {
  				$.messager.alert('提示','权限分配失败');
  			}
  		},"text");
  	}
  </script>
  <div class="easyui-layout" data-options="fit:true">
  	<div data-options="region:'north',height:250,title:'角色管理',collapsible:false">
  		<table id="dd_jsgl" class="easyui-datagrid" data-options="fit:true,fitColumns:true,pagination:true,pageSize:10,toolbar:'#toolbar_jsgl',url:'authrole/getAuthRole.do',singleSelect:true">
  			<thead>
  				<tr>
					<th data-options="field:'ck',width:100,checkbox:true"></th>
					<th data-options="field:'auth_role_id',width:100">角色编号</th>
					<th data-options="field:'auth_role_name',width:100">角色名称</th>
					<!-- <th data-options="field:'operation',width:100,formatter:operationGrantJsgl">操作</th> -->
				</tr>
  			</thead>
  		</table>
  		<!-- 给datagrid添加toolbar -->
		<div id="toolbar_jsgl">
		  <a id="toolbar_addJsgl" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:'true'">添加</a>
		  <a id="delBathJsgl" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:'true'">删除</a>
		  <a id="grantJsgl" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-2012080412263',plain:'true'">分配权限</a>
		</div>
  	</div>
  	<div data-options="region:'center',title:'角色权限分配管理'" style="padding:20px;">
  		<div id="panel_jsgl" class="easyui-panel" data-options="fit:true,border:false ,href:'authfunction/getAuthFunctionModel.do' "></div>
  	</div>
  </div>
 </body>
</html>
