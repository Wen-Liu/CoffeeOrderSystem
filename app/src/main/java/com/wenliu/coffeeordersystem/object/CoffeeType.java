package com.wenliu.coffeeordersystem.object;

public class CoffeeType {

    private String mImage;
    private String mName;
    private int mPrice;
    private int mCups;
    private Boolean mIced;
    private Boolean mSugar;

    public CoffeeType() {
        mName = "";
        mName = "";
        mPrice = -1;
        mCups = -1;
        mIced = null;
        mSugar = null;
    }

    public CoffeeType(CoffeeItem coffeeItem) {
        mImage = coffeeItem.getImage();
        mName = coffeeItem.getName();
        mPrice = coffeeItem.getPrice();
        mCups = -1;
        mIced = null;
        mSugar = null;
    }


    public String getImage() {
        return mImage;
    }

    public void setImage(String image) {
        mImage = image;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getPrice() {
        return mPrice;
    }

    public void setPrice(int price) {
        mPrice = price;
    }

    public int getCups() {
        return mCups;
    }

    public void setCups(int cups) {
        mCups = cups;
    }

    public Boolean getIced() {
        return mIced;
    }

    public void setIced(Boolean iced) {
        mIced = iced;
    }

    public Boolean getSugar() {
        return mSugar;
    }

    public void setSugar(Boolean sugar) {
        mSugar = sugar;
    }
}
