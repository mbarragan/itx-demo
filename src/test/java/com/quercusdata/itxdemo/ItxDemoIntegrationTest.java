package com.quercusdata.itxdemo;

import com.quercusdata.itxdemo.entity.Fare;
import com.quercusdata.itxdemo.model.FareModel;
import com.quercusdata.itxdemo.repository.FareRepository;
import com.quercusdata.itxdemo.util.Constants;
import com.quercusdata.itxdemo.util.TestDTOData;
import java.util.Optional;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ItxApplication.class})
public class ItxDemoIntegrationTest {

    @Autowired
    private FareRepository      fareRepository;

    public ItxDemoIntegrationTest() {
    }

    @Test
    public void givenFareRepository_whenRetrieveEntityBy_20210614T1000_thenOK() {
        FareModel fareModel = new FareModel(null, Constants.PRODUCT_ID_MOCK, Constants.FARE_DATETIME_MOCK_1, null,
            Constants.BRAND_ID_MOCK, null);
        Optional<Fare> fareFoundOpt =
            fareRepository.findFirstByStartDateBeforeAndEndDateAfterAndProductIdAndBrandIdOrderByPriorityDesc(
                Constants.FARE_DATETIME_MOCK_1, Constants.FARE_DATETIME_MOCK_1, Constants.PRODUCT_ID_MOCK, Constants.BRAND_ID_MOCK);

        Assert.assertTrue(fareFoundOpt.isPresent());
        Assert.assertEquals((fareFoundOpt.get()).getBrandId(), fareModel.getBrandId());
        Assert.assertEquals((fareFoundOpt.get()).getProductId(), fareModel.getProductId());
        Assert.assertTrue("DateTimeMock is after fare startDate", fareModel.getStartDate().isAfter((fareFoundOpt.get()).getStartDate()));
        Assert.assertTrue("DateTimeMock is before fare endDate", fareModel.getStartDate().isBefore((fareFoundOpt.get()).getEndDate()));
    }

    @Test
    public void givenFareRepository_whenRetrieveEntityBy_20210614T1600_thenOK() {
        FareModel fareModel = new FareModel(null, Constants.PRODUCT_ID_MOCK, Constants.FARE_DATETIME_MOCK_2, null,
            Constants.BRAND_ID_MOCK, null);
        Optional<Fare> fareFoundOpt =
            fareRepository.findFirstByStartDateBeforeAndEndDateAfterAndProductIdAndBrandIdOrderByPriorityDesc(
                Constants.FARE_DATETIME_MOCK_2, Constants.FARE_DATETIME_MOCK_2, Constants.PRODUCT_ID_MOCK,
                Constants.BRAND_ID_MOCK);

        Assert.assertTrue(fareFoundOpt.isPresent());
        Assert.assertEquals((fareFoundOpt.get()).getBrandId(), fareModel.getBrandId());
        Assert.assertEquals((fareFoundOpt.get()).getProductId(), fareModel.getProductId());
        Assert.assertTrue("DateTimeMock is after fare startDate", fareModel.getStartDate().isAfter((fareFoundOpt.get()).getStartDate()));
        Assert.assertTrue("DateTimeMock is before fare endDate", fareModel.getStartDate().isBefore((fareFoundOpt.get()).getEndDate()));
    }

    @Test
    public void givenFareRepository_whenRetrieveEntityBy_20210614T2100_thenOK() {
        FareModel fareModel = new FareModel(null, Constants.PRODUCT_ID_MOCK, Constants.FARE_DATETIME_MOCK_3, null,
            Constants.BRAND_ID_MOCK, null);
        Optional<Fare> fareFoundOpt =
            fareRepository.findFirstByStartDateBeforeAndEndDateAfterAndProductIdAndBrandIdOrderByPriorityDesc(
                Constants.FARE_DATETIME_MOCK_3, Constants.FARE_DATETIME_MOCK_3, Constants.PRODUCT_ID_MOCK,
                Constants.BRAND_ID_MOCK);

        Assert.assertTrue(fareFoundOpt.isPresent());
        Assert.assertEquals((fareFoundOpt.get()).getBrandId(), fareModel.getBrandId());
        Assert.assertEquals((fareFoundOpt.get()).getProductId(), fareModel.getProductId());
        Assert.assertTrue("DateTimeMock is after fare startDate", fareModel.getStartDate().isAfter((fareFoundOpt.get()).getStartDate()));
        Assert.assertTrue("DateTimeMock is before fare endDate", fareModel.getStartDate().isBefore((fareFoundOpt.get()).getEndDate()));
    }

    @Test
    public void givenFareRepository_whenRetrieveEntityBy_20210615T1000_thenOK() {
        FareModel fareModel = new FareModel(null, Constants.PRODUCT_ID_MOCK, Constants.FARE_DATETIME_MOCK_4, null,
            Constants.BRAND_ID_MOCK, null);
        Optional<Fare> fareFoundOpt =
            fareRepository.findFirstByStartDateBeforeAndEndDateAfterAndProductIdAndBrandIdOrderByPriorityDesc(
                Constants.FARE_DATETIME_MOCK_4, Constants.FARE_DATETIME_MOCK_4, Constants.PRODUCT_ID_MOCK,
                Constants.BRAND_ID_MOCK);

        Assert.assertTrue(fareFoundOpt.isPresent());
        Assert.assertEquals((fareFoundOpt.get()).getBrandId(), fareModel.getBrandId());
        Assert.assertEquals((fareFoundOpt.get()).getProductId(), fareModel.getProductId());
        Assert.assertTrue("DateTimeMock is after fare startDate", fareModel.getStartDate().isAfter((fareFoundOpt.get()).getStartDate()));
        Assert.assertTrue("DateTimeMock is before fare endDate", fareModel.getStartDate().isBefore((fareFoundOpt.get()).getEndDate()));
    }

    @Test
    public void givenFareRepository_whenRetrieveEntityBy_20210616T2100_thenOK() {
        FareModel fareModel = new FareModel(null, Constants.PRODUCT_ID_MOCK, Constants.FARE_DATETIME_MOCK_5, null,
            Constants.BRAND_ID_MOCK, null);
        Optional<Fare> fareFoundOpt =
            fareRepository.findFirstByStartDateBeforeAndEndDateAfterAndProductIdAndBrandIdOrderByPriorityDesc(
                Constants.FARE_DATETIME_MOCK_5, Constants.FARE_DATETIME_MOCK_5, Constants.PRODUCT_ID_MOCK,
                Constants.BRAND_ID_MOCK);

        Assert.assertTrue(fareFoundOpt.isPresent());
        Assert.assertEquals((fareFoundOpt.get()).getBrandId(), fareModel.getBrandId());
        Assert.assertEquals((fareFoundOpt.get()).getProductId(), fareModel.getProductId());
        Assert.assertTrue("DateTimeMock is after fare startDate", fareModel.getStartDate().isAfter((fareFoundOpt.get()).getStartDate()));
        Assert.assertTrue("DateTimeMock is before fare endDate", fareModel.getStartDate().isBefore((fareFoundOpt.get()).getEndDate()));
    }
}
