package com.xmsc.gongtian.servlet;

import com.xmsc.gongtian.jdbc.jdbcDAO.TypeDAO;
import com.xmsc.gongtian.jdbc.jdbcDTO.Type;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/TypeAddServlet")
public class TypeAddServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //接收类别信息
        req.setCharacterEncoding("UTF-8");
        String typeName = req.getParameter("typeName");
        String typeDesc = req.getParameter("typeDesc");

        Type type = new Type(0,typeName,typeDesc);
        TypeDAO typeDAO = new TypeDAO();
        boolean b = typeDAO.insertType(type);

        req.setAttribute("code",b?0:1);
        req.setAttribute("msg",b?"类别信息添加成功！":"类别信息添加失败！");
        req.getRequestDispatcher("tips.jsp").forward(req,resp);
    }
}
