package com.xmsc.gongtian.servlet;

import com.xmsc.gongtian.jdbc.jdbcDAO.TypeDAO;
import com.xmsc.gongtian.jdbc.jdbcDTO.Type;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/TypeUpdateServlet")
public class TypeUpdateServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        int typeID = Integer.parseInt(req.getParameter("typeID"));
        String typeName = req.getParameter("typeName");
        String typeDesc = req.getParameter("typeDesc");

        Type type = new Type(typeID,typeName,typeDesc);
        TypeDAO typeDAO = new TypeDAO();
        boolean b = typeDAO.updateType(type);

        req.setAttribute("code",b?0:1);
        req.setAttribute("msg",b?"修改类别信息成功！":"修改类别信息失败！");
        req.getRequestDispatcher("tips.jsp").forward(req,resp);


    }
}
