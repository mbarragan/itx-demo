package com.quercusdata.itxdemo.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quercusdata.itxdemo.model.FareModel;
import com.quercusdata.itxdemo.service.FareService;
import com.quercusdata.itxdemo.util.Constants;
import com.quercusdata.itxdemo.util.Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(FareWS.class)
public class FareWSIntegrationTest {

    @Autowired
    private MockMvc         mvc;

    @MockBean
    private FareService     fareService;

    @Autowired
    private ObjectMapper    objectMapper;

    @Test
    public void getFareTest_return_OK() throws Exception {

        FareModel fareModelMock = new FareModel(null, Constants.PRODUCT_ID_MOCK,
            Constants.FARE_DATETIME_MOCK_2, null, Constants.BRAND_ID_MOCK, null);
        Mockito.when(fareService.getFare(ArgumentMatchers.any(FareModel.class))).thenReturn(Optional.of(fareModelMock));

        mvc.perform(post("/fare").contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(fareModelMock)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.productId", equalTo(Constants.PRODUCT_ID_MOCK)))
            .andExpect(jsonPath("$.brandId", equalTo(Constants.BRAND_ID_MOCK)))
            .andExpect(jsonPath("$.startDate", equalTo(Util.withSeconds(Constants.FARE_DATETIME_MOCK_2))))
            .andReturn();
    }

    @Test
    public void getFareTest_return_notFound() throws Exception {

        FareModel fareModelMock = new FareModel(null, Constants.PRODUCT_ID_MOCK,
            Constants.FARE_DATETIME_MOCK_2, null, Constants.BRAND_ID_MOCK, null);
        Mockito.when(fareService.getFare(ArgumentMatchers.any(FareModel.class))).thenReturn(Optional.empty());

        mvc.perform(post("/fare").contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(fareModelMock)))
            .andExpect(status().isNotFound());

    }
}
