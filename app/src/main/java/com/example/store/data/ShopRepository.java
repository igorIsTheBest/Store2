package com.example.store.data;

import com.example.store.data.concurency.TaskCallback;

import java.util.List;

public interface ShopRepository {
    void addNewShop(Shop shop);

    void getAllShops(TaskCallback<List<Shop>> callback);
}
