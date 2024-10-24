package com.example.store.data.mappers;

import com.example.store.data.Shop;
import com.example.store.data.room.ShopEntity;

public class ShopEntityToShopMapper implements Mapper<ShopEntity, Shop> {
    @Override
    public Shop map(ShopEntity val) {
        return new Shop(val.getId(), val.getTitle(), val.getAuthor(), val.getPages(), val.getNote());
    }
}
