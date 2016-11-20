<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>admin</title>
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

			<div class="welcomeContent">${session.attribute("username")} 欢迎
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

				<div class="nav"></div>
				<div class="nav"></div>
				<div class="nav"></div>
				<form action="adminadd.jsp" method="post">
					<input type="submit"  value="增加用户" >
					 
				</form>

				<div class="nav"></div>
				<div class="nav"></div>
				<div class="nav"></div>
				<form action="adminupdate.jsp" method="post">
					<input type="submit" value="更新用户">
				</form>

			</div>
			<%@page import="java.util.*"%> 
			<%@page import="vo.User" %>
			<%ArrayList<Object> userlist=(ArrayList<Object>)session.getAttribute("userList");%>			
			<div class="right_box border">
				<table  width=100% cellspacing="20">
					<tr>
						<th>id</th>
						<th>用户名</th>
						<th>密码</th>
						<th>职位</th>
					</tr>
					<%for(int i=0;i<userlist.size();i++){ %>
					<%User user=null; %>
								
					
					<tr>
					<%user=(User)userlist.get(i);%>
						<td><%=user.getId() %></td>
						<td><%=user.getUsername() %></td>
						<td><%=user.getPassword() %></td>
						<td><%=user.getOccupation() %></td>
					</tr>
					<% }%>
				</table>
				 <form action="admin" method=post>
				 <input type= "hidden" name= "method"/> 
				 id:<input type=text name="id">
				 <input type="submit"  value="删除用户" onclick="method.value='delete'">
				 </form>
			</div>
					
			<div class="nav"></div>
		</div>
	</div>

</body>
</body>
</html>