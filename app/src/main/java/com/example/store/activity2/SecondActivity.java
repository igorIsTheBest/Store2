package com.example.store.activity2;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.store.databinding.ActivitySecondBinding;
import com.example.store.model.Shop;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SecondActivityViewModel viewModel = new ViewModelProvider(this).get(SecondActivityViewModel.class);
        ActivitySecondBinding binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);

        // Отримання даних магазину з інтента
        if (getIntent().getExtras() != null) {
            Shop shop = (Shop) getIntent().getExtras().getSerializable("SHOP_OBJECT_KEY");
            SecondActivityShopModel tmp = new SecondActivityShopModel(shop);
            viewModel.getMutableLiveData().postValue(tmp);
        }

        // Обробка натискання кнопки назад
        binding.buttonBack.setOnClickListener(v -> {
            // Завершуємо SecondActivity і повертаємось на MainActivity
            finish();
        });
    }
}
