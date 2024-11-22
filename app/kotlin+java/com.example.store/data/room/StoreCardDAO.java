package com.example.store.data.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface StoreCardDAO {

    // Метод отримання всіх записів
    @Query("SELECT * FROM store_cards")
    List<StoreCardEntity> getAll();


    @Insert
    void insert(StoreCardEntity storeCard);  /
    // Метод для видалення всіх записів
    @Query("DELETE FROM store_cards")
    void deleteAll();  // Очищає таблицю
}
