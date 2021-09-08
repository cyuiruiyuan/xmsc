package com.xmsc.gongtian.jdbc.jdbcDAO;

import com.xmsc.gongtian.jdbc.jdbcDTO.Manager;
import com.xmsc.gongtian.jdbc.jdbcHelper.Helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ManagerDAO {
    private static Connection connection;
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static Manager queryManagerAccountAndPassword(String managerAccount,String managerPassword){
        Manager manager = null;

        try{
            connection = Helper.getConnection();

            String sql = "select * from tb_manager where mgr_account=? and mgr_pwd=?";

            ps = connection.prepareStatement(sql);
            ps.setString(1,managerAccount);
            ps.setString(2,managerPassword);

            rs = ps.executeQuery();
            while (rs.next()){
                int managerID = rs.getInt("mgr_id");
                String managerName = rs.getString("mgr_name");
                String managerImg = rs.getString("mgr_img");
                String managerTel = rs.getString("mgr_tel");
                manager = new Manager(managerID,managerAccount,managerPassword,managerName,managerImg,managerTel);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            Helper.close(connection,ps,rs);
        }
        return manager;
    }
}
