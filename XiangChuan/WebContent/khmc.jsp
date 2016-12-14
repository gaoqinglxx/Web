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
  <title>客户管理</title>
</head>
<body>
<script type="text/javascript">
	$(function(){
		$(".easyui-tree").tree({
			url:"khmc/getKhmc.do",
			loadFilter: function(rows) {//加载的原始数据。
				
				/* $(rows).each(function(i,v){
					console.log("rows==="+rows+"   i=="+i+"  v.id="+v.id+"  v.text="+v.text);
				}); */
  				return flg.convert(rows);
  			},onClick: function(node) {//点击一个节点触发
  				//console.log("node=="+node+"   node.id=="+node.id+"   node.text="+node.text);
  				$("#dd").datagrid({
  					 url: "gcmc/getGcmc/"+node.id+".do"  
  				});
  				
  				
  			},
  			onContextMenu:function(e,rows){//在右键点击节点的时候触发。
  				e.preventDefault();//禁止弹出浏览器鼠标右键默认效果
  				if($(".easyui-tree").tree("isLeaf",rows.target)){// 查找节点  判断指定的节点是否是叶子节点，target参数是一个节点DOM对象。
  					$("#menu_khmc").menu("show",{
  						left: e.pageX,
  						top: e.pageY,
  						onClick:function(item){  //点击菜单事件
  							if(item.text=="添加"){   //获取点击菜单的值
  								$("#dlg_add_khmc_error").hide();//隐藏
  								$("#dlg_add_khmc").dialog("open");
  							}else if(item.text=="编辑"){
  								$("#dlg_update_khmc_error").hide();
  								$("#dlg_update_khmc_name").val(rows.text);
  								$("#dlg_update_khmc_id").val(rows.id);
  								$("#dlg_update_khmc").dialog("open");
  							}else if(item.text=="删除"){
  								$.messager.confirm('提示','确认是否删除',function(r){
  									if(r){
  										$.post("khmc/deleteKhmc.do",{"khmc_id":rows.id},function(data){
  											if(data>0){
  												$(".easyui-tree").tree("reload");
  												$("#dd").datagrid("reload");
  											}
  										},"text");
  									}
  								});
  							}
  						}
  					});
  				}
  			}
		});
			/*点击对话框底部确定按钮,则更新工程信息操作*/
		 $("#updateGcmc").click(function() {
				$.post("gcmc/updateGcmc.do",{"gcmc_id":$("#dlg_update_gcmc_id").val(),"gcmc_name":$("#dlg_update_gcmc_name").val()},function(data){
					if(data == 1) {
						$('#dlg_update_gcmc').dialog('close');//更新成功,则关闭对话框
						$("#dd").datagrid("reload");
					} else {
						$("#dlg_update_gcmc_error").show();//显示提示的更新失败的信息
					}
				},"text");
			});
		
			/*点击对话框底部确定按钮,则添加工程信息操作*/
		 $("#addGcmc").click(function() {
			// console.log("khmc_id=="+$("#dlg_add_khmc_id").val()+"   gcmc_name=="+$("#dlg_add_gcmc_name").val());
				$.post("gcmc/addGcmc.do",{"khmc_id":$("#dlg_add_khmc_id").val(),"gcmc_name":$("#dlg_add_gcmc_name").val()},function(data){
					if(data == 1) {
						$('#dlg_add_gcmc').dialog('close');//添加成功,则关闭对话框
						$("#dd").datagrid("reload");
					} else {
						$("#dlg_add_gcmc_error").show();//显示提示的添加失败的信息
					}
				},"text");
			});
		/*添加客户*/
		$("#addKhmc").click(function(){
			$.post("khmc/addKhmc.do",{"khmc_name":$("#dlg_add_khmc_name").val()},function(data){
				if(data==1){
					$("#dlg_add_khmc").dialog("close");
					$(".easyui-tree").tree("reload");
				}else{
					$("#dlg_add_khmc_error").show();
				}
			},"text");
		});
		/*更新客户信息*/
		$("#updateKhmc").click(function(){
			$.post("khmc/updateKhmc.do",{"khmc_id":$("#dlg_update_khmc_id").val(),"khmc_name":$("#dlg_update_khmc_name").val()},function(data){
				if(data==1){
					$("#dlg_update_khmc").dialog("close");
					$(".easyui-tree").tree("reload");
				}else{
					$("#dlg_update_khmc_error").show();
				}
			},"text");
		});
	});
	
	//判断一个节点中有不有父节点
	//如果没有父节点，则返回false， 它就代表是整个树的根
	function exists(rows, parentId) {
		for(var i=0; i<rows.length; i++){
		if (rows[i].id == parentId)
			return true;
		}
			return false;
	}	
	/*formatter操作,实现删除和编辑功能*/
	function operation(value,row,index){
		var a="<a href='javascript:void(0);' onclick='delGcmc("+row.gcmc_id+")'>删除</a>";
		a+="&nbsp;";
		a+="<a href='javascript:void(0);' onclick='updateGcmc("+row.gcmc_id+",\""+row.gcmc_name+"\")'>编辑</a>";
		return a;
	}
	/*通过工程id删除工程*/
	 function delGcmc(gcmc_id){
		//console.log("gcmc_id="+gcmc_id);
		$.messager.confirm('提示','确定要删除此数据吗',function(r){
			if(r){
				$.post("gcmc/delGcmcById/"+gcmc_id+".do",function(data){
					if(data==1){
						$.messager.alert('提示','数据删除成功','info',function(){
							$("#dd").datagrid("reload");
						});
					}else{
						$.messager.alert('提示','数据删除失败');
					}
				},"text");
			}
		});
	} 
	/*更新工程信息,点击编辑则执行该方法,点击对话框的确定按钮则执行数据提交*/
	function updateGcmc(gcmc_id,gcmc_name){
		console.log("gcmc_id="+gcmc_id+"   gcmc_name="+gcmc_name);
		$("#dlg_update_gcmc").dialog("open");//打开会话框
  		$("#dlg_update_gcmc_name").val(gcmc_name);//用来设置表单域的值
  		$("#dlg_update_gcmc_id").val(gcmc_id);
	}
	/*批量删除工程*/
	function delBatchGcmc(){
		var rows=$("#dd").datagrid("getSelections");
		var gcmc_ids=[];//存储选择工程的id号
		//console.log("rows==="+rows);
		if(rows.length>0){
			$.messager.confirm('提示','确定要删除选中的数据',function(r){
				if(r){
					//遍历rows中选中行,把id存放在数组
					for(index in rows){
						gcmc_ids.push(rows[index].gcmc_id);
					}
					gcmc_ids=gcmc_ids.join("_");//将每个选项中id用_分割
					$.post("gcmc/delBatchGcmc/"+gcmc_ids+".do",function(data){
						if(data==1){
							$.messager.alert('提示','数据删除成功','info',function(){
								$("#dd").datagrid("reload");
							});
						}else{
							$.messager.alert('提示','数据删除失败');
						}
					},"text");
				}
			});
		}else{
			$.messager.alert('提示','未选中要删除的数据!');//消息窗口
		}
	}
	/*添加工程,点击添加执行该方法,点击确定执行添加操作*/
	function addGcmc(){
		var khmc_node=$(".easyui-tree").tree("getSelected");//获取选择节点并返回它
		if(khmc_node){
			$("#dlg_add_khmc_id").val(khmc_node.id);//用来设置表单域的值,选择的客户id
	  		$("#dlg_add_gcmc_khmc_name").text(khmc_node.text);
	  		$("#dlg_add_gcmc").dialog("open");//打开会话框
		}
	}
