package com.example.store.new_shop;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.store.data.ShopRepository;
import com.example.store.data.mappers.Mapper;

public class NewShopViewModel extends ViewModel {

    private final MutableLiveData<NewShopModel> newBookModelMutableLiveData;
    private final MutableLiveData<State> state;
    private ShopRepository shopRepository;

    public NewShopViewModel() {
        newShopModelMutableLiveData = new MutableLiveData<>(new NewShopModel());
        state = new MutableLiveData<>(new State());
    }

    public void setShopRepository(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public MutableLiveData<NewShopModel> getNewShopModelMutableLiveData() {
        return newShopModelMutableLiveData;
    }

    public MutableLiveData<State> getState() {
        return state;
    }

    public void onSaveClicked(View v){
        shopRepository.addNewShop(mapper.map(newShopModelMutableLiveData.getValue()));
        finish();
    }

    public void finish(){
        State tmp=state.getValue();
        if (tmp != null) {
            tmp.needFinish=true;
            state.postValue(tmp);
        }
    }
    private final Mapper<NewShopModel,Shop> mapper = value -> {
        return new Shop(value.getName(),value.getAddress(),Integer.parseInt(value.getEmployees()),value.getNotes());
    };

    public class State{
        boolean needFinish;
    }
}
