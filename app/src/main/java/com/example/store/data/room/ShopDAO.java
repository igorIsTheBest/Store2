package com.example.store.data.room;

package com.example.store.data.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;


@Dao
public interface ShopDAO {
    @Query("SELECT * FROM Shops")
    List<ShopEntity> getAll();

    @Insert
    void insert(ShopEntity shop);

}
