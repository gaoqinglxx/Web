<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>条形码打印</title>
</head>
<body>
<script type="text/javascript">
	function showTxm(){
		$("#dyTxm").jqprint();//打印预览
	}
</script>
	<div>
		<button onclick="javascript:showTxm();" style="margin:10px;cursor:pointer;">打印条形码</button>
		<button>保存到本地</button>
	</div>
	<div id="dyTxm">
		<c:forEach items="${yclrk_barcode_path }" var="path">
		<img src="${pageContext.request.contextPath}${path}"/>	
	</c:forEach>
	</div>
</body>
</html>