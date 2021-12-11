<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/12/2
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>你好世界</h1>
<h2>${b}</h2>
<h2>${s}</h2>

<s:form action="" method="post" modelAttribute="c">
    <s:input path="bookName"/><br>
    <s:password path="bookPrice"/>
    <s:select path="hoby" items="${m}"/>

    <table>
        <tr>
            <td>选择课程:</td>
            <td>
                <s:checkboxes items="${c.courses}" path="courses"/>
            </td>
        </tr>
    </table>

</s:form>

</body>
</html>
