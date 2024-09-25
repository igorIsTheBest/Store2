package com.example.store;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
// Початок
public class MainActivity extends AppCompatActivity {

    private EditText editTextName, editTextAddress, editTextEmployeeCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextAddress = findViewById(R.id.editTextAddress);
        editTextEmployeeCount = findViewById(R.id.editTextEmployeeCount);

        Button buttonSubmit = findViewById(R.id.buttonSubmit);
        buttonSubmit.setOnClickListener(v -> {
            String name = editTextName.getText().toString();
            String address = editTextAddress.getText().toString();
            String employeeCountStr = editTextEmployeeCount.getText().toString();

            // Перевірка на пусті поля
            if (name.isEmpty() || address.isEmpty() || employeeCountStr.isEmpty()) {
                Toast.makeText(MainActivity.this, "Заповніть всі поля", Toast.LENGTH_SHORT).show();
                return;
            }

            int employeeCount = Integer.parseInt(employeeCountStr);

            // Створення об'єкту Shop
            Shop shop = new Shop(name, address, employeeCount);

            // Створення запуску SecondActivity
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("shop", shop);
            startActivity(intent);
        });
    }
}
