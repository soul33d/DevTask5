<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Edit product</title>
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
    <form action="<%=contextPath%>/products/edit" method="post">
        <div class="form-group">
            <input type="hidden" name="id" value="<c:out value="${product.id}"/>">
            <label>Name:</label><input type="text" class="form-control" name="name"
                                       value="<c:out value="${product.name}"/>"><br>
            <label>Price:</label><input type="number" step="0.01" class="form-control" name="price"
                                        value="<c:out value="${product.price}"/>">
            <br><label>Manufacturer:</label><select name='manufacturer_id' class="form-control">
            <c:forEach items="${manufacturersList}" var="manufacturer">
                <c:choose>
                    <c:when test="${manufacturer.id.equals(product.manufacturer.id)}">
                        <option selected value='${manufacturer.id}'>${manufacturer.name}</option>
                    </c:when>
                    <c:otherwise>
                        <option value='${manufacturer.id}'>${manufacturer.name}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select><br>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            <input type="submit" class="btn btn-primary" value="Update">
        </div>
    </form>
</div>
</body>
</html>
