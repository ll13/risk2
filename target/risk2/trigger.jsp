<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>trigger</title>
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
				<form action="triggeradd.jsp" method="post">
					<input type="submit" value="增加触发器">
				</form>

				<div class="nav"></div>
				<div class="nav"></div>
				<div class="nav"></div>
				<form action="triggerupdate.jsp" method="post">
					<input type="submit" value="更新触发器">
				</form>

			</div>
			<%@page import="java.util.*"%> 
			<%@page import="vo.RiskType" %>
			<%ArrayList<Object> risktypelist=(ArrayList<Object>)session.getAttribute("risktypelist");%>			
			<div class="right_box border">
				<table  width=100% cellspacing="20">
					<tr>
						<th>风险类型</th>
						<th>可能性</th>
						<th>影响程度</th>
					</tr>
					<%for(int i=0;i<risktypelist.size();i++){ %>
					<% RiskType risktype=null; %>
								
					
					<tr>
					<%risktype=(RiskType)risktypelist.get(i);%>
						<td><%=risktype.getType() %></td>
						<td><%=risktype.getPossible()  %></td>
						<td><%=risktype.getInfluence() %></td>
					</tr>
					<% }%>
				</table>
				 <form action="trigger" method=post>
				 <input type= "hidden" name= "method"/> 
				 类型:<input type=text name="type">
				 <input type="submit"  value="删除风险类型" onclick="method.value='delete'">
				 </form>
			</div>
		</div>
	</div>

</body>
</body>
</html>