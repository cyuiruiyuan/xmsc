package com.xmsc.gongtian.jdbc.jdbcDAO;

import com.xmsc.gongtian.jdbc.jdbcDTO.Type;
import com.xmsc.gongtian.jdbc.jdbcHelper.Helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TypeDAO {
    private static Connection connection;
    private static PreparedStatement ps;
    private static ResultSet rs;


    /**
     * 添加类别信息
     * @param type
     * @return
     */
    public boolean insertType(Type type){
       int i = 0;

       try{
           connection = Helper.getConnection();

           String sql = "insert into tb_type(type_name,type_desc) values(?,?)";
           ps = connection.prepareStatement(sql);


           ps.setString(1,type.getTypeName());
           ps.setString(2,type.getTypeDesc());

           i = ps.executeUpdate();

       }catch (Exception e){
           e.printStackTrace();
       }finally {
           Helper.close(connection,ps,rs);
       }

       return (i>0);
    }

    /**
     * 删除类别信息
     * @param typeID
     * @return
     */
    public boolean deleteType(int typeID){
        int i = 0;

        try{
            connection = Helper.getConnection();

            String sql = "delete from tb_type where type_id = ?;";

            ps = connection.prepareStatement(sql);

            ps.setInt(1,typeID);

            i = ps.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            Helper.close(connection,ps,rs);
        }

        return (i>0);
    }

    /**
     * 修改类别信息
     * @param type
     * @return
     */
    public boolean updateType(Type type){
        int i = 0;

        try{
            connection = Helper.getConnection();

            String sql = "update tb_type set type_name=?,type_desc=? where type_id=?;";

            ps = connection.prepareStatement(sql);


            ps.setString(1,type.getTypeName());
            ps.setString(2,type.getTypeDesc());
            ps.setInt(3,type.getTypeID());

            i = ps.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            Helper.close(connection,ps,rs);
        }

        return (i>0);
    }

    /**
     * 查询类别信息
     * @param typeID
     * @return
     */
    public Type selectType(int typeID){
        Type type = null;

        try{
            connection = Helper.getConnection();

            String sql = "select * from tb_type where type_id = ?;";
            ps = connection.prepareStatement(sql);
            ps.setInt(1,typeID);

            rs = ps.executeQuery();
            if(rs.next()){
                String typeName = rs.getString("type_name");
                String typeDesc = rs.getString("type_desc");
                type = new Type(typeID,typeName,typeDesc);
            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            Helper.close(connection,ps,rs);
        }

        return type;
    }

    /**
     * 查询所有类别信息
     * @return
     */
    public List<Type> selectTypeAll(){
        List<Type> list = new ArrayList<>();

        try{
            connection = Helper.getConnection();

            String sql = "select * from tb_type;";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                int typeID = rs.getInt("type_id");
                String typeName = rs.getString("type_name");
                String typeDesc = rs.getString("type_desc");
                Type type = new Type(typeID,typeName,typeDesc);
                list.add(type);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            Helper.close(connection,ps,rs);
        }


        return list;

    }

    public static List<Type> selectTypePage(int pageNum,int pageSize){
        List<Type> list = new ArrayList<Type>();

        try{
            connection = Helper.getConnection();

            String sql = "select * from tb_type limit ?,?;";
            ps = connection.prepareStatement(sql);
            ps.setInt(1,(pageNum-1)*pageSize);
            ps.setInt(2,pageSize);

            rs = ps.executeQuery();
            while (rs.next()){
                Type type = new Type();
                type.setTypeID(rs.getInt("type_id"));
                type.setTypeName(rs.getString("type_name"));
                type.setTypeDesc(rs.getString("type_desc"));
                list.add(type);
            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            Helper.close(connection,ps,rs);
        }


        return list;
    }

    public static int getTypeCount(){
        int count = 0;
        try{
            connection = Helper.getConnection();

            String sql = "select count(type_id) from tb_type";

            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                count = rs.getInt(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            Helper.close(connection,ps,rs);
        }
        return count;
    }

}
