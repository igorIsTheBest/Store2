package com.example.store.activity2;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SecondActivityViewModel extends ViewModel {
    private final MutableLiveData<SecondActivityShopModel> mutableLiveData;

    public SecondActivityViewModel() {
        mutableLiveData = new MutableLiveData<>(new SecondActivityShopModel());
    }

    public MutableLiveData<SecondActivityShopModel> getMutableLiveData() {
        return mutableLiveData;
    }
}
