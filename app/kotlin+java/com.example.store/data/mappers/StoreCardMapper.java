package com.example.store.data.mappers;

import com.example.store.StoreCard;
import com.example.store.data.room.StoreCardEntity;

import java.util.ArrayList;
import java.util.List;

public class StoreCardMapper {

    public static StoreardEntity mapToEntity(StoreCard domainModel) {
        return new StoreCardEntity(domainModel.getStoreName(), domainModel.getEmpl(), domainModel.getAddress());
    }

    public static MedicalCard mapToDomainModel(StoreCardEntity entity) {
        return new StoreCard(entity.patientName, entity.age, entity.diagnosis);
    }

    public static List<StoreCard> mapToDomainModelList(List<StoreCardEntity> entityList) {
        List<StoreCard> domainList = new ArrayList<>();
        for (StoreCardEntity entity : entityList) {
            domainList.add(mapToDomainModel(entity));
        }
        return domainList;
    }
}
