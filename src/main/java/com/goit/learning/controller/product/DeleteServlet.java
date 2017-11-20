package com.goit.learning.controller.product;

import com.goit.learning.dao.GenericDAO;
import com.goit.learning.dao.hibernate.EntityDaoHolder;
import com.goit.learning.model.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class DeleteServlet extends HttpServlet {
    private GenericDAO<Product, UUID> ProductDAO = EntityDaoHolder.getDao(Product.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID id = UUID.fromString(req.getParameter("id"));
        ProductDAO.delete(ProductDAO.getById(id));
        resp.sendRedirect(req.getContextPath().concat("/products"));
    }
}
