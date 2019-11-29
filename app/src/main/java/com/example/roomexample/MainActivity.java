package com.example.roomexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.roomexample.db.Product;
import com.example.roomexample.db.ProductRepository;

public class MainActivity extends AppCompatActivity {

    private Button btnAddRecord, btndeleteRecord, btnUpdateRecord;
    EditText edtQty, edtProductName, edtDeleteId;
    ProductRepository productRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productRepository = new ProductRepository(getApplicationContext());

        btnUpdateRecord = findViewById(R.id.btnUpdateRecord);
        edtDeleteId = findViewById(R.id.edtDeleteId);
        edtQty = findViewById(R.id.edtQty);
        edtProductName = findViewById(R.id.edtProductName);
        btnAddRecord = findViewById(R.id.btnAddRecord);
        btndeleteRecord = findViewById(R.id.btndeleteRecord);

        btnAddRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                productRepository.insetData(edtProductName.getText().toString(), Integer.parseInt(edtQty.getText().toString()));

                productRepository.getData();
            }
        });


        btndeleteRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                productRepository.deleteData(Integer.parseInt(edtDeleteId.getText().toString()));
            }
        });



        btnUpdateRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                productRepository.updateData(Integer.parseInt(edtDeleteId.getText().toString()),edtProductName.getText().toString(), Integer.parseInt(edtQty.getText().toString()));

            }
        });

        Observer<Product> productObser=new Observer<Product>() {
            @Override
            public void onChanged(Product product) {

            }
        };
    }
}
