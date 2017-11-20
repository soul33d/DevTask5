package com.goit.learning.controller.product;

import com.goit.learning.dao.GenericDAO;
import com.goit.learning.dao.hibernate.EntityDaoHolder;
import com.goit.learning.model.Manufacturer;
import com.goit.learning.model.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.UUID;

public class EditServlet extends HttpServlet {
    private GenericDAO<Product, UUID> ProductDAO = EntityDaoHolder.getDao(Product.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID id = UUID.fromString(req.getParameter("id"));
        String name = req.getParameter("name");
        BigDecimal price = new BigDecimal(req.getParameter("price"));
        Product product = ProductDAO.getById(id);
        product.setName(name);
        product.setPrice(price);
        UUID manufacturerId = UUID.fromString(req.getParameter("manufacturer_id"));
        Manufacturer manufacturer = EntityDaoHolder.getDao(Manufacturer.class).getById(manufacturerId);
        product.setManufacturer(manufacturer);
        ProductDAO.update(product);
        resp.sendRedirect(req.getContextPath().concat("/products"));
    }
}
