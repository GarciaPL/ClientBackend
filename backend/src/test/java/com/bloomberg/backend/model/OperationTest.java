package com.bloomberg.backend.model;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class OperationTest {

    @Test
    public void testEnum() throws Exception {
        assertThat(Operation.values().length, is(equalTo(4)));
    }
}