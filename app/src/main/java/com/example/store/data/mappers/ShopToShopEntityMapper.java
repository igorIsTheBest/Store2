package com.example.store.data.mappers;

import com.example.store.data.Shop;
import com.example.store.data.room.ShopEntity;

public class ShopToShopEntityMapper implements Mapper<Shop, ShopEntity> {
    @Override
    public ShopEntity map(Shop shop) {
        return new ShopEntity(shop.getName(), shop.getLocation(), shop.getRevenue());
    }
}
