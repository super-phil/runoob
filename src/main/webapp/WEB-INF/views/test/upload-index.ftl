<form action="/test/upload" enctype="multipart/form-data" method="post">
    <input type="file" name="file"/><br/>
    <input type="submit" value="上传">
</form>
<h3> <#if Request.status?exists> ${status} <#else >状态</#if></h3>