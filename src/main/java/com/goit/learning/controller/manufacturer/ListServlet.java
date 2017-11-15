package com.goit.learning.controller.manufacturer;

import com.goit.learning.dao.GenericDAO;
import com.goit.learning.dao.hibernate.EntityDaoHolder;
import com.goit.learning.model.Manufacturer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;
import java.util.UUID;

public class ListServlet extends HttpServlet {
    GenericDAO<Manufacturer, UUID> manufacturerDAO = EntityDaoHolder.getDao(Manufacturer.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Set<Manufacturer> manufacturers = manufacturerDAO.readAll();
        req.setAttribute("manufacturers", manufacturers);
        req.getRequestDispatcher("manufacturers.jsp").forward(req, resp);
    }
}
