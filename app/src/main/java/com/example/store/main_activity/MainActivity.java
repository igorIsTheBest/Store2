package com.example.store.main_activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.store.databinding.ActivityMainBinding;
import com.example.store.new_shop.NewShopActivity;


public class MainActivity extends AppCompatActivity {


    private MainActivityViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        viewModel.setShopRepository(BookDatabase.getInstance(getApplicationContext()));
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);

        viewModel.getState().observe(this,state -> {
            if (state.openNewShopActivity){
                Intent intent=new Intent(MainActivity.this, NewShopActivity.class);
                startActivity(intent);
            }
        });


        //make minor changes
        //make major changes
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.reInitList();
    }
}