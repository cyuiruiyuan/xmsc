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

@WebServlet("/GoodsListServlet")
public class GoodsListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int pageNum = Integer.parseInt(req.getParameter("pageNum"));
        int pageSize = 3;

        GoodsDAO goodsDAO = new GoodsDAO();
        List<Goods> goods = goodsDAO.listGoods(pageNum,pageSize);

        TypeDAO typeDAO = new TypeDAO();
        List<Type> typeList = typeDAO.selectTypeAll();


        int count = goodsDAO.getGoodsCount();
        int pageCount = count % pageSize == 0? (count/pageSize): (count/pageSize+1);

        req.setAttribute("typeList",typeList);
        req.setAttribute("goodsList",goods);
        req.setAttribute("pageNum",pageNum);
        req.setAttribute("pageCount",pageCount);
        req.setAttribute("url","GoodsListServlet");
        req.getRequestDispatcher("goods_list.jsp").forward(req,resp);
    }
}
