<%@ page import="com.goit.learning.model.Product" %>
<%@ page import="java.util.Set" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
    <link rel="stylesheet" type="text/css" href="styles/style.css">
</head>
<body>
<table>
    <tr>
        <th id="name">Name</th>
        <th id="price">Price</th>
        <th id="manufacturer">Manufacturer</th>
        <th id="action">Action</th>
    </tr>
    <tbody>
    <%
        for (Product product : ((Set<Product>) request.getAttribute("products"))) {
            out.println("<tr>" +
                    "<td headers='name'>" + "<a href='#' title='click to edit'>" + product.getName() + "</a></td>" +
                    "<td headers='price'>" + product.getPrice() + "</td>" +
                    "<td headers='manufacturer'>" + product.getManufacturer().getName() + "</td>" +
                    "<td headers='action'><a href='#'>delete</a></td>" +
                    "</tr>");
        };
    %>
    </tbody>
</table>
</body>
</html>
