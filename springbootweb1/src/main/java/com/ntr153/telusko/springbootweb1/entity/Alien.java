package com.ntr153.telusko.springbootweb1.entity;

public class Alien {
    int aId;
    String aName;

    @Override
    public String toString() {
        return "Alien [aId=" + aId + ", aName=" + aName + "]";
    }
    
    public int getaId() {
        return aId;
    }
    public void setaId(int aId) {
        this.aId = aId;
    }
    public String getaName() {
        return aName;
    }
    public void setaName(String aName) {
        this.aName = aName;
    }

    
}
