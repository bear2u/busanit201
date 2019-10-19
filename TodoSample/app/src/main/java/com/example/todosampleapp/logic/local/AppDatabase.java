package com.example.todosampleapp.logic.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.todosampleapp.model.Item;

@Database(entities = {Item.class},
        version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ItemDao getItemDao();
}
