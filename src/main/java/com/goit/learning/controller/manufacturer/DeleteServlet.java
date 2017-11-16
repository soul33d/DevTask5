package com.goit.learning.controller.manufacturer;

import com.goit.learning.dao.GenericDAO;
import com.goit.learning.dao.hibernate.EntityDaoHolder;
import com.goit.learning.model.Manufacturer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class DeleteServlet extends HttpServlet {
    private GenericDAO<Manufacturer, UUID> manufacturerDAO = EntityDaoHolder.getDao(Manufacturer.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID id = UUID.fromString(req.getParameter("id"));
        manufacturerDAO.delete(manufacturerDAO.getById(id));
        resp.sendRedirect("/manufacturers");
    }
}
