package com.quercusdata.itxdemo.web;

import com.quercusdata.itxdemo.ItxApplication;
import com.quercusdata.itxdemo.model.FareModel;
import com.quercusdata.itxdemo.service.FareService;
import com.quercusdata.itxdemo.util.Constants;
import com.quercusdata.itxdemo.util.TestDTOData;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
//@SpringBootTest(
//    webEnvironment = SpringBootTest.WebEnvironment.MOCK,
//    classes = ItxApplication.class
//)
//@AutoConfigureMockMvc
@WebMvcTest(FareWS.class)
public class FareWSIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private FareService fareService;

    @Test
    public void getFareTest() throws Exception {

        FareModel fareModelMock = new FareModel(Constants.FARE_ID_MOCK, Constants.PRODUCT_ID_MOCK,
            Constants.FARE_DATETIME_MOCK, null, Constants.BRAND_ID_MOCK, null);
        Mockito.when(fareService.getFare( fareModelMock)).thenReturn( Optional.of(fareModelMock));

        mvc.perform(post("/fare").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(TestDTOData.asJsonString(fareModelMock)))
                .andExpect(status().isOk())
                .andReturn();
        //.andExpect(jsonPath("$.password", equalTo("123")));
    }

}
