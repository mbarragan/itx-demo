package com.quercusdata.itxdemo.repository;

import com.quercusdata.itxdemo.entity.Fare;
import com.quercusdata.itxdemo.util.Constants;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class FareRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager   entityManager;

    @Autowired
    private FareRepository      fareRepository;

    @Test
    public void whenFindFirstByStartDateBeforeAndEndDateAfterAndProductIdAndBrandIdOrderByPriorityDesc_thenReturnFare() {
        // given
        Fare fareMock = new Fare(null, Constants.PRODUCT_ID_MOCK, Constants.FARE_START_DATETIME_MOCK,
            Constants.FARE_END_DATETIME_MOCK, Constants.BRAND_ID_MOCK, Constants.FARE_AMOUNT_MOCK,
            Constants.FARE_PRIORITY_MOCK, Constants.FARE_CURRENCY_MOCK);

        entityManager.persist(fareMock);
        entityManager.flush();

        // when
        Optional<Fare> fareFound =
            fareRepository.findFirstByStartDateBeforeAndEndDateAfterAndProductIdAndBrandIdOrderByPriorityDesc(
            Constants.FARE_DATETIME_MOCK_2, Constants.FARE_DATETIME_MOCK_2, Constants.PRODUCT_ID_MOCK, Constants.BRAND_ID_MOCK);

        // then
        Assert.assertTrue("fareFound isPresent", fareFound.isPresent());
        Assert.assertEquals(fareFound.get().getProductId(), fareMock.getProductId());
        Assert.assertEquals(fareFound.get().getBrandId(), fareMock.getBrandId());
        Assert.assertEquals(Constants.FARE_ID_MOCK_2, fareFound.get().getId());
        Assert.assertEquals(Constants.FARE_START_DATETIME_MOCK, fareFound.get().getStartDate());
        Assert.assertEquals(Constants.FARE_END_DATETIME_MOCK, fareFound.get().getEndDate());
        Assert.assertEquals(Constants.FARE_AMOUNT_MOCK, fareFound.get().getPrice());
        Assert.assertEquals(Constants.FARE_CURRENCY_MOCK, fareFound.get().getCurrency());
        Assert.assertEquals(Constants.FARE_PRIORITY_MOCK, fareFound.get().getPriority());
    }

    @Test
    public void whenFindById_thenReturnFare() {
        // given
        Fare fareMock = new Fare(2L, Constants.PRODUCT_ID_MOCK, Constants.FARE_START_DATETIME_MOCK,
            Constants.FARE_END_DATETIME_MOCK, Constants.BRAND_ID_MOCK, Constants.FARE_AMOUNT_MOCK,
            Constants.FARE_PRIORITY_MOCK, Constants.FARE_CURRENCY_MOCK);

        // when
        Optional<Fare> fareFound = fareRepository.findById(2L);

        // then
        Assert.assertTrue("fareFound isPresent", fareFound.isPresent());
        Assert.assertEquals(fareFound.get().getId(), fareMock.getId());
        Assert.assertEquals(fareFound.get().getProductId(), fareMock.getProductId());
        Assert.assertEquals(fareFound.get().getBrandId(), fareMock.getBrandId());
        Assert.assertEquals(Constants.FARE_START_DATETIME_MOCK, fareFound.get().getStartDate());
        Assert.assertEquals(Constants.FARE_END_DATETIME_MOCK, fareFound.get().getEndDate());
        Assert.assertEquals(Constants.FARE_AMOUNT_MOCK, fareFound.get().getPrice());
        Assert.assertEquals(Constants.FARE_CURRENCY_MOCK, fareFound.get().getCurrency());
        Assert.assertEquals(Constants.FARE_PRIORITY_MOCK, fareFound.get().getPriority());
    }
}
