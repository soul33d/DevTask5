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
            out.println(String.format("<tr><td headers='name'>" +
                            "<a href='/manufacturer_edit.jsp?id=%s&name=%s' title='click to edit'>%s</a></td>" +
                            "<td headers='action'><a href='/manufacturers/delete?id=%s'>delete</a></td></tr>",
                    manufacturer.getId(), manufacturer.getName(), manufacturer.getName(), manufacturer.getId()));
        }
    %>
    </tbody>
</table>
</body>
</html>
