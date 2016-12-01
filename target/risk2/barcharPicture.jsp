<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>picture</title>
</head>
<body>
    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main1" style="height:400px"></div>
    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main2" style="height:400px"></div>
    <!-- ECharts单文件引入 -->
    <script src="http://echarts.baidu.com/build/dist/echarts.js"></script>
    <script type="text/javascript">
        // 路径配置
        require.config({
            paths: {
                echarts: 'http://echarts.baidu.com/build/dist'
            }
        });
        
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
                            data : ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
                        }
                    ],
                    yAxis : [
                        {
                            type : 'value'
                        }
                    ],
                    series : [
                        {
                            "name":"销量",
                            "type":"bar",
                            <%int [] kk={20,49,30,40,20};%>
                             "data":[<%=kk[0]%>,<%=kk[1]%>,<%=kk[2]%>,<%=kk[3]%>,<%=kk[4]%>]
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
                                data : ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
                            }
                        ],
                        yAxis : [
                            {
                                type : 'value'
                            }
                        ],
                        series : [
                            {
                                "name":"销量",
                                "type":"bar",
                                
                                "data":[5, 20, 40, 10, 10, 20]
                            }
                        ]
                    };
                // 为echarts对象加载数据 
                myChart1.setOption(option1); 
                myChart2.setOption(option2); 
            }
        );
    </script>
</body>
</html>