<#assign base=request.contextPath />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="color:red;">${errMsg!}</div>
<form action="${base}/register/input/confirm" method="post"><br>
	姓名：<input type="text" name="name"/><br>
	全名：<input type="text" name="fullName"/><br>
	年龄：<input type="text" name="age"/><br>
	性别：<input type="radio" name="gender" value="1"/>男
		<input type="radio" name="gender" value="0"/>女<br>
	<#if account??>
	<#else>
	证件类型：<select name="certificateType">
				<option value="">请选择</option>
				<option value="0">身份证</option>
				<option value="1">学生证</option>
			</select><br>
	证件号:<input type="text" name="certificateNo" /><br>
	</#if>
	密码：<input type="password" name="password" /><br>
	确认密码：<input type="password" name="password2" /><br>
	<input type="submit" value="提交">
	<input type="reset" value="重置">
</form>
</body>
</html>