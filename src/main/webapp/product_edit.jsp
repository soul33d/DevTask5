<%@ page import="com.goit.learning.dao.hibernate.EntityDaoHolder" %>
<%@ page import="com.goit.learning.model.Manufacturer" %>
<%@ page import="com.goit.learning.model.Product" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.UUID" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Set<Manufacturer> manufacturers = EntityDaoHolder.getDao(Manufacturer.class).readAll();
    Product product = EntityDaoHolder.getDao(Product.class).getById(UUID.fromString(request.getParameter("id")));
%>
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
<%@include file="nav_bar.jsp"%>
<div class="container">
    <form action="/products/edit" method="post">
        <div class="form-group">
            <input type="hidden" name="id" value="<%=product.getId()%>">
            <label>Name:</label><input type="text" class="form-control" name="name" value="<%=product.getName()%>"><br>
            <label>Price:</label><input type="number" step="0.01" class="form-control" name="price"
                                        value="<%=product.getPrice()%>">
            <br><label>Manufacturer:</label><select name='manufacturer_id' class="form-control">
            <%
                for (Manufacturer m : manufacturers) {
                    if (!product.getManufacturer().getId().equals(m.getId())) {
                        out.println(String.format("<option value='%s'>%s</option>", m.getId(), m.getName()));
                    } else {
                        out.println(String.format("<option selected value='%s'>%s</option>", m.getId(), m.getName()));
                    }
                }
            %>
        </select><br>
            <input type="submit" class="btn btn-primary" value="Update">
        </div>
    </form>
</div>
</body>
</html>
