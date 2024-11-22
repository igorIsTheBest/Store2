package com.example.store;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.store.data.room.StoreCardEntity;
import com.example.store.recycler.StoreCardRecyclerViewAdapter;
import com.example.store.viewmodel.MainViewModel;

import org.koin.java.KoinJavaComponent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Ініціалізація ViewModel через Koin
    private MainViewModel mainViewModel;
    private RecyclerView recyclerView;
    private StoreCardRecyclerViewAdapter adapter;
    private List<StoreCardEntity> allCards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ініціалізація ViewModel через Koin без фабрики
        mainViewModel = KoinJavaComponent.get(MainViewModel.class);

        // Знаходимо елементи інтерфейсу
        EditText editTextName = findViewById(R.id.editTextName);
        EditText editTextAge = findViewById(R.id.editTextAge);
        EditText editTextDiagnosis = findViewById(R.id.editTextDiagnosis);
        Button submitButton = findViewById(R.id.submitButton);
        Button clearButton = findViewById(R.id.clearButton);
        recyclerView = findViewById(R.id.recyclerView);

        // Ініціалізація RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        allCards = new ArrayList<>();
        adapter = new StoreCardRecyclerViewAdapter(allCards);
        recyclerView.setAdapter(adapter);
        loadAllCards();  // Завантаження карт на початку

        // Обробка натискання кнопки для додавання даних
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String storeName = editTextName.getText().toString();
                String emplString = editTextempl.getText().toString();
                String address = editTextaddress.getText().toString();

                // Перевірка, чи всі поля заповнені
                if (storeName.isEmpty() || emplString.isEmpty() || address.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Будь ласка, заповніть всі поля", Toast.LENGTH_SHORT).show();
                    return;
                }

                int age = Integer.parseInt(ageString);
                StoreCardEntity storeCard = new StoreCardEntity(storeName, empl, address);

                // Додаємо пацієнта до БД через ViewModel
                mainViewModel.insertStoreCard(storeCard);

                // Оновлюємо список в реальному часі
                allCards.add(0, storeCard);  // Додаємо нову карту на початок списку
                adapter.notifyItemInserted(0);  // Оновлюємо адаптер тільки для нового елемента
                recyclerView.scrollToPosition(0);  // Прокручуємо до початку
            }
        });

        // Обробка натискання кнопки для очистки бази даних
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Очищуємо базу даних через ViewModel
                mainViewModel.deleteAllCards();
                allCards.clear();  // Очищаємо список у адаптері
                adapter.notifyDataSetChanged();  // Оновлюємо адаптер
                Toast.makeText(MainActivity.this, "База даних очищена", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Завантаження всіх карт з БД через ViewModel
    private void loadAllCards() {
        mainViewModel.getAllStoreCards().observe(this, cards -> {
            allCards.clear();
            allCards.addAll(cards);
            Collections.reverse(allCards);  // Нові карти будуть зверху
            adapter.notifyDataSetChanged();  // Оновлюємо адаптер після завантаження
        });
    }
}
