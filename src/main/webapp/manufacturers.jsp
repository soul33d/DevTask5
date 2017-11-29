<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manufacturers</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
          integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
            integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
            crossorigin="anonymous"></script>
</head>
<body>
<%@include file="nav_bar.jsp" %>
<div class="row justify-content-center">
    <div class="col-4">
        <a href="<%=contextPath%>/manufacturer_create.jsp" class="btn btn-primary btn-lg btn-block"
           style="margin-bottom: 20px">Create new manufacturer</a>
        <table class="table table-bordered table-hover">
            <tr>
                <th id="name" style="text-align: center">Name</th>
                <th></th>
            </tr>
            <tbody>
            <c:forEach items="${manufacturersList}" var="item">
                <tr>
                    <td headers='name'>
                        <a href='<%=contextPath%>/manufacturer_edit.jsp?id=${item.id}&name=${item.name}'
                           title='click to edit'>${item.name}</a>
                    </td>
                    <td>
                        <a href='<%=contextPath%>/manufacturers/delete?id=${item.id}'
                           class='btn btn-danger btn-md btn-block'>delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
