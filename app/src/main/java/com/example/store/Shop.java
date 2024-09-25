package com.example.store;

import java.io.Serializable;

public class Shop implements Serializable {
    private String name;  // Назва магазину
    private String address;  // Адреса магазину
    private int employeeCount;  // Кількість співробітників

    // Конструктор
    public Shop(String name, String address, int employeeCount) {
        this.name = name;
        this.address = address;
        this.employeeCount = employeeCount;
    }

    // Гетери і сетери
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

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }
}
