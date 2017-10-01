package com.bloomberg.backend.api;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.bloomberg.backend.model.Operation;
import com.bloomberg.backend.model.Request;
import com.bloomberg.backend.service.ComputeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(Api.class)
public class ApiTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ComputeService computeService;

    @Test
    public void testRequest() throws Exception {
        when(computeService.compute(any(Request.class))).thenReturn(10);
        String requestJson = objectMapper.writeValueAsString(new Request(1, 2, Operation.ADD));

        this.mvc.perform(post("/compute").contentType(MediaType.APPLICATION_JSON).content(requestJson)).andExpect(status().isOk())
                .andExpect(content().json("{\"result\":10}"));
    }

}