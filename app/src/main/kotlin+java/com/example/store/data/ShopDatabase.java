package com.example.store.data;

import android.content.Context;

import androidx.room.Room;

import com.example.store.basic.concurency.TaskCallback;

import com.example.store.data.room.AppDatabase;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ShopDatabase implements ShopRepository {

    private final ExecutorService executorService;
    private final ShopDAO shopDAO;

    private final ShopToShopEntityMapper shopToShopEntityMapper = new ShopToShopEntityMapper();
    private final ShopEntitiesListToShopList shopEntitiesListToShopList = new ShopEntitiesListToShopList();

    public ShopDatabase(Context context) {
        AppDatabase db = Room.databaseBuilder(context.getApplicationContext(),
                AppDatabase.class, "ShopDB").build();
        executorService = Executors.newSingleThreadExecutor();
        shopDAO = db.getShopDAO();
    }

    public void addNewShop(Shop shop) {
        executorService.submit(() -> {
            shopDAO.insert(shopToShopEntityMapper.map(shop));
        });
    }

    @Override
    public void getAllShops(TaskCallback<List<Shop>> callback) {
        executorService.submit(() -> {
            List<ShopEntity> books = shopDAO.getAll();
            callback.onCompleted(shopEntitiesListToShopList.map(shops), null);
        });
    }


}
