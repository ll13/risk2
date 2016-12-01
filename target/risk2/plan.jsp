<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>plan</title>
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

			<div class="welcomeContent">${session.attribute("username")}欢迎
				${sessionScope.username} ${sessionScope.occupation}</div>

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


			</div>
			<%@page import="java.util.*"%>
			<%@page import="vo.Plan"%>
			<%
				ArrayList<Object> planlist = (ArrayList<Object>) session.getAttribute("planList");
			%>
			
			<div class="right_box border">

				<%for (int i = 0; i < planlist.size(); i++) {%>
				<%Plan plan = null;%>
				
					<%plan = (Plan) planlist.get(i);%>
					
					<form action="plan" method=post>
						<input type="hidden" name="method" value=<%=plan.getName()%>>  
						<input type="submit" value=<%=plan.getName()%> >
					</form>
				
				<%}%>


				<form action="plan" method=post>
					<input type="hidden" name="method" /> 
					计划名字:<input type=text name="name"> 
					<input type="submit" value="增加计划" onclick="method.value='add'">
				</form>
			</div>

			<div class="nav"></div>
		</div>
	</div>

</body>
</body>
</html>