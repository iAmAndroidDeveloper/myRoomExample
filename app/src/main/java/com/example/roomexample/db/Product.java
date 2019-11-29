package com.example.roomexample.db;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "products")
public class Product implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "productName")
    private String productName;

    @ColumnInfo(name = "productQTY")
    private int qty;



    /*
     * Getters and Setters
     * */


    int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    String getProductName() {
        return productName;
    }

    void setProductName(String productName) {
        this.productName = productName;
    }

    int getQty() {
        return qty;
    }

    void setQty(int qty) {
        this.qty = qty;
    }
}
