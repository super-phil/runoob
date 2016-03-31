<%--
  Created by IntelliJ IDEA.
  User: Phil
  Date: 2016/3/31
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>国际化</title>
</head>
<body>
<span>

          <a href="messages?locale=zh">中文版</a> | <!-- 对应 messages_zh.properties文件-->
          <a href="messages?locale=en">英文版</a>     <!-- 对应 messages_en.properties文件-->
      </span>

<br/>
<div class="text-center">
    <s:message code="messages.hi" arguments="苏若年,林允熙"/>
    <s:message code="messages.Chinese"/>
    <s:message code="messages.English"/>
    <s:message code="messages.index"/>
    <s:message code="messages.something"/>
</div>

</body>
</html>
