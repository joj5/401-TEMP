package com.example.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {FoodItem.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract FoodDao foodDao();
}
