package com.example.store.data.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {StoreCardEntity.class}, version = 2, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract StoreCardDAO storeCardDAO();
}

