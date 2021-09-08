package com.xmsc.gongtian.servlet;

import com.xmsc.gongtian.jdbc.jdbcDAO.GoodsDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/GoodsDeleteServlet")
public class GoodsDeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        int goodsID = Integer.parseInt(req.getParameter("goodsID"));

        boolean b = new GoodsDAO().deleteGoods(goodsID);

        req.setAttribute("code",b?0:1);
        req.setAttribute("msg",b?"删除商品信息成功！":"删除商品信息失败！");
        req.getRequestDispatcher("tips.jsp").forward(req,resp);

    }
}
