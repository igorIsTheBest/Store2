package com.example.store.main_activity;

import static org.koin.java.KoinJavaComponent.get;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.store.basic.mvvm.BaseActivity;
import com.example.store.databinding.ActivityMainBinding;
import com.example.store.new_shop.NewShopActivity;


public class MainActivity extends BaseActivity {
    private MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = get(MainActivityViewModel.class);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);

        viewModel.getState().observe(this, state -> {
            if (state.openNewShopActivity) {
                Intent intent = new Intent(MainActivity.this, NewShopActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.reInitList();
    }

    @Override
    public void onCloseScope() {

    }
}