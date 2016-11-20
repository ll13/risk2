<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>riskItemAdd</title>
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
			欢迎   ${sessionScope.username}  ${sessionScope.occupation}</div>

			<div class="welcomeleft"></div>
		</div>
		<div id="content">
			<div class="left_box border">
				<div class="nav"></div>
				<div class="nav"></div>
				<div class="nav"></div>
				<form action="index.jsp" method="post">
					<input type="submit" value="主目录">
				</form>

				<div class="nav"></div>
				<div class="nav"></div>
				<div class="nav"></div>
				<form action="riskItem" method="post">
					<input type="submit" value="风险管理">
				</form>

				<div class="nav"></div>
				<div class="nav"></div>
				<div class="nav"></div>
				<form action="riskItemupdate.jsp" method="post">
					<input type="submit" value="更新风险">
				</form>

			</div>
			<div class="right_box border">
				
				增加风险条目
				<div class="nav"></div>
				<form action="riskItem" method=post>
				 <input type= "hidden" name= "method"/> 
				    id:<input type="text" name="id"><br />
					<div class="nav"></div>
					<div class="nav"></div>
					风险名称:<input type="text" name="riskname"><br />
					<div class="nav"></div>
					<div class="nav"></div>
					风险类型:<input type="text" name="type"><br />
					<div class="nav"></div>
					
					
					风险状态:<input type="text" name="status"><br />
					<div class="nav"></div>
					<div class="nav"></div>
					提交者:<input type="text" name="commit"><br />
					<div class="nav"></div>
					<div class="nav"></div>
					跟踪者:<input type="text" name="follow"><br />
					<div class="nav"></div>
					<div class="nav"></div>
					可能性： <select name="possibility">
						<option value="高">高</option>
						<option value="中">中</option>
						<option value="低">低</option>

					</select>
					影响程度： <select name="influence">
						<option value="高">高</option>
						<option value="中">中</option>
						<option value="低">低</option>

					</select>
					
					<div class="nav"></div>
					<input type="submit"  value="增加风险条目" onclick="method.value='add'">
				</form>
			</div>
			<div class="nav"></div>
		</div>
	</div>

</body>
</body>
</html>