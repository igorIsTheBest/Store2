package com.example.store.activity2;

import com.example.store.model.Shop;

public class SecondActivityShopModel {
    private String name;
    private String address;
    private String employeeCount;

    public SecondActivityShopModel() {
        this.name = "";
        this.address = "";
        this.employeeCount = "";
    }

    public SecondActivityShopModel(Shop shop) {
        this.name = shop.getName();
        this.address = shop.getAddress();
        this.employeeCount = String.valueOf(shop.getEmployeeCount());
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
}