</script>	
	<div class="easyui-layout" data-options="fit:true">
		<div data-options="region:'west',title:'客户管理',width:180">
			<ul class="easyui-tree"></ul>
		</div>
		<div data-options="region:'center',title:'工程管理',width:180">
			<table id="dd" class="easyui-datagrid" data-options="fitColumns:true,fit:true,toolbar:'#d1',pagination:true,pageSize:10">
				<thead>
					<tr>
						<th data-options="field:'ck',width:100,checkbox:true"></th>
						<th data-options="field:'gcmc_id',width:100">工程编号</th>
						<th data-options="field:'gcmc_name',width:100">工程名称</th>
						<th data-options="field:'khmc_name',width:100">客户名称</th>
						<th data-options="field:'operation',width:100,formatter:operation">操作</th>
					</tr>										<!--单元格formatter(格式化器)函数，带3个参数  -->
				</thead>
			</table>
			<!-- 给datagrid添加toolbar -->
			<div id="d1" style="padding:5px;height:auto;">
				<a href="javascript:void(0);" class="easyui-linkbutton" onclick="javascript:addGcmc()" data-options="iconCls:'icon-add',plain:true">添加</a>
				<a href="javascript:void(0);" class="easyui-linkbutton" onclick="javascript:delBatchGcmc()" data-options="iconCls:'icon-remove',plain:true">删除</a>
			</div>
			 <!-- 编辑工程数据的对话框 -->																															<!-- 对话框底部按钮 -->		
			  <div id="dlg_update_gcmc" class="easyui-dialog" data-options="title:'编辑工程名称',modal:true,iconCls:'icon-edit',width:300,height:150,closed:true,buttons:'#dlg_update_gcmc_buttons'" style="text-align:center;">
			  	<p>
			  		<label>工程名称:</label><input id="dlg_update_gcmc_name" type="text"><input id="dlg_update_gcmc_id" type="hidden">
			  	</p>
			  	<!--更新失败的提示信息-->
			  	<p id="dlg_update_gcmc_error" style="display:none;">
			  		<span class="icon-no">&nbsp;&nbsp;</span><span style="color:red;">工程编辑失败</span>
			  	</p>
			  </div>
			  <!--更新工程对话框底部按钮-->
			  <div id="dlg_update_gcmc_buttons">
			  	<a id="updateGcmc" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">确定</a>
			  	<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="javascript:$('#dlg_update_gcmc').dialog('close');">取消</a>
			  </div>
			   <!-- 添加工程数据的对话框 -->																															<!-- 对话框底部按钮 -->		
			  <div id="dlg_add_gcmc" class="easyui-dialog" data-options="title:'添加工程名称',modal:true,iconCls:'icon-edit',width:300,height:150,closed:true,buttons:'#dlg_add_gcmc_buttons'" style="text-align:center;">
			  	
			  	<p>	<label>客户名称:</label><label id="dlg_add_gcmc_khmc_name">1111</label></p>
			  	<p>	<label>工程名称:</label><input id="dlg_add_gcmc_name" type="text"><input id="dlg_add_khmc_id" type="hidden"></p>
			  	
			  	<!--添加失败的提示信息-->
			  	<p id="dlg_add_gcmc_error" style="display:none;">
			  		<span class="icon-no">&nbsp;&nbsp;</span><span style="color:red;">工程添加失败</span>
			  	</p>
			  </div>
			  <!--添加工程对话框底部按钮-->
			  <div id="dlg_add_gcmc_buttons">
			  	<a id="addGcmc" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">确定</a>
			  	<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="javascript:$('#dlg_add_gcmc').dialog('close');">取消</a><!-- 点击取消,关闭对话框 -->
			  </div>
			  <!--客户管理的菜单    右键菜单定义如下-->	
			  <div id="menu_khmc" class="easyui-menu" style="width:100px;">
			  	<div data-options="iconCls:'icon-add'" >添加</div>
			  	<div data-options="iconCls:'icon-edit'">编辑</div>
			 	<div data-options="iconCls:'icon-remove'">删除</div>
			  </div>
			  <!-- 添加客户信息的对话框 -->
			  <div id="dlg_add_khmc" class="easyui-dialog" data-options="title:'添加新客户',modal:true,iconCls:'icon-edit',width:300,height:150,closed:true,buttons:'#dlg_add_khmc_buttons'" style="text-align:center;">
			  	<p>
			  		<label>客户姓名:</label><input id="dlg_add_khmc_name" type="text">
			  	</p>
			  	<!--添加失败的提示信息-->
			  	<p id="dlg_add_khmc_error" style="display:none;">
			  		<span class="icon-no">&nbsp;&nbsp;</span><span  style="color:red;">客户添加失败</span>
			  	</p>
			  </div>
			  <!--添加客户对话框底部按钮-->
			  <div id="dlg_add_khmc_buttons">
			  	<a id="addKhmc" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">确定</a>
			  	<a hre="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="javascript:$('#dlg_add_khmc').dialog('close');">取消</a>
			  </div>
			  <!-- 编辑客户数据的对话框 -->																															<!-- 对话框底部按钮 -->		
			  <div id="dlg_update_khmc" class="easyui-dialog" data-options="title:'编辑客户名称',modal:true,iconCls:'icon-edit',width:300,height:150,closed:true,buttons:'#dlg_update_khmc_buttons'" style="text-align:center;">
			  	<p>
			  		<label>客户名称:</label><input id="dlg_update_khmc_name" type="text"><input id="dlg_update_khmc_id" type="hidden">
			  	</p>
			  	<!--更新失败的提示信息-->
			  	<p id="dlg_update_khmc_error" style="display:none;">
			  		<span class="icon-no">&nbsp;&nbsp;</span><span style="color:red;">客户编辑失败</span>
			  	</p>
			  </div>
			  <!--更新工程对话框底部按钮-->
			  <div id="dlg_update_khmc_buttons">
			  	<a id="updateKhmc" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">确定</a>
			  	<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="javascript:$('#dlg_update_khmc').dialog('close');">取消</a>
			  </div>																							
		</div>
	</div>
</body>
</html>