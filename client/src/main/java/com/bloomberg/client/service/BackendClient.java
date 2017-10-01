package com.bloomberg.client.service;

import com.bloomberg.client.model.Request;
import com.bloomberg.client.model.Response;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "backend", path = "/backend")
public interface BackendClient {

    @RequestMapping(value = "/compute", method = RequestMethod.POST)
    Response compute(@RequestBody Request request);

}
