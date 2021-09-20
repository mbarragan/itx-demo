package com.quercusdata.itxdemo.service;

import com.quercusdata.itxdemo.model.FareModel;
import java.util.Optional;

public interface FareService {
    Optional<FareModel> getFare(FareModel fareModel);
}
