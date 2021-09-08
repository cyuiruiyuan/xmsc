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

@WebServlet("/GoodsListByTypeServlet")
public class GoodsListByTypeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        int typeID = Integer.parseInt(req.getParameter("tid"));
        int pageNum = Integer.parseInt(req.getParameter("pageNum"));
        int pageSize = 3;

        GoodsDAO goodsDAO = new GoodsDAO();
        List<Goods> goodsList = goodsDAO.listGoods(typeID,pageNum,pageSize);

        List<Type> typeList = new TypeDAO().selectTypeAll();
        int count = goodsDAO.getGoodsCount(typeID);

        int pageCount = count % pageSize == 0? (count/pageSize): (count/pageSize+1);

        req.setAttribute("pageCount",pageCount);
        req.setAttribute("goodsList",goodsList);
        req.setAttribute("pageNum",pageNum);
        req.setAttribute("typeList",typeList);
        req.setAttribute("url","GoodsListByTypeServlet");
        req.setAttribute("typeID",typeID);

        req.getRequestDispatcher("goods_list.jsp").forward(req,resp);
    }
}
