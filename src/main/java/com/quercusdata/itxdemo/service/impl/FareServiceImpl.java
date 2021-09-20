package com.quercusdata.itxdemo.service.impl;

import com.quercusdata.itxdemo.entity.Fare;
import com.quercusdata.itxdemo.mapper.FareMapper;
import com.quercusdata.itxdemo.model.FareModel;
import com.quercusdata.itxdemo.repository.FareRepository;
import com.quercusdata.itxdemo.service.FareService;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FareServiceImpl implements FareService {
    private static final Logger log = LoggerFactory.getLogger(FareServiceImpl.class);

    @Autowired
    private FareRepository  fareRepository;

    @Autowired
    private FareMapper      fareMapper;


    public FareServiceImpl() {
    }

    @Transactional
    public Optional<FareModel> getFare(FareModel fareModel) {
        log.debug("Entering with fareModel {}", fareModel);
        Optional<Fare> fareOpt = fareRepository.findFirstByStartDateBeforeAndEndDateAfterAndProductIdAndBrandIdOrderByPriorityDesc(
            fareModel.getStartDate(), fareModel.getStartDate(), fareModel.getProductId(), fareModel.getBrandId());
        if (!fareOpt.isPresent()) {
            return Optional.empty();
        }
        log.debug("Leaving");
        return Optional.of(fareMapper.mapPersistenceToApi( fareOpt.get()));
    }
}