package com.wenliu.coffeeordersystem.object;

public class CoffeeItem {

    private String mImage;
    private String mName;
    private int mPrice;

    public CoffeeItem() {
        mImage = "";
        mName = "";
        mPrice = -1;
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
}
