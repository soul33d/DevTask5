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
            out.println(String.format
                    ("<tr><td headers='name'><a href='/product_edit.jsp?id=%s' title='click to edit'>%s</a></td>" +
                                    "<td headers='price'>%s</td><td headers='manufacturer'>%s</td>" +
                                    "<td headers='action'><a href='/products/delete?id=%s'>delete</a></td></tr>",
                            product.getId(), product.getName(), product.getPrice(), product.getManufacturer().getName(),
                            product.getId()));
        }
    %>
    </tbody>
</table>
</body>
</html>
