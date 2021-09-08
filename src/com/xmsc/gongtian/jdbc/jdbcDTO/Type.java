package com.xmsc.gongtian.jdbc.jdbcDTO;

public class Type {
    private int typeID;
    private String typeName;
    private String typeDesc;

    public Type() {
    }

    public Type(int typeID, String typeName, String typeDesc) {
        this.typeID = typeID;
        this.typeName = typeName;
        this.typeDesc = typeDesc;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }
}
