package com.example.store.data;

import android.content.Context;

import androidx.room.Room;

import com.example.store.data.concurrency.TaskCallback;
import com.example.store.data.mappers.ShopEntitiesListToShopList;
import com.example.store.data.mappers.ShopToShopEntityMapper;
import com.example.store.data.room.AppDatabase;
import com.example.store.data.room.ShopDAO;
import com.example.store.data.room.ShopEntity;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ShopDatabase implements ShopRepository {

    private static ShopDatabase instance = null;
    private final AppDatabase db;
    private final ExecutorService executorService;
    private ShopDAO shopDAO;

    private ShopToShopEntityMapper shopToShopEntityMapper = new ShopToShopEntityMapper();
    private ShopEntitiesListToShopList shopEntitiesListToShopList = new ShopEntitiesListToShopList();

    private ShopDatabase(Context context) {
        db = Room.databaseBuilder(context.getApplicationContext(),
                AppDatabase.class, "ShopDB").build();
        executorService = Executors.newSingleThreadExecutor();
        shopDAO = db.getShopDAO();
    }

    public static synchronized ShopDatabase getInstance(Context context) {
        if (instance == null) {
            instance = new ShopDatabase(context);
        }
        return instance;
    }

    @Override
    public void addNewShop(Shop shop) {
        executorService.submit(() -> {
            shopDAO.insert(shopToShopEntityMapper.map(shop));
        });
    }

    @Override
    public void getAllShops(TaskCallback<List<Shop>> callback) {
        executorService.submit(() -> {
            List<ShopEntity> shops = shopDAO.getAll();
            callback.onComplete(shopEntitiesListToShopList.map(shops));
        });
    }
}