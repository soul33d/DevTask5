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
    <link rel="stylesheet" type="text/css" href="styles/style.css">
</head>
<body>
<form action="/products/edit" method="post">
    <input type="hidden" name="id" value="<%=product.getId()%>">
    <label>Name:</label><input type="text" name="name" value="<%=product.getName()%>"><br>
    <label>Price:</label><input type="number" value="<%=product.getPrice()%>"><br>
    <label>Manufacturer:</label><select name='manufacturer_id'>
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
    <input type="submit" value="Update">
</form>
</body>
</html>
