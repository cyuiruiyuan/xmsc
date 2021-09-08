package com.xmsc.gongtian.servlet;

import com.xmsc.gongtian.jdbc.jdbcDAO.GoodsDAO;
import com.xmsc.gongtian.jdbc.jdbcDAO.TypeDAO;
import com.xmsc.gongtian.jdbc.jdbcDTO.Goods;
import com.xmsc.gongtian.jdbc.jdbcDTO.Type;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/GoodsQueryServlet")
public class GoodsQueryServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int goodsID = Integer.parseInt(req.getParameter("goodsID"));

        Goods goods = new GoodsDAO().selectGoods(goodsID);
        List<Type> typeList = new TypeDAO().selectTypeAll();

        req.setAttribute("typeList",typeList);
        req.setAttribute("goods",goods);
        req.getRequestDispatcher("goods_modify.jsp").forward(req,resp);
    }
}
