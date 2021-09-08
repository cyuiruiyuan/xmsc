package com.xmsc.gongtian.jdbc.jdbcDTO;

public class Manager {
    private int managerID;
    private String managerAccount;
    private String managerPassword;
    private String managerName;
    private String managerImg;
    private String managerTel;

    public Manager() {
    }

    public Manager(int managerID, String managerAccount, String managerPassword, String managerName, String managerImg, String managerTel) {
        this.managerID = managerID;
        this.managerAccount = managerAccount;
        this.managerPassword = managerPassword;
        this.managerName = managerName;
        this.managerImg = managerImg;
        this.managerTel = managerTel;
    }

    public int getManagerID() {
        return managerID;
    }

    public void setManagerID(int managerID) {
        this.managerID = managerID;
    }

    public String getManagerAccount() {
        return managerAccount;
    }

    public void setManagerAccount(String managerAccount) {
        this.managerAccount = managerAccount;
    }

    public String getManagerPassword() {
        return managerPassword;
    }

    public void setManagerPassword(String managerPassword) {
        this.managerPassword = managerPassword;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerImg() {
        return managerImg;
    }

    public void setManagerImg(String managerImg) {
        this.managerImg = managerImg;
    }

    public String getManagerTel() {
        return managerTel;
    }

    public void setManagerTel(String managerTel) {
        this.managerTel = managerTel;
    }
}
