<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/12/1
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <table border="1" cellpadding="10" cellspacing="0">

      <tr>
          <th>bookId</th>
          <th>bookName</th>
          <th>bookPrice</th>
          <th>bookBrief</th>
          <th>操作</th>
      </tr>

      <c:forEach items="${list}" var="i">
      <tr>
          <th>${i.bookId}</th>
          <th>${i.bookName}</th>
          <th>${i.bookPrice}</th>
          <th>${i.bookBrief}</th>
          <th><a href="http://localhost:8080/smvc01/del?id=${i.bookId}">删除</a></th>
      </tr>
      </c:forEach>


  </table>
</body>
</html>
