<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create product</title>
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
    <form action="<%=contextPath%>/products/create" method="post">
        <div class="form-group">
            <label>Name:</label>
            <input class="form-control" type="text" name="name" placeholder="Enter product's name"><br>
            <label>Price:</label>
            <input class="form-control" type="number" step="0.01" name="price" placeholder="Enter product's price"><br>
            <label>Manufacturer:</label>
            <select class="form-control" name="manufacturer_id">
                <c:forEach items="${manufacturersList}" var="manufacturer">
                    <option value='${manufacturer.id}'>${manufacturer.name}</option>
                </c:forEach>
            </select><br>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            <input class="btn btn-primary" type="submit" value="Create">
        </div>
    </form>
</div>
</body>
</html>
