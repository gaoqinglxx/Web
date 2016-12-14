<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <meta name="Generator" content="EditPlus?">
  <meta name="Author" content="">
  <meta name="Keywords" content="">
  <meta name="Description" content="">
  <title>原材料入库</title>
 </head>
 <body>
 <script type="text/javascript">
 	//formatter格式化器
 	function barcode(value,row,index){
 		 if(row.yclrk_barcode_iscreate=="否"){
 			return "<a href='javascript:yclrkCreateCode("+row.yclrk_no+");' >生成条形码</a>";
 		}else{
 			return "<a href='javascript:yclrkShowBarCode("+row.yclrk_no+");'>查看条形码</a>";
 		} 
 	}
 	//生成条形码操作
 	function yclrkCreateCode(yclrk_no){
 		$.messager.confirm('提示','是否要生成条形码',function(r){
 			if(r){
 				$.post("yclrk/createCode.do",{"yclrk_no":yclrk_no},function(data){
 					if(data==1){
 						$.messager.alert('提示','编号:'+yclrk_no+'的条形码生成ok','info',function(){
 							$("#dg_yclrk").datagrid("reload");
 						});
 					}else{
 						$.messager.alert('提示','编号:'+yclrk_no+'的条形码生成失败');
 					}
 				},"text");
 			}
 		});
 	}
 	//查看条形码
 	function yclrkShowBarCode(yclrk_no){
 		var tabs = $(".easyui-tabs").tabs("getSelected");
		  if (tabs) {
			  //刷新面板来装载远程数据。如果'href'属性有了新配置，它将重写旧的'href'属性。
			  tabs.panel("refresh","yclrk/getTxm.do?yclrk_no="+yclrk_no);
		  }
 	}
 </script>
  <table id="dg_yclrk" class="easyui-datagrid" data-options="title:'系统管理 > 原材料入库',fit:true,fitColumns:true,rownumbers:true,pagination:true,pageSize:10,url:'yclrk/getYclrk.do'">
  	<thead>
  		<tr>
  			<th data-options="field:'ck',width:100,checkbox:true"></th>
			<th data-options="field:'yclrk_no',width:100">原材料编号</th>
			<th data-options="field:'yclrk_material_name',width:100">原材料名称</th>
			<th data-options="field:'khmc_name',width:100">客户名称</th>
			<th data-options="field:'gcmc_name',width:100">工程名称</th>
			<th data-options="field:'yclrk_standard_width',width:100">规格（宽）</th>
			<th data-options="field:'yclrk_standard_height',width:100">规格（高）</th>
			<th data-options="field:'yclrk_time',width:160">入库时间</th>
			<th data-options="field:'yclrk_amount',width:100">总数量</th>
			<th data-options="field:'yclrk_shelves',width:100">是否上架</th>
			<th data-options="field:'yclrk_barcode_iscreate',width:100">是否生成条形码</th>
			<th data-options="field:'operation',width:100,formatter:barcode">操作</th>
  		</tr>
  	</thead>
  </table>
 </body>
</html>
