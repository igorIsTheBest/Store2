package com.example.store.data.mappers;

import com.example.store.data.Shop;
import com.example.store.data.room.ShopEntity;

public class ShopEntityToShopMapper implements Mapper<ShopEntity, Shop> {
    @Override
    public Shop map(ShopEntity entity) {
        return new Shop(entity.getId(), entity.getName(), entity.getLocation(), entity.getRevenue());
    }
}
