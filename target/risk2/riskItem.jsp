<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>riskItem</title>
<link rel="stylesheet" href="mycss.css" type="text/css" />
<script type="text/javascript">

function input()
{    
	    obj = document.getElementsByName("array");
	    check_val = [];
	    for(k in obj){
	        if(obj[k].checked)
	            check_val.push(obj[k].value);
	    }
	    
	    var method=document.getElementById("method");
	    var array=document.getElementById("arrays");
	    method.value="input";
	    array.value=check_val.toString();
	    //alert(array.value);
}
 

</script>

</head>
<body>
	<div id="container">
		<div id="header">
			<h1>风险管理</h1>
		</div>
		<div class="nav"></div>
		<div id=welcome>

			<div class="welcomeContent">欢迎 ${sessionScope.username}
				${sessionScope.occupation}</div>

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
			<%@page import="vo.RiskItem"%>
			<%@page import="java.text.SimpleDateFormat"%>
			<%
				ArrayList<Object> riskItemlist = (ArrayList<Object>) session.getAttribute("riskItemList");
			%>
			<div class="right_box border">
			<form action="riskItem"  method=post>
				<table width=100% cellspacing="20">
					<tr><th>选择</th>
						<th>日期</th>
						<th>风险名称</th>
						<th>风险类型</th>
						<th>可能性</th>
						<th>影响程度</th>
						<th>提交者</th>
						<th>跟踪者</th>
						<th>风险状态</th>


					</tr>
					<%
						for (int i = 0; i < riskItemlist.size(); i++) {
					%>
					
					<%
						RiskItem riskItem = null;
					%>
					<%
						riskItem = (RiskItem) riskItemlist.get(i);
					%>

					<tr>
						<%
							SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
						%>
						<td><input type="checkbox" name="array" value=<%=riskItem.getName()%> ></td>
						<td><%=df.format(riskItem.getDate())%></td>
						<td><%=riskItem.getName()%></td>
						<td><%=riskItem.getType()%></td>
						<td><%=riskItem.getPossible()%></td>
						<td><%=riskItem.getInfluence()%></td>
						<td><%=riskItem.getCommit()%></td>
						<td><%=riskItem.getFollow()%></td>
						<td><%=riskItem.getStatus()%></td>
					</tr>
					<%
						}
					%>
				</table>
				    计划名称：<input type=text name="planName" >
				    <input type="hidden" name="method" id="method"/>
				    <input type="hidden" name="arrays" id="arrays"/>
                    <input type="submit" onclick="input()" value="导入">					
				</form>
				<div class="nav"></div>
				<form action="riskItem" method=post>
					<input type="hidden" name="method" />
					<div class="nav"></div>
					风险名称 <input type=text name="name"> <input type="submit"
						value="追踪风险" onclick="method.value='find'">
				</form>
				<form action="riskItem" method=post>
					<input type="hidden" name="method" />
					<div class="nav"></div>
					开始时间 <input type=text name="begin"> 结束时间 <input type=text
						name="end"><input type="submit" value="被识别最多风险"
						onclick="method.value='getMax'">
				</form>
				<form action="riskItem" method=post>
					<input type="hidden" name="method" />
					<div class="nav"></div>
					开始时间 <input type=text name="begin"> 结束时间 <input type=text
						name="end"><input type="submit" value="变成问题最多风险"
						onclick="method.value='problemMax'">
				</form>			
				<form action="riskItem" method=post>
					<input type="hidden" name="method" /> <input type="submit"
						value="现有风险" onclick="method.value='list'">
				</form>
			</div>
			<div class="nav"></div>
		</div>
	</div>

</body>
</body>
</html>