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
import org.mockito.ArgumentMatchers;
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

    private Fare fareMock;

    @Before
    public void setUp() {
        fareMock = new Fare(null, Constants.PRODUCT_ID_MOCK, Constants.FARE_START_DATETIME_MOCK,
            Constants.FARE_END_DATETIME_MOCK, Constants.BRAND_ID_MOCK, Constants.FARE_AMOUNT_MOCK,
            Constants.FARE_PRIORITY_MOCK, Constants.FARE_CURRENCY_MOCK);

        fareModelMock = new FareModel(null, Constants.PRODUCT_ID_MOCK,
            Constants.FARE_DATETIME_MOCK_2, null, Constants.BRAND_ID_MOCK, null);

        Mockito.when(fareMapper.mapPersistenceToApi(  ArgumentMatchers.any(Fare.class))).thenReturn( fareModelMock);
    }

    @Test
    public void whenValidFare_thenFareShouldBeFound() {
        Mockito.when(fareRepository.findFirstByStartDateBeforeAndEndDateAfterAndProductIdAndBrandIdOrderByPriorityDesc(
                Constants.FARE_DATETIME_MOCK_2, Constants.FARE_DATETIME_MOCK_2, Constants.PRODUCT_ID_MOCK,
                Constants.BRAND_ID_MOCK))
            .thenReturn(Optional.of( fareMock));

        Optional<FareModel> foundFareOpt = fareService.getFare(fareModelMock);

        Assert.assertTrue("foundFareOpt is present", foundFareOpt.isPresent());
        Assert.assertEquals(Constants.PRODUCT_ID_MOCK, foundFareOpt.get().getProductId());
        Assert.assertEquals(Constants.BRAND_ID_MOCK, foundFareOpt.get().getBrandId());
        Assert.assertEquals(Constants.FARE_DATETIME_MOCK_2, foundFareOpt.get().getStartDate());
    }

    @Test
    public void whenInvalidFare_thenFareShouldNotBeFound() {
        Mockito.when(fareRepository.findFirstByStartDateBeforeAndEndDateAfterAndProductIdAndBrandIdOrderByPriorityDesc(
            Mockito.any(), Mockito.any(), Mockito.anyInt(), Mockito.anyInt())).thenReturn(Optional.empty());

        Optional<FareModel> foundFareOpt = fareService.getFare(fareModelMock);

        Assert.assertFalse("foundFareOpt is not present", foundFareOpt.isPresent());
        Assert.assertEquals(Optional.empty(), foundFareOpt);
    }
}
