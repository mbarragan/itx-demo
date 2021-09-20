package com.quercusdata.itxdemo.service.impl;

import com.quercusdata.itxdemo.entity.Fare;
import com.quercusdata.itxdemo.mapper.FareMapper;
import com.quercusdata.itxdemo.model.FareModel;
import com.quercusdata.itxdemo.repository.FareRepository;
import com.quercusdata.itxdemo.service.FareService;
import com.quercusdata.itxdemo.util.Constants;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
public class FareServiceImplIntegrationTest {

    @TestConfiguration
    static class FareServiceImplIntegrationTestContextConfiguration {

        @Bean
        public FareService fareService() {
            return new FareServiceImpl();
        }
    }

    @Autowired
    private FareService     fareService;

    @MockBean
    private FareMapper      fareMapper;

    @MockBean
    private FareRepository  fareRepository;

    private FareModel fareModelMock;

    @Before
    public void setUp() {
        Fare fareMock = new Fare(Constants.FARE_ID_MOCK, Constants.PRODUCT_ID_MOCK, Constants.FARE_START_DATETIME_MOCK,
            Constants.FARE_END_DATETIME_MOCK, Constants.BRAND_ID_MOCK, Constants.FARE_AMOUNT_MOCK,
            Constants.FARE_PRIORITY_MOCK, Constants.FARE_CURRENCY_MOCK);

        fareModelMock = new FareModel(Constants.FARE_ID_MOCK, Constants.PRODUCT_ID_MOCK,
            Constants.FARE_DATETIME_MOCK, null, Constants.BRAND_ID_MOCK, null);

        Mockito.when(fareRepository.findFirstByStartDateBeforeAndEndDateAfterAndProductIdAndBrandIdOrderByPriorityDesc(
            Constants.FARE_DATETIME_MOCK, Constants.FARE_DATETIME_MOCK, Constants.PRODUCT_ID_MOCK, Constants.BRAND_ID_MOCK))
            .thenReturn(Optional.of( fareMock));

        Mockito.when(fareMapper.mapPersistenceToApi( fareMock)).thenReturn( fareModelMock);
    }

    @Test
    public void whenValidFare_thenFareShouldBeFound() {
        Optional<FareModel> foundFareOpt = fareService.getFare(fareModelMock);

        Assert.assertTrue("foundFareOpt is present", foundFareOpt.isPresent());
        Assert.assertEquals(Constants.PRODUCT_ID_MOCK, foundFareOpt.get().getProductId());
        //TODO add more assertEquals
    }
}
