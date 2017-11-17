<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit manufacturer</title>
    <link rel="stylesheet" type="text/css" href="styles/style.css">
</head>
<body>
<form action="/manufacturers/edit" method="post">
    <input type="hidden" name="id" value="<%=request.getParameter("id")%>">
    Name: <input title="Edit manufacturer" type="text" name="name" value="<%=request.getParameter("name")%>"><br>
    <input type="submit" value="Update">
</form>
</body>
</html>
