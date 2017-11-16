<%@ page import="com.goit.learning.model.Manufacturer" %>
<%@ page import="java.util.Set" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manufacturers</title>
    <link rel="stylesheet" type="text/css" href="styles/style.css">
</head>
<body>
<table>
    <tr>
        <th id="name">Name</th>
        <th id="action">Action</th>
    </tr>
    <tbody>
    <%
        for (Manufacturer manufacturer : ((Set<Manufacturer>) request.getAttribute("manufacturers"))) {
            out.println("<tr>" +
                    "<td headers='name'>" + "<a href='#' title='click to edit'>" + manufacturer.getName() +
                    "</a></td>" +
                    "<td headers='action'><a href='/manufacturers/delete?id=" + manufacturer.getId() +
                    "'>delete</a></td>" +
                    "</tr>");
        };
    %>
    </tbody>
</table>
</body>
</html>
