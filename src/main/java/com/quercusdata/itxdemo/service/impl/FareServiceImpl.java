package com.quercusdata.itxdemo.service.impl;

import com.quercusdata.itxdemo.entity.Fare;
import com.quercusdata.itxdemo.mapper.FareMapper;
import com.quercusdata.itxdemo.model.FareModel;
import com.quercusdata.itxdemo.repository.FareRepository;
import com.quercusdata.itxdemo.service.FareService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FareServiceImpl implements FareService {
    private static final Logger log = LoggerFactory.getLogger(FareServiceImpl.class);

    @Autowired
    private FareRepository  fareRepository;

    @Autowired
    private FareMapper      fareMapper;


    public Optional<FareModel> getFareByProductAndBrand(FareModel fareModel) {
        log.debug("Entering with fareModel {}", fareModel);
        Optional<Fare> fareOpt = fareRepository.findFirstByStartDateBeforeAndEndDateAfterAndProductIdAndBrandIdOrderByPriorityDesc(
            fareModel.getStartDate(), fareModel.getStartDate(), fareModel.getProductId(), fareModel.getBrandId());
        if (fareOpt.isEmpty()) {
            return Optional.empty();
        }
        log.debug("Leaving. Found {}", fareOpt.get());
        return Optional.of(fareMapper.mapPersistenceToApi( fareOpt.get()));
    }

    @Override
    public Optional<FareModel> getFareById(Long id) {
        log.debug("Entering with id {}", id);
        Optional<Fare> fareOpt = fareRepository.findById(id);
        if (fareOpt.isEmpty()) {
            return Optional.empty();
        }
        log.debug("Leaving. Found {}", fareOpt.get());
        return Optional.of(fareMapper.mapPersistenceToApi( fareOpt.get()));
    }

    @Override
    public List<FareModel> getAll() {
        log.info("Entering");
        List<FareModel> fareModels = fareRepository.findAll().stream()
            .map(f -> fareMapper.mapPersistenceToApi(f))
            .collect(Collectors.toList());
        log.info("Found {} fareModels", fareModels.size());
        return fareModels;
    }
}
