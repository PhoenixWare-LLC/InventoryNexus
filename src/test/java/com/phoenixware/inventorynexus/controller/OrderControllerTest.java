package com.phoenixware.inventorynexus.controller;

import com.phoenixware.inventorynexus.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class OrderControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    OrderService orderService;

    @Test
    void getOrderByID() throws Exception {
        mockMvc.perform(get("/orders/3e2c7e16-7f39-4165-9bae-c88a9abadf7b")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
