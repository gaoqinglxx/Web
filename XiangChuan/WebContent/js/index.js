$(function(){
	initLeftMenu();
	bindListener();
});

function initLeftMenu(){     //解析左侧菜单
	$.each(_menus.menus,function(i,v){
		//console.log("i==="+i+"    v.menuname="+v.menuname);
		var menulist="";
		menulist+="<ul>";
		$.each(v.menus,function(k,j){
			//console.log("k="+k+"   j.menuname="+j.menuname);
			menulist+='<li><div><span class='+j.icon+'>&nbsp;&nbsp;</span><a rel='+j.url+'>'+j.menuname+'</a></div></li>';
		});
		menulist+="</ul>";
		$(".easyui-accordion").accordion("add",{ //添加一个新的面板
			title:v.menuname,
			content:menulist,
			iconCls:v.icon
		});
	});
	$(".easyui-accordion").accordion();
}

function bindListener(){   //点击菜单方法
	$(".easyui-accordion li").click(function(){
		var tabTitle=$(this).find("a").text();
		var url=$(this).find("a").attr("rel");
		//console.log("tabTitle==" +tabTitle+"   url=="+url);
		addTabs(tabTitle,url);//添加选项卡
	});
	
}

function addTabs(tabTitle,url){  //添加一个选项卡
	if(!$(".easyui-tabs").tabs("exists",tabTitle)){
		$(".easyui-tabs").tabs("add",{
			title:tabTitle,
			href:url,
			closable:true
		});
	}else{
		$(".easyui-tabs").tabs("select",tabTitle);//使用select方法来选中
		$(".easyui-tabs").tabs("getSelected").panel("refresh",url);//刷新面板来装载远程数据。如果'href'属性有了新配置，它将重写旧的'href'属性。
	}
	
}
var flg={
		
		convert(rows) {
	  		function exists(rows, parentId) {
	  			for(var i=0; i<rows.length; i++){
					if (rows[i].id == parentId) return true;
				}
				return false;
	  		}
	  		var nodes = [];
			for(var i=0; i<rows.length; i++){
				var row = rows[i];
				if (!exists(rows, row.parentId)){
					nodes.push({
						id:row.id,
						text:row.text,
						state:row.state
					});
				}
			}
			var toDo = [];
			for(var i=0; i<nodes.length; i++){
				toDo.push(nodes[i]);
			}
			while(toDo.length){
				var node = toDo.shift();// the parent node
				// get the children nodes
				for(var i=0; i<rows.length; i++){
					var row = rows[i];
					if (row.parentId == node.id){
						var child = {id:row.id,text:row.text};
						if (node.children){
							node.children.push(child);
						} else {
							node.children = [child];
						}
						toDo.push(child);
					}
				}
			}
			return nodes;
	  	}
}