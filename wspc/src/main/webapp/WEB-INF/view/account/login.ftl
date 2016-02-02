<#assign base=request.contextPath />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="color:red;">${errMsg!}</div>
<form action="${base}/login/input/confirm" method="post"><br>
	证件类型：<select name="certificateType">
				<option value="">请选择</option>
				<option value="0">身份证</option>
				<option value="1">学生证</option>
			</select><br>
	证件号:<input type="text" name="certificateNo" /><br>
	密   码：<input type="password" name="password" /><br>
	<input type="submit" value="登录">
</form> 
</body>
</html>