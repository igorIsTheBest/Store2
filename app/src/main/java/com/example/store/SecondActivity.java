package com.example.store;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView textViewDetails = findViewById(R.id.textViewDetails);
        Button buttonBack = findViewById(R.id.buttonBack);

        // Отримання Shop
        Intent intent = getIntent();
        Shop shop = (Shop) intent.getSerializableExtra("shop");

        if (shop != null) {
            String details = "Назва магазину: " + shop.getName() + "\nАдреса: " + shop.getAddress() + "\nКількість співробітників: " + shop.getEmployeeCount();
            textViewDetails.setText(details);
        } else {
            textViewDetails.setText("Інформація про магазин");
        }

        // Обробка кнопки назад
        buttonBack.setOnClickListener(v -> finish());
    }
}

