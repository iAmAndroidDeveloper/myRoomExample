package com.example.roomexample.db;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.room.Room;

import java.util.List;

public class ProductRepository {

    private String DB_NAME = "db_product";

    private ProductDatabase productDatabase;
    Product testId;

    public ProductRepository(Context context) {
        productDatabase = Room.databaseBuilder(context, ProductDatabase.class, DB_NAME).build();
    }

    public void insetData(String name, int QTY) {
        Product product = new Product();
        product.setProductName(name);
        product.setQty(QTY);
        insertData(product);
    }

    @SuppressLint("StaticFieldLeak")
    private void insertData(final Product product) {
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                productDatabase.productDAO().insert(product);
                return null;
            }
        }.execute();
    }

    @SuppressLint("StaticFieldLeak")
    public void getData() {
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {

                List<Product> products = productDatabase.productDAO().getAll();

                for (int i = 0; i < products.size(); i++) {
                    Log.e("TAG", "doInBackground: " + products.get(i).getId() + " " + products.get(i).getProductName() + " " + products.get(i).getQty());

                }

                return null;
            }
        }.execute();
    }

    @SuppressLint("StaticFieldLeak")
    public void deleteData(int id) {

        final Product list = getProductID(id);
        if (list != null) {
            new AsyncTask<Void, Void, Void>() {

                @Override
                protected Void doInBackground(Void... voids) {
                    productDatabase.productDAO().delete(list);
                    getData();
                    return null;
                }
            }.execute();
        }
    }

    @SuppressLint("StaticFieldLeak")
    private Product getProductID(final int id) {

        new AsyncTask<Void, Void, Product>() {

            @Override
            protected Product doInBackground(Void... voids) {
                return productDatabase.productDAO().getID(id);

            }

            @Override
            protected void onPostExecute(Product product) {
                super.onPostExecute(product);
                testId = product;
            }
        }.execute();
        return testId;
    }


    @SuppressLint("StaticFieldLeak")
    public void updateData(int id, final String name, final int qty) {

        final Product list = getProductID(id);
        if (list != null) {
            new AsyncTask<Void, Void, Void>() {

                @Override
                protected Void doInBackground(Void... voids) {
                    list.setProductName(name);
                    list.setQty(qty);
                    productDatabase.productDAO().update(list);
                    getData();
                    return null;
                }
            }.execute();
        }
    }

    public void insertNoteData(String desc) {
        Note note = new Note();
        note.setDescription(desc);
        setNote(note);
    }

    private void setNote(final Note note) {
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {

                productDatabase.productDAO().insertNote(note);
                return null;
            }
        }.execute();
    }
}
