package com.wenliu.coffeeordersystem.object;

import java.util.ArrayList;
import java.util.List;

public class CoffeeOrder {

    private String mAccount;
    private List<String> mContent;
    private int mItemCount;
    private int mPrice;
    private int mStatus;
    private String mTime;


    public CoffeeOrder() {
        mAccount = "test@gmail.com";
        mContent = new ArrayList<>();
        mItemCount = -1;
        mPrice = -1;
        mStatus = -1;
        mTime = "";
    }


    public String getAccount() {
        return mAccount;
    }

    public void setAccount(String account) {
        mAccount = account;
    }

    public List<String> getContent() {
        return mContent;
    }

    public void setContent(List<String> content) {
        mContent = content;
    }

    public int getItemCount() {
        return mItemCount;
    }

    public void setItemCount(int itemCount) {
        mItemCount = itemCount;
    }

    public int getPrice() {
        return mPrice;
    }

    public void setPrice(int price) {
        mPrice = price;
    }

    public int getStatus() {
        return mStatus;
    }

    public void setStatus(int status) {
        mStatus = status;
    }

    public String getTime() {
        return mTime;
    }

    public void setTime(String time) {
        mTime = time;
    }
}
