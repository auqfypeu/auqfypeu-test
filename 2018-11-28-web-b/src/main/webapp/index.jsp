<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>this is b</title>
</head>
<body>

	<img alt=""
		src="http://127.0.0.1:8080/2018-11-28-web/image/0C259C2ED669EC93F113CAD61167FDC643573054.jpg">
		
		<a href="http://127.0.0.1:8080/a/FromServlet?userName=lisi"> test servlet </a>
	<script type="text/javascript" src="js/jquery-2.0.3.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$.ajax({
				type : "post",
				async : false,
				url : "http://a.a.com/a/FromServlet?userName=wangwu",
				dataType : "json",//数据类型为jsonp
			//	jsonp : "jsonpCallback",//服务端用于接收callback调用的function名的参数
				success : function(data) {
					console.log("data："+data);
					alert("userName:"+data.userName);
				},
				error : function() {
					alert('fail');
				}
			});
		});
	</script>
</body>
</html>