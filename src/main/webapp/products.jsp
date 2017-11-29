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
<%@include file="nav_bar.jsp" %>
<div class="container">
    <a href="<%=contextPath%>/product_create" class="btn btn-primary btn-lg btn-block" style="margin-bottom: 20px">
        Create new product
    </a>
    <table class="table table-bordered table-hover">
        <tr style="text-align: center">
            <th id="name">Name</th>
            <th id="price">Price</th>
            <th id="manufacturer">Manufacturer</th>
            <th id="action"></th>
        </tr>
        <tbody>
        <c:forEach items="${productsList}" var="product">
            <tr>
                <td headers='name'>
                    <a href='<%=contextPath%>/product_edit?id=${product.id}' title='click to edit'>${product.name}</a>
                </td>
                <td headers='price' style='text-align: right'>${product.price}</td>
                <td headers='manufacturer'>${product.manufacturer.name}</td>
                <td headers='action'>
                    <a href='<%=contextPath%>/products/delete?id=${product.id}' class="btn btn-danger btn-md btn-block">
                        delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
