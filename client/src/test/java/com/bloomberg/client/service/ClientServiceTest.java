package com.bloomberg.client.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import com.bloomberg.client.model.Operation;
import com.bloomberg.client.model.Request;
import com.bloomberg.client.model.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientServiceTest {

    private ClientService clientService;

    @MockBean
    private BackendClient backendClient;

    @Before
    public void setUp() throws Exception {
        clientService = new ClientService(backendClient);
    }

    @Test
    public void testMakeRequest() throws Exception {
        Request request = new Request();
        request.setFirstOperand(1);
        request.setSecondOperand(2);
        request.setOperation(Operation.ADD);

        Response backendResponse = new Response();
        backendResponse.setResult(3);
        when(backendClient.compute(any(Request.class))).thenReturn(backendResponse);

        Response response = clientService.makeRequest(request);
        assertThat(response, is(notNullValue()));
        assertThat(response.getResult(), is(equalTo(3)));
        assertThat(response.getMessage(), is(nullValue()));
    }

}