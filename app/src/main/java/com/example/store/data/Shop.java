package com.example.store.data;

public class Shop {
    private int id;  // Ідентифікатор сутності
    private String name;  // Назва магазину
    private String address;  // Адреса магазину
    private int employeeCount;  // Кількість співробітників

    // Конструктор
    public Shop(int id, String name, String address, int employeeCount) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.employeeCount = employeeCount;
    }

    // Гетери і сетери
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }
}
