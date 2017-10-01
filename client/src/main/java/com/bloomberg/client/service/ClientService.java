package com.bloomberg.client.service;

import com.bloomberg.client.model.Request;
import com.bloomberg.client.model.Response;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private BackendClient backendClient;

    @Autowired
    public ClientService(BackendClient backendClient) {
        this.backendClient = backendClient;
    }

    @HystrixCommand(fallbackMethod = "fallback")
    public Response makeRequest(Request request) {
        LOGGER.info("ClientService - incoming request {}", request);

        Response compute = backendClient.compute(request);
        LOGGER.info("Compute result {}", compute);

        Response response = new Response();
        response.setResult(compute.getResult());
        return response;
    }

    public Response fallback(Request request) {
        Response response = new Response();
        String failMessage = "Backend service not available. Please try later.";
        response.setMessage(failMessage);
        LOGGER.error(failMessage);
        return response;
    }

}
