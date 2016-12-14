<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <meta name="Generator" content="EditPlus®">
  <meta name="Author" content="">
  <meta name="Keywords" content="">
  <meta name="Description" content="">
  <title>Document</title>
 </head>
 <body>
  <div id="jsgl_grant_form">
  <c:forEach items="${list_auth_function }" var="data">
	<c:choose>
		<c:when test="${data.auth_function_status == 1 }"><input type="checkbox" name="auth_function_ck" value="${data.auth_function_id }" checked>${data.auth_function_name }</c:when>
		<c:otherwise><input type="checkbox" name="auth_function_ck" value="${data.auth_function_id }">${data.auth_function_name }</c:otherwise>
	</c:choose>
  </c:forEach>
  </div>
 </body>
</html>
