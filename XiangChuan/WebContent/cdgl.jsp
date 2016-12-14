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
  <title>功能模块管理</title>
 </head>
 <body>
  <script type="text/javascript">
  	$(function() {
  		$("#tt_cdgl").tree({
  			url: "authfunction/getAuthFunction.do",
  			animate: true,
  			loadFilter: function(rows) {
  				return flg.convert(rows);
  			},
  			onClick: function(rows) {//在用户点击一个节点的时候触发。
  				$("#dd_cdgl").datagrid({   //resu ful风格传递参数
  					url: "authfunction/getAuthFunctionById/"+rows.id+".do"
  				});
  			}
  		})
  	});
  </script>
  <div class="easyui-layout" data-options="fit:true">
  	<div data-options="region:'west',width:180,title:'功能模块管理'">
  		<ul id="tt_cdgl" class="easyui-tree"></ul>
  	</div>
  	<div data-options="region:'center',fit:true,title:'节点列表'">
  		<table id="dd_cdgl" class="easyui-datagrid" data-options="fit:true,fitColumns:true,pagination:true,pageSize:10,toolbar:'#toolbar_cdgl'">
  			<thead>
  				<tr>
					<th data-options="field:'ck',width:100,checkbox:true"></th>
					<th data-options="field:'auth_function_id',width:100">功能更模块编号</th>
					<th data-options="field:'auth_function_name',width:100">功能模块名称</th>
					<th data-options="field:'auth_function_url',width:100">功能模块URL</th>
					<th data-options="field:'operation',width:100">操作</th>
				</tr>
  			</thead>
  		</table>
  	</div>
  </div>
  <!-- 给datagrid添加toolbar -->
  <div id="toolbar_cdgl">
  	<a id="toolbar_addCdgl" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:'true'">添加</a>
  	<a id="delBathCdgl" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:'true'">删除</a>
  </div>
 </body>
</html>
    