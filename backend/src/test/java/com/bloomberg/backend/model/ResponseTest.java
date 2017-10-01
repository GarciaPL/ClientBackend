package com.bloomberg.backend.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@JsonTest
public class ResponseTest {

    @Autowired
    private JacksonTester<Response> json;

    @Test
    public void testSerialize() throws Exception {
        Response response = new Response(10);

        JsonContent<Response> write = this.json.write(response);
        assertThat(write).extractingJsonPathNumberValue("result").isEqualTo(10);
    }

    @Test
    public void testDeserialize() throws Exception {
        String json = "{\"result\" : \"10\"}";
        assertThat(this.json.parseObject(json).getResult()).isEqualTo(10);
    }

}