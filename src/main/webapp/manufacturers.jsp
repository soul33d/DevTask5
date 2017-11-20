<%@ page import="com.goit.learning.model.Manufacturer" %>
<%@ page import="java.util.Set" %>
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
<%@include file="nav_bar.jsp"%>
<div class="row justify-content-center">
    <div class="col-4">
        <a href="manufacturer_create.jsp" class="btn btn-primary btn-lg btn-block" style="margin-bottom: 20px">Create
            new
            manufacturer</a>
        <table class="table table-bordered table-hover">
            <tr>
                <th id="name" style="text-align: center">Name</th>
                <th></th>
            </tr>
            <tbody>
            <%
                for (Manufacturer manufacturer : ((Set<Manufacturer>) request.getAttribute("manufacturers"))) {
                    out.println(String.format("<tr><td headers='name'>" +
                                    "<a href='/manufacturer_edit.jsp?id=%s&name=%s' title='click to edit'>%s</a></td>" +
                                    "<td><a href='/manufacturers/delete?id=%s' class=\"btn btn-danger btn-md btn-block\">delete</a></td></tr>",
                            manufacturer.getId(), manufacturer.getName(), manufacturer.getName(), manufacturer.getId()));
                }
            %>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
