<%@ page import="com.goit.learning.model.Product" %>
<%@ page import="java.util.Set" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
          integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
            integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
            crossorigin="anonymous"></script>
</head>
<body>
<%@include file="nav_bar.jsp"%>
<div class="container">
    <a href="product_create.jsp" class="btn btn-primary btn-lg btn-block" style="margin-bottom: 20px">Create new
        product</a>
    <table class="table table-bordered table-hover">
        <tr style="text-align: center">
            <th id="name">Name</th>
            <th id="price">Price</th>
            <th id="manufacturer">Manufacturer</th>
            <th id="action"></th>
        </tr>
        <tbody>
        <%
            for (Product product : ((Set<Product>) request.getAttribute("products"))) {
                out.println(String.format
                        ("<tr><td headers='name'><a href='/product_edit.jsp?id=%s' title='click to edit'>%s</a></td>" +
                                        "<td headers='price' style='text-align: right'>%s</td><td headers='manufacturer'>%s</td>" +
                                        "<td headers='action'><a href='/products/delete?id=%s' class=\"btn btn-danger btn-md btn-block\">delete</a></td></tr>",
                                product.getId(), product.getName(), product.getPrice(), product.getManufacturer().getName(),
                                product.getId()));
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>
