package com.example.store.main_activity;

import androidx.recyclerview.widget.DiffUtil;

import com.example.store.data.Shop;

import java.util.List;

public class ShopsDiffUtils extends DiffUtil.Callback{

    private final List<Shop> oldList;
    private final List<Shop> newList;

    public ShopsDiffUtils(List<Shop> oldList, List<Shop> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        Book oldShop=oldList.get(oldItemPosition);
        Book newShop=newList.get(newItemPosition);
        return oldShop.getId()==newShop.getId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        Shop oldShop=oldList.get(oldItemPosition);
        Shop newShop=newList.get(newItemPosition);
        return oldShop.equals(newShop);
    }

}
