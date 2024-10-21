package com.example.store.data.mappers;

import com.example.store.data.Shop;
import com.example.store.data.room.ShopEntity;

import java.util.ArrayList;
import java.util.List;

public class ShopEntitiesListToShopListMapper implements Mapper<List<ShopEntity>, List<Shop>> {

    @Override
    public List<Shop> map(List<ShopEntity> entities) {
        ShopEntityToShopMapper mapper = new ShopEntityToShopMapper();
        List<Shop> shops = new ArrayList<>();
        for (ShopEntity entity : entities) {
            shops.add(mapper.map(entity));
        }
        return shops;
    }
}
