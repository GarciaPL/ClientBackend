package com.bloomberg.client.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.bloomberg.client.model.Request;
import com.netflix.hystrix.contrib.javanica.aop.aspectj.HystrixCommandAspect;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientServiceWithHystrix {

    @Autowired
    private BackendClient backendClient;

    @Test
    public void testRemoteCall() throws Exception {
        Request request = new Request();
        assertThat(this.backendClient.compute(request).getMessage(), is("Backend service not available. Please try later."));
        assertThat(this.backendClient.compute(request).getMessage(), is("Backend service not available. Please try later."));
        assertThat(this.backendClient.compute(request).getMessage(), is("Backend service not available. Please try later."));
    }

    @Configuration
    @EnableAspectJAutoProxy
    public static class SpringConfig {

        @Bean
        public HystrixCommandAspect hystrixCommandAspect() {
            return new HystrixCommandAspect();
        }

        @Bean
        public BackendClient remoteCallService() {
            return new DummyBackendClient();
        }
    }

}
