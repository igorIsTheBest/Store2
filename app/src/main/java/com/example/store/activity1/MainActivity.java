package com.example.store.activity1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.store.R;
import com.example.store.activity2.SecondActivity;
import com.example.store.databinding.ActivityMainBinding;
import com.example.store.data.room.ShopEntity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivityViewModel viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);

        viewModel.getMutableLiveData().observe(this, mainActivityShopModel -> {
            if (mainActivityShopModel.isNeedToShowMessage()) {
                Toast.makeText(MainActivity.this, getString(R.string.please_fill_all_fields), Toast.LENGTH_LONG).show();
                mainActivityShopModel.setNeedToShowMessage(false);
                viewModel.getMutableLiveData().postValue(mainActivityShopModel);
            }
            if (mainActivityShopModel.isNeedToStartNewActivity()) {
                mainActivityShopModel.setNeedToStartNewActivity(false);
                viewModel.getMutableLiveData().postValue(mainActivityShopModel);
                Shop shop = new Shop(mainActivityShopModel.getName(), mainActivityShopModel.getAddress(),
                        Integer.parseInt(mainActivityShopModel.getEmployeeCount()));
                Intent startSecondActivityIntent = new Intent(MainActivity.this, SecondActivity.class);
                startSecondActivityIntent.putExtra("SHOP_OBJECT_KEY", shop);
                startActivity(startSecondActivityIntent);
            }
        });
    }
}
