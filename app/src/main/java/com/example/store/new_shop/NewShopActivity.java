package com.example.store.new_shop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.store.R;
import com.example.store.data.ShopDatabase;
import com.example.store.databinding.ActivityMainBinding;
import com.example.store.databinding.ActivityNewBookBinding;

public class NewShopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        NewShopViewModel viewModel = new ViewModelProvider(this).get(NewShopViewModel.class);
        viewModel.setShopRepository(ShopDatabase.getInstance(getApplicationContext()));
        ActivityNewBookBinding binding = ActivityNewShopBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);

        viewModel.getState().observe(this,state -> {
            if(state.needFinish)
                NewShopActivity.this.finish();
        });
    }
}