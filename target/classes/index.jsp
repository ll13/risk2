<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index</title>
<link rel="stylesheet" href="mycss.css" type="text/css" />
<script type="text/javascript">

</script>
</head>
<body>
	<div id="container">
		<div id="header">
			<h1>风险管理</h1>
		</div>
		<div class="nav"></div>
		<div id=welcome>
			<div class="welcomeContent">						
			欢迎  
			 ${sessionScope.username}   ${sessionScope.occupation}  </div>
            
			<div class="welcomeleft"></div>
		</div>
		<div id="content">
			<div class="left_box border">
			    <form action="login.jsp" method="post">
					<input type="submit" value=" 登录 ">
				</form>
				<div class="nav"></div>
				<div class="nav"></div>
				<div class="nav"></div>
				<form action="riskItem" method="post">
					<input type="submit" value="风险条目">
				</form>
				

				<div class="nav"></div>
				<div class="nav"></div>
				<div class="nav"></div>
				<form action="trigger" method="post">
					<input type="submit" value="触发器 ">
				</form>

				<div class="nav"></div>
				<div class="nav"></div>
				<div class="nav"></div>
				<form action="solution" method="post">
					<input type="submit" value="解决方案">
				</form>

				<div class="nav"></div>
				<div class="nav"></div>
				<div class="nav"></div>
				<form action="admin" method="post">
					<input type="submit" value="管理用户">
				</form>

			</div>
			<div class="right_box border">
			<img src="image1.jpg" width="600px" height="300px" />
				
			</div>
			<div class="nav"></div>
		</div>
	</div>

</body>
</body>
</html>