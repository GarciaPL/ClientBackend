package com.bloomberg.client.model;

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
public class RequestTest {

    @Autowired
    private JacksonTester<Request> json;

    @Test
    public void testSerialize() throws Exception {
        Request request = new Request();
        request.setFirstOperand(1);
        request.setSecondOperand(2);
        request.setOperation(Operation.ADD);

        JsonContent<Request> write = this.json.write(request);
        assertThat(write).extractingJsonPathNumberValue("firstOperand").isEqualTo(1);
        assertThat(write).extractingJsonPathNumberValue("secondOperand").isEqualTo(2);
        assertThat(write).extractingJsonPathStringValue("operation").isEqualTo(Operation.ADD.name());
    }

    @Test
    public void testDeserialize() throws Exception {
        String json = "{"
                + "\"firstOperand\" : \"5\","
                + "\"secondOperand\" : \"5\","
                + "\"operation\" : \"ADD\""
                + "}";
        assertThat(this.json.parseObject(json).getFirstOperand()).isEqualTo(5);
        assertThat(this.json.parseObject(json).getSecondOperand()).isEqualTo(5);
        assertThat(this.json.parseObject(json).getOperation()).isEqualTo(Operation.ADD);
    }

}