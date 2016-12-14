<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>表单数据提交</title>
</head>
<body>
<fieldset>
	<legend>用户信息</legend>
	<form action="Login02.do" method="post">
		<p><label>用户姓名:</label><input type="text" name="name"></p>
		<p><label>用户密码:</label><input type="password" name="password"></p>
		<input type="submit">
	</form>
</fieldset>
<hr/>

<fieldset>
	<legend>用户信息</legend>
	<form action="Login03.do" method="post">
		<p><label>用户姓名:</label><input type="text" name="username"></p>
		<p><label>用户密码:</label><input type="password" name="password"></p>
		<input type="submit">
	</form>
</fieldset>
</body>
</html>