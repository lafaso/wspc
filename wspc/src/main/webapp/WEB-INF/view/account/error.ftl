<#assign base=request.contextPath />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户信息</title>
</head>
<script type="text/javascript" src="${base}/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	function showMessage(){
		$.post("${base}/info", 
				   function(data){
				    // $("#userinfo").text(data.id+"，"+data.name);
				    alert(eval(data).length);
				   },
				   "json"
		);
		
	}
</script>
<body>
	<div style="color:red;">${errMsg!}</div>
</body>
</html>