package com.quercusdata.itxdemo.web;

import com.quercusdata.itxdemo.constant.Constants;
import com.quercusdata.itxdemo.model.FareModel;
import com.quercusdata.itxdemo.service.FareService;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class FareWS {
    private static final Logger log = LoggerFactory.getLogger(FareWS.class);

    @Autowired
    private FareService     fareService;

    @PostMapping(
        value = {"/fare"},
        produces = {"application/json"},
        consumes = {"application/json"})
    public ResponseEntity<FareModel> getFare(@RequestBody FareModel fareModel) {
        log.debug("Entering with fareModel {}", fareModel);
        Optional<FareModel> filteredFareModelOpt = fareService.getFare(fareModel);
        if (!filteredFareModelOpt.isPresent()) {
            log.debug(Constants.MESSAGE_FARE_NOT_FOUND);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, Constants.MESSAGE_FARE_NOT_FOUND);
        } else {
            log.debug("Leaving");
            return new ResponseEntity<>(filteredFareModelOpt.get(), HttpStatus.OK);
        }
    }
}