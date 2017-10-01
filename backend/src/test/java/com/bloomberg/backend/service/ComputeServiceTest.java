package com.bloomberg.backend.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import com.bloomberg.backend.model.Operation;
import com.bloomberg.backend.model.Request;
import com.bloomberg.backend.service.exceptions.ComputeException;
import org.junit.Before;
import org.junit.Test;

public class ComputeServiceTest {

    private ComputeService computeService;

    @Before
    public void setUp() throws Exception {
        computeService = new ComputeService();
    }

    @Test
    public void testAddComputeInteger() throws Exception {
        Request request = new Request();
        request.setFirstOperand(1);
        request.setSecondOperand(2);
        request.setOperation(Operation.ADD);

        Number result = computeService.compute(request);
        assertThat(result, is(notNullValue()));
        assertThat(result, is(equalTo(3)));
    }

    @Test
    public void testAddComputeLong() throws Exception {
        Request request = new Request();
        request.setFirstOperand(1L);
        request.setSecondOperand(2L);
        request.setOperation(Operation.ADD);

        Number result = computeService.compute(request);
        assertThat(result, is(notNullValue()));
        assertThat(result, is(equalTo(3L)));
    }

    @Test
    public void testAddComputeDouble() throws Exception {
        Request request = new Request();
        request.setFirstOperand(1.0);
        request.setSecondOperand(2.0);
        request.setOperation(Operation.ADD);

        Number result = computeService.compute(request);
        assertThat(result, is(notNullValue()));
        assertThat(result, is(equalTo(3.0)));
    }

    @Test
    public void testSubtractComputeInteger() throws Exception {
        Request request = new Request();
        request.setFirstOperand(10);
        request.setSecondOperand(5);
        request.setOperation(Operation.SUBTRACT);

        Number result = computeService.compute(request);
        assertThat(result, is(notNullValue()));
        assertThat(result, is(equalTo(5)));
    }

    @Test
    public void testSubtractComputeLong() throws Exception {
        Request request = new Request();
        request.setFirstOperand(10L);
        request.setSecondOperand(5L);
        request.setOperation(Operation.SUBTRACT);

        Number result = computeService.compute(request);
        assertThat(result, is(notNullValue()));
        assertThat(result, is(equalTo(5L)));
    }

    @Test
    public void testSubtractComputeDouble() throws Exception {
        Request request = new Request();
        request.setFirstOperand(10.0);
        request.setSecondOperand(5.0);
        request.setOperation(Operation.SUBTRACT);

        Number result = computeService.compute(request);
        assertThat(result, is(notNullValue()));
        assertThat(result, is(equalTo(5.0)));
    }

    @Test
    public void testMultiplyComputeInteger() throws Exception {
        Request request = new Request();
        request.setFirstOperand(10);
        request.setSecondOperand(5);
        request.setOperation(Operation.MULTIPLY);

        Number result = computeService.compute(request);
        assertThat(result, is(notNullValue()));
        assertThat(result, is(equalTo(50)));
    }

    @Test
    public void testMultiplyComputeLong() throws Exception {
        Request request = new Request();
        request.setFirstOperand(10L);
        request.setSecondOperand(5L);
        request.setOperation(Operation.MULTIPLY);

        Number result = computeService.compute(request);
        assertThat(result, is(notNullValue()));
        assertThat(result, is(equalTo(50L)));
    }

    @Test
    public void testMultiplyComputeDouble() throws Exception {
        Request request = new Request();
        request.setFirstOperand(10.0);
        request.setSecondOperand(5.0);
        request.setOperation(Operation.MULTIPLY);

        Number result = computeService.compute(request);
        assertThat(result, is(notNullValue()));
        assertThat(result, is(equalTo(50.0)));
    }


    @Test
    public void testDivideComputeInteger() throws Exception {
        Request request = new Request();
        request.setFirstOperand(10);
        request.setSecondOperand(5);
        request.setOperation(Operation.DIVIDE);

        Number result = computeService.compute(request);
        assertThat(result, is(notNullValue()));
        assertThat(result, is(equalTo(2)));
    }

    @Test
    public void testDivideComputeLong() throws Exception {
        Request request = new Request();
        request.setFirstOperand(10L);
        request.setSecondOperand(5L);
        request.setOperation(Operation.DIVIDE);

        Number result = computeService.compute(request);
        assertThat(result, is(notNullValue()));
        assertThat(result, is(equalTo(2L)));
    }

    @Test
    public void testDivideComputeDouble() throws Exception {
        Request request = new Request();
        request.setFirstOperand(10.0);
        request.setSecondOperand(5.0);
        request.setOperation(Operation.DIVIDE);

        Number result = computeService.compute(request);
        assertThat(result, is(notNullValue()));
        assertThat(result, is(equalTo(2.0)));
    }

    @Test(expected = ComputeException.class)
    public void testDivideComputeException() throws Exception {
        Request request = new Request();
        request.setFirstOperand(10);
        request.setSecondOperand(0);
        request.setOperation(Operation.DIVIDE);

        computeService.compute(request);
    }
}