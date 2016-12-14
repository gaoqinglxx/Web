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
  <title>角色权限分配表</title>
 </head>
 <body>
  <div id="jsgl_grant_form">
  <c:forEach items="${list_auth_function }" var="data">
	<input type="checkbox" name="auth_function_ck" value="${data.auth_function_id }">${data.auth_function_name }
  </c:forEach>
  </div>
 </body>
</html>
