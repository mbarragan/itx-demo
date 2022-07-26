package com.quercusdata.itxdemo.service;

import com.quercusdata.itxdemo.model.FareModel;

import java.util.List;
import java.util.Optional;

public interface FareService {
    Optional<FareModel> getFareByProductAndBrand(FareModel fareModel);

    Optional<FareModel> getFareById(Long any);

    List<FareModel> getAll();
}
