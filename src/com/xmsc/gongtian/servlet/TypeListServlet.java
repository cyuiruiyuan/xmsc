package com.xmsc.gongtian.servlet;

import com.xmsc.gongtian.jdbc.jdbcDAO.TypeDAO;
import com.xmsc.gongtian.jdbc.jdbcDTO.Type;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/TypeListServlet")
public class TypeListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        TypeDAO typeDAO = new TypeDAO();
        List<Type> list = typeDAO.selectTypeAll();

        req.setAttribute("typesList",list);
        req.getRequestDispatcher("type_list.jsp").forward(req,resp);
    }
}
