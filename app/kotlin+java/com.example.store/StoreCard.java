package com.example.store;

public class StoreCard {
    private String storeName; // Ім'я пацієнта (рядок)
    private int empl; // Вік пацієнта (ціле число)
    private String address; // Діагноз пацієнта (рядок)

    // Конструктор для створення об'єкта StoreCard
    public StoreCard(String storeName, int empl, String address) {
        this.storeName = storeName;
        this.empl = empl;
        this.address = address;
    }

    // Геттери та сеттери для властивостей
    public String getStoreName() { return storeName; }
    public void setStoreName(String storeName) { this.storeName = storeName; }

    public int getEmpl() { return empl; }
    public void setEmpl(int empl) { this.empl = empl; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}
