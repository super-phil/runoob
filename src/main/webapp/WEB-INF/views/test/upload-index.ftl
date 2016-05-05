<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>文件上传</title>
</head>
<body>
<hr>
<form action="/test/upload" enctype="multipart/form-data" method="post">
    <input type="file" name="file"/><br/>
    <input type="submit" value="上传">
</form>
<h3> <#if Request.status?exists> ${status} <#else >状态</#if></h3>


<hr>
<h2>ajax 提价</h2>
<form id="ajax-form" action="/test/upload2" enctype="multipart/form-data" method="post">
    <input type="file" name="file"/><br/>
    <input type="button" value="上传" class="ajax-sub">
</form>
<script src="/assets/js/jquery.min.js"></script>
<!--ajax表单提交-->
<script src="/assets/js/plugins/jquery.form.min.js"></script>
<script>
    $(function () {
        $('.ajax-sub').click(function () {
            $('#ajax-form').ajaxSubmit({
                dataType: 'json',
                success: function (data) {
                    console.info(data);
                    alert(data.code);
                }
            })
        });
    });
</script>
</body>
</html>