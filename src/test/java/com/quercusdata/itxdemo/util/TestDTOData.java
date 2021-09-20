package com.quercusdata.itxdemo.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TestDTOData {

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}