package com.example.store.activity1;

import com.example.store.model.Shop;

public class MainActivityShopModel {
    private String name;
    private String address;
    private String employeeCount;
    private boolean needToShowMessage;
    private boolean needToStartNewActivity;

    public MainActivityShopModel() {
        this.name = "";
        this.address = "";
        this.employeeCount = "";
        this.needToShowMessage = false;
        this.needToStartNewActivity = false;
    }

    public MainActivityShopModel(Shop shop) {
        this.name = shop.getName();
        this.address = shop.getAddress();
        this.employeeCount = String.valueOf(shop.getEmployeeCount());
        this.needToShowMessage = false;
        this.needToStartNewActivity = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(String employeeCount) {
        this.employeeCount = employeeCount;
    }

    public boolean isNeedToShowMessage() {
        return needToShowMessage;
    }

    public void setNeedToShowMessage(boolean needToShowMessage) {
        this.needToShowMessage = needToShowMessage;
    }

    public boolean isNeedToStartNewActivity() {
        return needToStartNewActivity;
    }

    public void setNeedToStartNewActivity(boolean needToStartNewActivity) {
        this.needToStartNewActivity = needToStartNewActivity;
    }
}
