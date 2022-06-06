<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/6/2022
  Time: 12:21 PM
  To change this template use File | Settings | File Templates.
--%>
<% String name = (String)session.getAttribute("name");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>welcom to session</h1>
<strong>yay hello <%=name%></strong>
</body>
</html>
