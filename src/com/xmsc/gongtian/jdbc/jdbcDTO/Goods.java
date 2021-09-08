package com.xmsc.gongtian.jdbc.jdbcDTO;

public class Goods {
    private int goodsID;
    private String goodsName;
    private String goodsImg;
    private double goodsPrice;
    private int goodsNum;
    private String goodsDesc;
    private String goodsDetail;
    private int goodsTid;

    public Goods() {
    }

    public Goods(int goodsID, String goodsName, String goodsImg, double goodsPrice, int goodsNum, String goodsDesc, String goodsDetail, int goodsTid) {
        this.goodsID = goodsID;
        this.goodsName = goodsName;
        this.goodsImg = goodsImg;
        this.goodsPrice = goodsPrice;
        this.goodsNum = goodsNum;
        this.goodsDesc = goodsDesc;
        this.goodsDetail = goodsDetail;
        this.goodsTid = goodsTid;
    }

    public int getGoodsID() {
        return goodsID;
    }

    public void setGoodsID(int goodsID) {
        this.goodsID = goodsID;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public int getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(int goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public String getGoodsDetail() {
        return goodsDetail;
    }

    public void setGoodsDetail(String goodsDetail) {
        this.goodsDetail = goodsDetail;
    }

    public int getGoodsTid() {
        return goodsTid;
    }

    public void setGoodsTid(int goodsTid) {
        this.goodsTid = goodsTid;
    }
}
