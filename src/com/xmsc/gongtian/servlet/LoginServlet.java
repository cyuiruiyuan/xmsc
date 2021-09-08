package com.xmsc.gongtian.servlet;

import com.xmsc.gongtian.jdbc.jdbcDAO.ManagerDAO;
import com.xmsc.gongtian.jdbc.jdbcDTO.Manager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("----------处理请求！---------------");

        //1.页面提交方式为post
        //2.处理中文编码 通过req设置编码格式为utf-8
        req.setCharacterEncoding("UTF-8");
        //3.接收处理数据
        String managerAccount = req.getParameter("managerAccount");
        String managerPassword = req.getParameter("managerPassword");
        //4.调用managerDAO方法验证账号和密码
        ManagerDAO managerDAO = new ManagerDAO();
        Manager manager = ManagerDAO.queryManagerAccountAndPassword(managerAccount,managerPassword);

        if(manager == null){
            //登陆失败跳转到login.jsp
            //转发跳转，可传值，传递提示信息
            req.setAttribute("errorMsg","账号或密码错误！");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }else{
            //登陆成功跳转
            //重定向跳转，不可传值
                //登陆成功，将管理员信息放到session缓存
            req.getSession().setAttribute("manager",manager);
            resp.sendRedirect("index.jsp");
        }
    }
}
