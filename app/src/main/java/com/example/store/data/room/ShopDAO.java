package com.example.store.data.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ShopDAO {

    // Отримати всі записи з таблиці Shops
    @Query("SELECT * FROM Shops")
    List<ShopEntity> getAll();

    // Вставити новий запис у таблицю Shops
    @Insert
    void insert(ShopEntity shop);

    // Оновити наявний запис у таблиці Shops
    @Update
    void update(ShopEntity shop);

    // Видалити запис з таблиці Shops
    @Delete
    void delete(ShopEntity shop);
}
