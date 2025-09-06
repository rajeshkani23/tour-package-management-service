package com.Tour.Package.Management;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TourControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetTours_withValidApiKey() throws Exception {
        mockMvc.perform(get("/api/tours")
                        .header("X-API-KEY", "MY_SECRET_KEY_123"))  // 🔑 add your API key here
                .andExpect(status().isOk());
    }

    @Test
    void testGetTours_withoutApiKey() throws Exception {
        mockMvc.perform(get("/api/tours"))
                .andExpect(status().isUnauthorized());
    }
}
