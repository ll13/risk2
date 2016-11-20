<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>riskItem</title>
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
				<form action="riskItemadd.jsp" method="post">
					<input type="submit" value="增加风险">
				</form>

				<div class="nav"></div>
				<div class="nav"></div>
				<div class="nav"></div>
				<form action="riskItemupdate.jsp" method="post">
					<input type="submit" value="更新风险">
				</form>

			</div>
			<%@page import="java.util.*"%> 
			<%@page import="vo.RiskItem" %>
			<%ArrayList<Object> riskItemlist=(ArrayList<Object>)session.getAttribute("riskItemList");%>	
			<div class="right_box border">
				<table  width=100% cellspacing="20">
					<tr>
						<th>id</th>
						<th>风险名称</th>
						<th>风险类型</th>
						<th>可能性</th>
						<th>影响程度</th>
						<th>风险状态</th>
						<th>提交者</th>
						<th>跟踪者</th>
					
					</tr>
					<%for(int i=0;i<riskItemlist.size();i++){ %>
					<%RiskItem riskItem=null; %>
								
					<tr>
					<%riskItem=(RiskItem)riskItemlist.get(i);%>
						<td><%=riskItem.getId() %></td>
						<td><%=riskItem.getRiskname() %></td>
						<td><%=riskItem.getType() %></td>
						<td><%=riskItem.getPossibility() %></td>
						<td><%=riskItem.getInfluence() %></td>
						<td><%=riskItem.getStatus() %></td>
						<td><%=riskItem.getCommit() %></td>
						<td><%=riskItem.getFollow() %></td>
					</tr>
					<% }%>
				</table>
				
				<div class="nav"></div>
				<form action="riskItem" method=post>
				 <input type= "hidden" name= "method"/> 
				 <div class="nav"></div>
				  风险名称  <input type=text name="riskname">
					<input type="submit"  value="追踪风险" onclick="method.value='find'">
				</form>
				
				<form action="riskItem" method=post>
				 <input type= "hidden" name= "method"/> 
				 <div class="nav"></div>
					<input type="submit"  value="现有风险" onclick="method.value='list'">
				</form>
			</div>
			<div class="nav"></div>
		</div>
	</div>

</body>
</body>
</html>