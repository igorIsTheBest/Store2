package com.example.store.data.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "store_cards")
public class StoreCardEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "name")
    public String storeName;

    @ColumnInfo(name = "empl")
    public int empl;

    @ColumnInfo(name = "address")
    public String address;

    public StoreCardEntity(String storeName, int empl, String address) {
        this.storeName = storeName;
        this.empl = empl;
        this.address = address;
    }
}

