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
  <title>四川湘川装饰工程有限公司-材料出入库系统</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/index.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-migrate-1.1.0.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.jqprint-0.3.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/icons/iconextension.css">
<style type="text/css">
	.easyui-accordion ul {
  		list-style-type: none;
  		padding: 0px;
  		margin: 0px;
  	}
  	.easyui-accordion ul li {
  		margin: 5px;
		line-height: 24px;  		
  	}
  	.easyui-accordion ul li div {
  		border: 1px solid #99BBE8;
    	     background: #E0ECFF;
    	     cursor: pointer;
    }
  /* 	.easyui-accordion ul li div.hover {
	    border: 1px dashed #99BBE8;
   	    background: #E0ECFF;
    	    cursor: pointer;
    }	 */
</style>
<script type="text/javascript">
var _menus = {
		"menus":[{
			"menuid" : "1",
			"icon" : "icon-server_start",
			"menuname" : "系统管理",
			"menus" : [{
				"menuname":"客户管理",
				"icon" : "icon-bullet_right",
				"url" : "khmc.do"
			},{
				"menuname":"原材料入库",
				"icon":"icon-bullet_right",
				"url": "yclrk.do"
			},{
				"menuname" : "货架管理",
				"icon" : "icon-bullet_right",
				"url" : "Hjcrk.do"
			},{
				"menuname" : "成品上架",
				"icon" : "icon-bullet_right",
				"url" : "cpsj.do"
			}, {
				"menuname" : "打印出库单",
				"icon" : "icon-bullet_right",
				"url" : "dyckd.do"
			}, {
				"menuname" : "原材料库存查询",
				"icon" : "icon-bullet_right",
				"url" : "searchyclrk.do"
			}, {
				"menuname" : "成品库存查询",
				"icon" : "icon-bullet_right",
				"url" : "sousuocp.do"
			}, {
				"menuname" : "用户管理",
				"icon" : "icon-bullet_right",
				"url" : "yhgl.do"
			}, {
				"menuname" : "功能模块管理",
				"icon" : "icon-bullet_right",
				"url" : "cdgl.do"
			}, {
				"menuname" : "角色管理",
				"icon" : "icon-bullet_right",
				"url" : "jsgl.do"
			}]
		}]
};
</script>
</head>
<body class="easyui-layout"  style="overflow-y:hidden" scroll="no"><!--布局     表示没有垂直滚动条 -->
 	<div data-options="region:'north',border:false" style="overflow: hidden; height: 30px; background: url(images/layout-browser-hd-bg.gif) #7f99be repeat-x center 50%; line-height: 30px; color: #fff; font-family: Verdana, 微软雅黑, 黑体">
 		<span style="float: right; padding-right: 20px;" class="head">欢迎admin</span>
 		<span style="padding-left: 10px; font-size: 16px;">
		<img src="images/blocks.gif" width="20" height="20" align="absmiddle" />四川湘川装饰工程有限公司
		</span>
 	</div>
 	<div data-options="region:'west',width:180,title:'导航菜单',collapsible:true">
 		<div class="easyui-accordion" data-options="fit:true,border:false"></div><!--分类 -->
 	</div>
 	<div data-options="region:'center'" style="overflow:hidden">
 		<div class="easyui-tabs" data-options="fit:true">
 			<div title="欢迎" style="padding:20px;overflow:hidden">
 				<h1>欢迎,admin</h1>
 			</div>
 		</div>
 	</div>
 </body>
</html>