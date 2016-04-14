<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>

    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!--在移动设备浏览器上，通过为视口（viewport）设置 meta 属性为 user-scalable=no 可以禁用其缩放（zooming）功能。这样禁用缩放功能后，用户只能滚动屏幕，就能让你的网站看上去更像原生应用的感觉 width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no-->
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
    <!--让部分国产浏览器默认采用高速模式渲染页面 360浏览器支持-->
    <meta name="renderer" content="webkit">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <link rel="icon" href="/favicon.ico">
    <title>首页</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="/assets/bootstrap/3.3.5/css/bootstrap.min.css">
    <!--自定义 -->
    <link rel="stylesheet" href="/assets/css/sys.css">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="/assets/js/html5shiv.min.js"></script>
    <script src="/assets/js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">Runoob</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/user/index">用户模块</a></li>
                <li><a href="#about">About</a></li>
                <li><a href="#contact">Contact</a></li>
            </ul>
        </div>
        <!--/.nav-collapse -->
    </div>
</nav>
<div class="container sys-head">
    <div class="row">
        <div class="col-xs-12 col-sm-9 col-md-10 ">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-xs-12 col-sm-4 col-md-4">
                            <h3 class="panel-title">实时访问量</h3>
                        </div>
                    </div>
                </div>
                <div class="panel-body">
                    <%--<div>--%>
                        <%--<span>频率:</span>--%>
                        <%--<select id="fqcy">--%>
                            <%--<option value="5">5s</option>--%>
                            <%--<option value="15">15s</option>--%>
                            <%--<option value="30">30s</option>--%>
                            <%--<option value="45">45s</option>--%>
                            <%--<option value="60">60s</option>--%>
                        <%--</select>--%>
                    <%--</div>--%>
                    <div id="container"></div>
                </div>
            </div>
        </div>
        <div class="col-sm-3 col-md-2 hidden-xs">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title">Panel title</h3>
                </div>
                <div class="panel-body">
                    个人说明 highcharts-yaxis-title
                </div>
                <div class="panel-footer">
                    Panel footer
                </div>
            </div>
            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title">Panel title</h3>
                </div>
                <ul class="list-group">
                    <a href="#" class="list-group-item">Dapibus ac facilisis in</a>
                    <a href="#" class="list-group-item">Morbi leo risus</a>
                    <a href="#" class="list-group-item">Porta ac consectetur ac</a>
                    <a href="#" class="list-group-item">Vestibulum at eros</a>
                </ul>
            </div>
        </div>
    </div>
</div>
<script src="/assets/js/jquery.min.js"></script>
<script src="/assets/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<!-- highcharts 图表 -->
<script src="/assets/js/plugins/highcharts/highcharts.js"></script>
<script src="/assets/js/plugins/highcharts/exporting.js"></script>
<script type="text/javascript">
    $(function () {
        var interval = 5000;
        $('#fqcy').change(function () {
            interval = $("#fqcy").val() * 1000;
        });
        $('#container').highcharts({
            chart: {
                type: 'spline',
                animation: Highcharts.svg, // don't animate in old IE
                marginRight: 10,
                events: {
                    load: function () {
                        var series = this.series[0];
                        setInterval(function () {
                            $.ajax({
                                type: 'POST',
                                url: "/chart/ajax",
                                data: {"interval": interval},
                                dataType: 'json',
                                success: function (result) {
                                    var x, y;
                                    x = result.data.x;
                                    y = result.data.y;
                                    console.info(x + "-----" + y);
                                    series.addPoint([x, y], true, true);
                                }
                            });
                        }, interval);
                    }
                }
            },
            title: {
                text: '<span>你好</span>',
                style: {"color": "red", "fontSize": "18px"},

                useHTML: true

            },
            xAxis: {
                type: 'category'
            },
            yAxis: {
                title: {
                    text: '注册人数'
                },
                plotLines: [{
                    value: 0,
                    width: 1,
                    color: '#808080'
                }]
            },
            series: [{
                name: '新建用户',
                data: [1, 2, 3, 2, 4, 5, 1, 2, 6, 8, 7, 8, 1, 2, 6]
            }]

        });


//           $('#container').highcharts({
//                chart: {
//                    type: 'spline',
//                    animation: Highcharts.svg, // don't animate in old IE
//                    marginRight: 10,
//                    events: {
//                        load: function () {
//
//                        }
//                    }
//                },
//                title: {
//                    text: 'Live random data'
//                },
//                xAxis: {
////                    type: 'datetime',
////                    tickPixelInterval: 150
//                },
//                yAxis: {
//                    title: {
//                        text: 'Value'
//                    },
//                    plotLines: [{
//                        value: 0,
//                        width: 1,
//                        color: '#808080'
//                    }]
//                },
//                tooltip: {
////                    formatter: function () {
////                        return '<b>' + this.series.name + '</b><br/>' +
////                                Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) + '<br/>' +
////                                Highcharts.numberFormat(this.y, 2);
////                    }
//                },
//                legend: {
//                    enabled: false
//                },
//                exporting: {
//                    enabled: false
//                },
//                series: [{
//                    name: 'Random data',
//                    data: (function () {
//                        // generate an array of random data
//                        var data = [],
//                                time = (new Date()).getTime(),
//                                i;
//
//                        for (i = -19; i <= 0; i += 1) {
//                            data.push({
//                                x: time + i * 1000,
//                                y: Math.random()
//                            });
//                        }
//                        console.info(data);
//                        return data;
//                    }())
//                }]
//            });
    });
</script>
</body>
</html>
