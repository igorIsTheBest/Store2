package com.example.store.new_shop;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.store.data.Shop;
import com.example.store.data.ShopRepository;
import com.example.store.data.mappers.Mapper;

public class NewShopViewModel extends ViewModel {

    private final MutableLiveData<NewShopModel> newShopModelMutableLiveData;
    private final MutableLiveData<State> state;
    private final ShopRepository shopRepository;

    public NewShopViewModel(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
        newShopModelMutableLiveData = new MutableLiveData<>(new NewShopModel());
        state = new MutableLiveData<>(new State());
    }

    public MutableLiveData<NewShopModel> getNewShopModelMutableLiveData() {
        return newShopModelMutableLiveData;
    }

    public MutableLiveData<State> getState() {
        return state;
    }

    public void onSaveClicked(View v) {
        shopRepository.addNewShop(mapper.map(newShopModelMutableLiveData.getValue()));
        finish();
    }

    public void finish() {
        State tmp = state.getValue();
        if (tmp != null) {
            tmp.needFinish = true;
            state.postValue(tmp);
        }
    }

    private final Mapper<NewShopModel, Shop> mapper = value -> {
        return new Shop(value.getTitle(), value.getAuthor(), Integer.parseInt(value.getPages()), value.getNotes());
    };

    public class State {
        boolean needFinish;
    }
}
