package com.example.store.new_shop;

public class NewShopModel {
    private String name;
    private String address;
    private String employees;
    private String notes;

    public NewShopModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String title) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmployees() {
        return employees;
    }

    public void setEmployees(String employees) {
        this.employees = employees;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "NewShopModel{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", employees='" + employees + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
