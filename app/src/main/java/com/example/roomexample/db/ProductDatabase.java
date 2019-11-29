package com.example.roomexample.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Product.class, Note.class}, version = 1, exportSchema = false)
abstract class ProductDatabase extends RoomDatabase {
    abstract ProductDAO productDAO();
}
