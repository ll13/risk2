<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>sum</title>
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


			</div>

			<div class="right_box border">
				<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
				<div id="main1" style="height: 400px"></div>
				<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
				<div id="main2" style="height: 400px"></div>
				<!-- ECharts单文件引入 -->
				<%@page import="vo.Sum"%>
				<%@page import="java.util.*"%>
				<%
			        ArrayList<Object> sumGetList = (ArrayList<Object>) session.getAttribute("sumGetList");
				    ArrayList<Object> sumProblemList = (ArrayList<Object>) session.getAttribute("sumProblemList");
				   %> 
				   <form>
				    <%for (int i = 0; i < sumGetList.size(); i++) {%>
				    <%Sum newSum=(Sum) sumGetList.get(i);%>
				    <input type="hidden" name="getName" value=<%=newSum.getName()%> />	
				    <input type="hidden" name="getNumber" value=<%=newSum.getNumber() %> />	
				    <% 			    	
				    }
				%>
				  </form>
				  <form>
				    <%for (int i = 0; i < sumProblemList.size(); i++) {%>
				    <%Sum newSum=(Sum) sumProblemList.get(i);%>
				    <input type="hidden" name="problemName" value=<%=newSum.getName()%> />	
				    <input type="hidden" name="problemNumber" value=<%=newSum.getNumber() %> />	
				    <% 			    	
				    }
				%>
				  </form>
							
				<script src="http://echarts.baidu.com/build/dist/echarts.js"></script>
				<script type="text/javascript">
        // 路径配置
        require.config({
            paths: {
                echarts: 'http://echarts.baidu.com/build/dist'
            }
        });
        obj1 = document.getElementsByName("getName");
        getName =[];
        for (var i=0;i<obj1.length;i++){       	
        	getName.push(obj1[i].value); 	
	    }
        obj2 = document.getElementsByName("getNumber");
        getNumber = [];
        for (var i=0;i<obj2.length;i++){       	
        	getNumber.push(obj2[i].value); 	
	    }
        obj3 = document.getElementsByName("problemName");
        problemName = [];
        for (var i=0;i<obj3.length;i++){       	
        	problemName.push(obj3[i].value); 	
	    }
        obj4 = document.getElementsByName("problemNumber");
        problemNumber = [];
        for (var i=0;i<obj4.length;i++){       	
        	problemNumber.push(obj4[i].value); 	
	    }
     //alert(getName);
     //alert(getNumber);
     // alert(problemName);
     // alert(problemNumber);
        // 使用
        require(
            [
                'echarts',
                'echarts/chart/bar' // 使用柱状图就加载bar模块，按需加载
            ],
            function (ec) {
                // 基于准备好的dom，初始化echarts图表
                var myChart1 = ec.init(document.getElementById('main1')); 
                var myChart2 = ec.init(document.getElementById('main2')); 
                var option1 = {
                    tooltip: {
                        show: true
                    },
                    legend: {
                        data:['被识别最多的风险']
                    },
                    xAxis : [
                        {
                            type : 'category',
                            data : getName
                        }
                    ],
                    yAxis : [
                        {
                            type : 'value'
                        }
                    ],
                    series : [
                        {
                            "name":"数量",
                            "type":"bar",
                             "data":getNumber 
                        }
                    ]
                };
                var option2 = {
                        tooltip: {
                            show: true
                        },
                        legend: {
                            data:['变成问题最多的风险']
                        },
                        xAxis : [
                            {
                                type : 'category',
                                data : problemName
                            }
                        ],
                        yAxis : [
                            {
                                type : 'value'
                            }
                        ],
                        series : [
                            {
                                "name":"数量",
                                "type":"bar",
                                
                                "data":problemNumber
                            }
                        ]
                    };
                // 为echarts对象加载数据 
                myChart1.setOption(option1); 
                myChart2.setOption(option2); 
            }
        );
    </script>

				<form action="sum" method=post>
					<input type="hidden" name="method" />
					<div class="nav"></div>
					开始时间 <input type=text name="begin"> 结束时间 <input type=text name="end">
						 <input type="submit" value="被识别最多风险"
						onclick="method.value='getMax'">
				</form>
				<form action="sum" method=post>
					<input type="hidden" name="method" />
					<div class="nav"></div>
					开始时间 <input type=text name="begin"> 
					结束时间 <input type=text name="end"> 
					<input type="submit" value="变成问题最多风险" onclick="method.value='problemMax'">
				</form>
				<form action="sum" method=post>
					<input type="hidden" name="method" /> 
					<input type="submit" value="现有风险" onclick="method.value='list'">
				</form>
			</div>
			<div class="nav"></div>
		</div>
	</div>

</body>
</body>
</html>