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
    <!--表格-->
    <link rel="stylesheet" href="/assets/js/plugins/dataTables/dataTables.bootstrap.min.css">
    <!--弹窗-->
    <link rel="stylesheet" type="text/css" href="/assets/js/plugins/sweetalert/sweetalert.css">
    <!-- 验证-->
    <link rel="stylesheet" type="text/css" href="/assets/js/plugins/nice-validator/jquery.validator.css">
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
            <a class="navbar-brand" href="#">Project name</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">用户列表</a></li>
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
                            <h3 class="panel-title">响应式表单</h3>
                        </div>
                    </div>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-sm-2 col-md-2 hidden-xs">
                            <button type="button" class="btn-add btn btn-success">
                                添加
                            </button>
                        </div>
                        <div class="col-xs-6 col-xs-offset-6 col-sm-6 col-sm-offset-4 col-md-4 col-md-offset-6">
                            <input id="table-search" type="text" class="form-control" placeholder="search"
                                   autocomplete="off">
                        </div>
                    </div>
                    <table id="user-list" class="table table-bordered table-hover display" width="100%">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>用户名</th>
                            <th>手机</th>
                            <th>邮箱</th>
                            <th>状态</th>
                            <th>创建时间</th>
                            <th width="80px">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="col-sm-3 col-md-2 hidden-xs">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title">Panel title</h3>
                </div>
                <div class="panel-body">
                    个人说明
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
<!-- /.container -->
<!-- .add modal -->
<div class="modal fade" id="addModal">
    <div class="modal-dialog">
        <div class="modal-content span12">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">添加用户</h4>
            </div>
            <form id="user-form" class="form-horizontal" method="post" autocomplete="off">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="inputName3" class="col-sm-2 control-label">用户名</label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="inputName3" name="name" placeholder="用户名">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-2 control-label">密码</label>

                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="inputPassword3" name="pwd" placeholder="密码">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputMobile3" class="col-sm-2 control-label">手机</label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="inputMobile3" name="mobile" placeholder="手机">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputEmail3" class="col-sm-2 control-label">邮箱</label>

                        <div class="col-sm-10">
                            <input type="email" class="form-control" id="inputEmail3" name="email" placeholder="邮箱">
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="reset" class="btn btn-danger">清空</button>
                    <button type="button" class="submit-form btn btn-primary">提交</button>
                </div>
            </form>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<!-- /.add modal -->
<script src="/assets/js/jquery.min.js"></script>
<script src="/assets/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<!--表格-->
<script src="/assets/js/plugins/dataTables/jquery.dataTables.min.js"></script>
<script src="/assets/js/plugins/dataTables/dataTables.bootstrap.min.js"></script>
<!--弹窗-->
<script src="/assets/js/plugins/sweetalert/sweetalert.min.js"></script>
<!--验证-->
<script src="/assets/js/plugins/nice-validator/jquery.validator.min.js"></script>
<script src="/assets/js/plugins/nice-validator/zh-CN.js"></script>
<!--自定义-->
<script src="/assets/js/sys.js"></script>


<script>
    $(function () {
        var userMode = $('#addModal');
        userMode.modal({
            backdrop: true,
            show: false,
            keyboard: true
        });
        var userForm = $('#user-form');
        var table = $('#user-list').DataTable({
            "ajax": {
                "url": "/user/index",
                "type": "POST",
//                "dataType": "json",
                "contentType": "application/json;charset=UTF-8",
                "data": function (data) {
                    return JSON.stringify(data);
                }
            },
            "columns": [
                {"data": "id", "searchable": false},
                {"data": "name"},
                {"data": "mobile"},
                {"data": "email"},
                {"data": "status"},
                {"data": "createTime"},
                {"data": null, "searchable": false, "orderable": false}//不参与排序和查询
            ],
            "columnDefs": [{
                "render": function (data, type, row) {
                    return data + ' (' + row.status + ')';
                },
                "targets": 0//对第一行渲染
            }, {
                "targets": -1,
                "render": function (data, type, row) {
                    return '<button class="btn-edit btn btn-xs btn-info" data-id="' + row.id + '">编辑</button> <button class="btn-del btn btn-xs btn-danger" data-id="' + row.id + '">删除</button>';
                }
//                "defaultContent": "<button class='btn-edit btn btn-xs btn-info'>编辑</button> <button class='btn-del btn btn-xs btn-danger'>删除</button>"//添加按钮
            }],
            "initComplete": function () {
                var api = this.api();
            }
        });
        //隐藏默认的搜索
        $(".dataTables_filter").hide();
        //自定义搜索
        $('#table-search').on('keyup', function () {
            table.search(this.value).draw();
        });

        $('.btn-add').click(function () {
            userMode.modal("show");
            $(userForm.find('input[name=pwd]').parent().parent()[0]).show();//显示密码选项
            userForm.find('input[name=id]').remove();
        });
        userForm.validator({
            theme: "simple_top",
            fields: {
                'name': 'required; username;',
                'pwd': 'required; password;',
                'mobile': 'required; mobile;',
                'email': 'required; email;'
            },
            // 获取display
            display: function (el) {
                return el.getAttribute('placeholder') || '';
            },
            valid: function (form) {
                console.info(form);
                //表单验证通过，提交表单到服务器
                sys.submit(form, "/user/insert", function () {
                    table.ajax.reload();
                    userMode.modal("hide");
                });
            }
        }).on('click', '.submit-form', function (e) {
            $(e.delegateTarget).trigger("validate");
        });
        //编辑
        $(document).on('click', '.btn-edit', function () {
            var _this = $(this);
            var _tr = _this.parent().parent()[0];
            var data = table.row(_tr).data();

            $(userForm.find('input[name=pwd]').parent().parent()[0]).hide();//隐藏密码选项
            userForm.append("<input type='hidden' name='id' value='" + data.id + "'>");
            userMode.modal("show");
        });
        //编辑
        $(document).on('click', '.btn-del', function () {
            var _this = $(this);
            var id = _this.data('id');
            sys.confirm("", function () {
                sys.del("/user/del", id, function () {
                    table.ajax.reload();
                })
            });
        });
    });
</script>
</body>
</html>
