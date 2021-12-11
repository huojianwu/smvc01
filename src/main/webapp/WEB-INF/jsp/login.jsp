<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/12/3
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <style>
        .error{
            color: red;
        }
    </style>
</head>
<body>
<a href="changeLanguage"><s:message code="language.label"/></a>
<from:form action="doLogin" method="post" modelAttribute="user">
    <s:message code="dlzh.label"/>:<from:input path="username" name="username"/>
    <from:errors path="username" cssClass="error"/><br>
    <s:message code="pwzh.label"/>:<from:password path="pwd" name="pwd"/>
    <from:errors path="pwd" cssClass="error"/><br>
    <s:message code="email.label"/>:<from:input path="email" name="email"/>
    <from:errors path="email" cssClass="error"/><br>
    <input type="submit" value="<s:message code='button.label'/>"/>
</from:form>
</body>
</html>
