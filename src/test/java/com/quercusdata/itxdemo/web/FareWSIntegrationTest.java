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

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
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
        Mockito.when(fareService.getFareByProductAndBrand(ArgumentMatchers.any(FareModel.class))).thenReturn(Optional.of(fareModelMock));

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

        FareModel fareModelMock = Util.getFareModelMock();
        Mockito.when(fareService.getFareByProductAndBrand(ArgumentMatchers.any(FareModel.class))).thenReturn(Optional.empty());

        mvc.perform(post("/fare").contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(fareModelMock)))
            .andExpect(status().isNotFound());

    }

    @Test
    public void getFareByIdTest_return_notFound() throws Exception {

        FareModel fareModelMock = Util.getFareModelMock();
        Mockito.when(fareService.getFareById(ArgumentMatchers.any(Long.class))).thenReturn(Optional.empty());

        mvc.perform(get("/fare/1001").contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(fareModelMock)))
            .andExpect(status().isNotFound());
    }

    @Test
    public void getFareByIdTest_return_found() throws Exception {

        FareModel fareModelMock = Util.getFareModelMock();
        Mockito.when(fareService.getFareById(ArgumentMatchers.any(Long.class))).thenReturn(Optional.of(fareModelMock));

        mvc.perform(get("/fare/1").contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(fareModelMock)))
            .andExpect(status().isOk());
    }

    @Test
    public void getAllTest_return_emptyList() throws Exception {

        //FareModel fareModelMock = Util.getFareModelMock();
        List<FareModel> emptyList = Collections.emptyList();
        Mockito.when(fareService.getAll()).thenReturn(emptyList);

        mvc.perform(get("/fare").contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(emptyList)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", notNullValue()))
            .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void getAllTest_return_fullList() throws Exception {

        List<FareModel> fareModels = Collections.singletonList(Util.getFareModelMock());
        Mockito.when(fareService.getAll()).thenReturn(fareModels);

        mvc.perform(get("/fare").contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(fareModels)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", notNullValue()))
            .andExpect(jsonPath("$", hasSize(1)))
            .andExpect(jsonPath("$[0].productId", equalTo(Constants.PRODUCT_ID_MOCK)));
    }
}
