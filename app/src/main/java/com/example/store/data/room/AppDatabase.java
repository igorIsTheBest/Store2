package com.example.store.data.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {BookEntity.class, ShopEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    // DAO для роботи з BookEntity
    public abstract BookDAO getBookDAO();

    // DAO для роботи з ShopEntity
    public abstract ShopDAO getShopDAO();
}
