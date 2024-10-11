package com.example.store.activity1;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
    private final MutableLiveData<MainActivityShopModel> mutableLiveData;

    public MainActivityViewModel() {
        mutableLiveData = new MutableLiveData<>(new MainActivityShopModel());
    }

    public MutableLiveData<MainActivityShopModel> getMutableLiveData() {
        return mutableLiveData;
    }

    public void onNextButtonClicked(View v) {
        MainActivityShopModel tmp = mutableLiveData.getValue();
        if (tmp != null) {
            if (isAllFieldsFilled()) {
                tmp.setNeedToStartNewActivity(true);
            } else {
                tmp.setNeedToShowMessage(true);
            }
            mutableLiveData.setValue(tmp);
        }
    }

    private boolean isAllFieldsFilled() {
        MainActivityShopModel tmp = mutableLiveData.getValue();
        return tmp != null && !tmp.getName().isEmpty() && !tmp.getAddress().isEmpty() && !tmp.getEmployeeCount().isEmpty();
    }
}
