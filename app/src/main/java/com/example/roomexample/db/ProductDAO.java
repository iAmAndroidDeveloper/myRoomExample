package com.example.roomexample.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ProductDAO {

    @Query("SELECT * FROM products")
    List<Product> getAll();

    @Query("SELECT * FROM products where id=:productID")
    Product getID(int productID);

    @Insert
    void insert(Product product);

    @Delete
    void delete(Product product);

    @Update
    void update(Product product);

    /*For Nots */

    @Insert
    void insertNote(Note note);

    @Query("Select * from Note")
    List<Note> getAllNotes();
}
