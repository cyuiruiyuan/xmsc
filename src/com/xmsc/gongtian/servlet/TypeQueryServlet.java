package com.xmsc.gongtian.servlet;

import com.xmsc.gongtian.jdbc.jdbcDAO.TypeDAO;
import com.xmsc.gongtian.jdbc.jdbcDTO.Type;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/TypeQueryServlet")
public class TypeQueryServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        int typeID = Integer.parseInt(req.getParameter("tid"));
        TypeDAO typeDAO = new TypeDAO();
        Type type = typeDAO.selectType(typeID);

        req.setAttribute("type",type);
        req.getRequestDispatcher("type_modify.jsp").forward(req,resp);
    }
}
