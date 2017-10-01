package com.bloomberg.client.api;

import com.bloomberg.client.model.Request;
import com.bloomberg.client.model.Response;
import com.bloomberg.client.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Api {

    private Logger LOGGER = LoggerFactory.getLogger(Api.class.getName());

    @Autowired
    private ClientService clientService;

    @PostMapping(value = "/process")
    public Response processRequest(@RequestBody Request request) {
        LOGGER.info("Processing client request");
        return clientService.makeRequest(request);
    }

}
