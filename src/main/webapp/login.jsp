<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
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
		<div id="content">
			<div class="left_box border">
				<div class="nav"></div>
				<div class="nav"></div>
				<div class="nav"></div>
				<form action="index.jsp" method="post">
					<input type="submit" value="主目录">
				</form>
				</div>
			<div class="right_box border">
				<div class="nav"></div>
				<div class="nav"></div>
				<div class="nav"></div>
				<div class="nav"></div>
				<div class="nav"></div>
				登录
				<div class="nav"></div>
				<div class="nav"></div>
				<form action="login" method="post">
					用户名:<input type="text" name="username"><br />
					<div class="nav"></div>
					<div class="nav"></div>
					密码:<input type="password" name="password"><br />
					<div class="nav"></div>
					<div class="nav"></div>
					职位： <select name="occupation">
						<option value="项目经理">项目经理</option>
						<option value="软件工程师">软件工程师</option>
						<option value="系统管理员">系统管理员</option>

					</select>
					<div class="nav"></div>
					<div class="nav"></div>
					<input type="submit" value=登录>
				</form>
			</div>
			<div class="nav"></div>
		</div>
	</div>

</body>
</body>
</html>