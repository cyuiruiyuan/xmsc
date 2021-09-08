package com.xmsc.gongtian.servlet;

import com.xmsc.gongtian.jdbc.jdbcDAO.GoodsDAO;
import com.xmsc.gongtian.jdbc.jdbcDTO.Goods;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet("/GoodsAddServlet")
@MultipartConfig
public class GoodsAddServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");


        String goodsName = req.getParameter("goodsName");

        Part part = req.getPart("goodsImg");//Part 代表文件
        String header = part.getHeader("Content-Disposition");//获取文件头信息（格式为："xxxxxxxxxx.xxx"）
//        System.out.println(header);
        int begin = header.lastIndexOf(".");//获取最后一个 . 的索引位置
        int end = header.lastIndexOf("\"");//获取最后一个 " 的索引位置
        String ext = header.substring(begin,end);//从header中截取文件后缀
        //生成新的文件名
        int num = (int)(Math.random()*9000)+1000;
        String fileName = System.currentTimeMillis()+""+num+ext;
        //保存至files文件夹
        String dir = getServletContext().getRealPath("/files");//获取files文件夹路径
        String savePath = dir + "/" + fileName;//文件存储路径
        part.write(savePath);

        String goodsImg = "files/" + fileName;//文件访问路径

        double goodsPrice = Double.parseDouble(req.getParameter("goodsPrice"));
        int goodsNum = Integer.parseInt(req.getParameter("goodsNum"));
        String goodsDesc = req.getParameter("goodsDesc");
        String goodsDetail = req.getParameter("goodsDetail");
        int goodsTid = Integer.parseInt(req.getParameter("typeID"));

        Goods goods = new Goods(0,goodsName,goodsImg,goodsPrice,goodsNum,goodsDesc,goodsDetail,goodsTid);
        GoodsDAO goodsDAO = new GoodsDAO();
        boolean b = goodsDAO.insertGoods(goods);

        req.setAttribute("code",b?0:1);
        req.setAttribute("msg",b?"商品发布成功！":"商品发布失败！");
        req.getRequestDispatcher("tips.jsp").forward(req,resp);
    }
}
