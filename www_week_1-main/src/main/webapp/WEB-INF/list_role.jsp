<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.labweek2.entities.Role" %>
<%@ page import="vn.edu.iuh.fit.labweek2.entities.Account" %><%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 9/20/2023
  Time: 7:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ListRole</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<%
    Account acc = (Account) session.getAttribute("accountLogin");
    List<Role> listRole = (List<Role>) session.getAttribute("listRole");
    String grant_access
%>
%>
</body>
</html>
