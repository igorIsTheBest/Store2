package com.example.store.data;

import java.util.Objects;

public class Shop {
    private int id;
    private String name;
    private String address;
    private int employees;
    private String note;

    public Shop() {
    }

    public Shop(String name, String address, int employees) {
        this.name = name;
        this.address = address;
        this.employees = employees;
    }

    public Shop(int id, String name, String address, int employees) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.employees = employees;
    }

    public Shop(String name, String address, int employees, String note) {
        this.name = name;
        this.address = address;
        this.employees = employees;
        this.note = note;
    }
    public Shop(int id, String name, String address, int employees, String note) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.employees = employees;
        this.note = note;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

    public int getEmployees() {
        return employees;
    }

    public void setEmployees(int employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        return id == shop.id && employees == shop.employees && Objects.equals(name, shop.name) && Objects.equals(address, shop.address) && Objects.equals(note, shop.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, employees, note);
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", employees=" + employees +
                ", note='" + note + '\'' +
                '}';
    }
}
