package com.xmsc.gongtian.jdbc.jdbcDAO;

import com.xmsc.gongtian.jdbc.jdbcDTO.Goods;
import com.xmsc.gongtian.jdbc.jdbcHelper.Helper;

import javax.servlet.http.HttpServlet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GoodsDAO {
    private static Connection connection;
    private static PreparedStatement ps;
    private static ResultSet rs;



    public boolean insertGoods(Goods goods){
        int i = 0;

        try{
            connection = Helper.getConnection();

            String sql = "insert into tb_goods(goods_name,goods_img,goods_price,goods_num,goods_desc,goods_detail,goods_tid) values(?,?,?,?,?,?,?)";
            ps = connection.prepareStatement(sql);

            ps.setString(1,goods.getGoodsName());
            ps.setString(2,goods.getGoodsImg());
            ps.setDouble(3,goods.getGoodsPrice());
            ps.setInt(4,goods.getGoodsNum());
            ps.setString(5,goods.getGoodsDesc());
            ps.setString(6,goods.getGoodsDetail());
            ps.setInt(7,goods.getGoodsTid());

            i = ps.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            Helper.close(connection,ps,rs);
        }

        return (i>0);
    }

    public boolean deleteGoods(int goodsID){
        int i = 0;

        try{
            connection = Helper.getConnection();

            String sql = "delete from tb_goods where goods_id = ?;";

            ps = connection.prepareStatement(sql);

            ps.setInt(1,goodsID);

            i = ps.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            Helper.close(connection,ps,rs);
        }

        return (i>0);
    }

    public boolean updateGoods(Goods goods){
        int i = 0;

        try{
            connection = Helper.getConnection();

            String sql = "update tb_goods set goods_name=?,goods_img=?,goods_price=?,goods_num=?,goods_desc=?,goods_detail=?,goods_tid=? where goods_id=?;";

            ps = connection.prepareStatement(sql);


            ps.setString(1,goods.getGoodsName());
            ps.setString(2,goods.getGoodsImg());
            ps.setDouble(3,goods.getGoodsPrice());
            ps.setInt(4,goods.getGoodsNum());
            ps.setString(5,goods.getGoodsDesc());
            ps.setString(6,goods.getGoodsDetail());
            ps.setInt(7,goods.getGoodsTid());
            ps.setInt(8,goods.getGoodsID());


            i = ps.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            Helper.close(connection,ps,rs);
        }

        return (i>0);
    }

    public Goods selectGoods(int goodsID){
        Goods goods = null;

        try{
            connection = Helper.getConnection();

            String sql = "select * from tb_goods where goods_id = ?;";
            ps = connection.prepareStatement(sql);
            ps.setInt(1,goodsID);

            rs = ps.executeQuery();
            if(rs.next()){

                String goodsName = rs.getString("goods_name");
                String goodsImg = rs.getString("goods_img");
                double goodsPrice = rs.getDouble("goods_price");
                int goodsNum = rs.getInt("goods_num");
                String goodsDesc = rs.getString("goods_desc");
                String goodsDetail = rs.getString("goods_detail");
                int goodsTid = rs.getInt("goods_tid");

                goods = new Goods(goodsID,goodsName,goodsImg,goodsPrice,goodsNum,goodsDesc,goodsDetail,goodsTid);
            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            Helper.close(connection,ps,rs);
        }

        return goods;
    }


    public List<Goods> listGoods(int pageNum,int pageSize){
        List<Goods> list = new ArrayList<>();
        try {
            connection = Helper.getConnection();
            String sql = "select * from tb_goods limit ?,?;";
            ps = connection.prepareStatement(sql);
            ps.setInt(1,(pageNum-1)*pageSize);
            ps.setInt(2,pageSize);
            rs = ps.executeQuery();
            while (rs.next()){
                int goodsID = rs.getInt("goods_id");
                String goodsName = rs.getString("goods_name");
                String goodsImg = rs.getString("goods_img");
                double goodsPrice = rs.getDouble("goods_price");
                int goodsNum = rs.getInt("goods_num");
                String goodsDesc = rs.getString("goods_desc");
                String goodsDetail = rs.getString("goods_detail");
                int goodsTid = rs.getInt("goods_tid");
                Goods goods = new Goods(goodsID,goodsName,goodsImg,goodsPrice,goodsNum,goodsDesc,goodsDetail,goodsTid);
                list.add(goods);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            Helper.close(connection,ps,rs);
        }
        return list;
    }

    public List<Goods> listGoods(int goodsTid,int pageNum,int pageSize){
        List<Goods> list = new ArrayList<>();
        try {
            connection = Helper.getConnection();
            String sql = "select * from tb_goods where goods_tid=? limit ?,?;";
            ps = connection.prepareStatement(sql);
            ps.setInt(1,goodsTid);
            ps.setInt(2,(pageNum-1)*pageSize);
            ps.setInt(3,pageSize);
            rs = ps.executeQuery();
            while (rs.next()){
                int goodsID = rs.getInt("goods_id");
                String goodsName = rs.getString("goods_name");
                String goodsImg = rs.getString("goods_img");
                double goodsPrice = rs.getDouble("goods_price");
                int goodsNum = rs.getInt("goods_num");
                String goodsDesc = rs.getString("goods_desc");
                String goodsDetail = rs.getString("goods_detail");

                Goods goods = new Goods(goodsID,goodsName,goodsImg,goodsPrice,goodsNum,goodsDesc,goodsDetail,goodsTid);
                list.add(goods);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            Helper.close(connection,ps,rs);
        }
        return list;
    }

    public int getGoodsCount(){
        int count = 0;
        try{
            connection = Helper.getConnection();

            String sql = "select count(goods_id) from tb_goods";

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

    public int getGoodsCount(int goodsTid){
        int count = 0;
        try{
            connection = Helper.getConnection();

            String sql = "select count(goods_id) from tb_goods where goods_tid=?";

            ps = connection.prepareStatement(sql);
            ps.setInt(1,goodsTid);
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
