package com.bloomberg.backend.api;

import com.bloomberg.backend.model.Request;
import com.bloomberg.backend.model.Response;
import com.bloomberg.backend.service.ComputeService;
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
    private ComputeService computeService;

    @PostMapping(value = "/compute")
    public Response compute(@RequestBody Request request) {
        LOGGER.info("Processing request {}", request);
        return new Response(computeService.compute(request));
    }

}
