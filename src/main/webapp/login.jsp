<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
<script src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">
	function login() {
		$.post(
				"user/login1.mvc",
				$("#login").serialize(),
				function(data) {
			console.log(data)
		},
		"json")
	}
</script>
</head>
<body>
	<form action="user/login2.mvc" method="post">
		用户名： <input type="text" name="uname" /> 密码： <input type="password"
			name="upwd" /> <input type="submit" value="登录" />
	</form>

	<h1>Ajax</h1>
	<form id="login" action="" method="">
		用户名： <input type="text" name="uname" /> 密码： <input type="password"
			name="upwd" /> <input type="button" value="登录" onclick="login()" />
	</form>
</body>
</html>