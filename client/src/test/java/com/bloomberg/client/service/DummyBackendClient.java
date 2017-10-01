package com.bloomberg.client.service;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.bloomberg.client.model.Request;
import com.bloomberg.client.model.Response;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.mockito.stubbing.Answer;

public class DummyBackendClient implements BackendClient {

    private BackendClient backendClient;

    public DummyBackendClient() {
        try {
            backendClient = mock(BackendClient.class);
            when(backendClient.compute(any(Request.class)))
                    .thenThrow(new RuntimeException("Throwing an exception 1"))
                    .thenThrow(new RuntimeException("Throwing an exception 2"))
                    .thenAnswer((Answer<String>) invocationOnMock -> (String) invocationOnMock.getArguments()[0]);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    @HystrixCommand(fallbackMethod = "fallback")
    public Response compute(Request request) {
        return this.backendClient.compute(request);
    }

    public Response fallback(Request request) {
        Response response = new Response();
        String failMessage = "Backend service not available. Please try later.";
        response.setMessage(failMessage);
        return response;
    }
}