package com.quercusdata.itxdemo.mapper;

import com.quercusdata.itxdemo.entity.Fare;
import com.quercusdata.itxdemo.model.FareModel;
import org.springframework.stereotype.Component;

@Component
public class FareMapper {

    public Fare mapApiToPersistence(FareModel fareModel) {
        Fare fare = new Fare();
        fare.setId(fareModel.getId());
        fare.setBrandId(fareModel.getBrandId());
        fare.setPrice(fareModel.getPrice());
        fare.setStartDate(fareModel.getStartDate());
        fare.setEndDate(fareModel.getEndDate());
        fare.setProductId(fareModel.getProductId());
        return fare;
    }

    public FareModel mapPersistenceToApi(Fare fare) {
        FareModel fareModel = new FareModel();
        fareModel.setId(fare.getId());
        fareModel.setPrice(fare.getPrice());
        fareModel.setBrandId(fare.getBrandId());
        fareModel.setEndDate(fare.getEndDate());
        fareModel.setProductId(fare.getProductId());
        fareModel.setStartDate(fare.getStartDate());
        return fareModel;
    }
}
