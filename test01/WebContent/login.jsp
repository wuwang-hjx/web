<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户登录入口</title>
<script type="text/javascript" src="js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="js/login.js"></script>
<link rel="stylesheet" type="text/css" href="css/login.css"/>
</head>
<body>
	<div class="div">
			<div id="login">
				
								<h1>账号登陆</h1>
								<p><input type="text" name="用户" id="username" placeholder="请输入用户名"></p>
							
								<p><input type="password" name="密码" id="password" placeholder="请输入密码"></p>
						<table><tr>
						<td>
								<input type="text" name="验证码" id="yzm" placeholder="请输入验证码"></td>
						<td>	
								<img src="CreateVerifyImageController" name="验证图片" id="img"></td>
						</tr></table>	
								<p><input type="submit" name"登录" value="登录" id="submit"></p>
					
				</div>
		</div>
</body>
</html>