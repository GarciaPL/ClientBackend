package com.bloomberg.client.model;

import com.google.common.base.MoreObjects;

public class Request {

    private Number firstOperand;
    private Number secondOperand;
    private Operation operation;

    public Request() {
    }

    public Request(Number firstOperand, Number secondOperand, Operation operation) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.operation = operation;
    }

    public Number getFirstOperand() {
        return firstOperand;
    }

    public void setFirstOperand(Number firstOperand) {
        this.firstOperand = firstOperand;
    }

    public Number getSecondOperand() {
        return secondOperand;
    }

    public void setSecondOperand(Number secondOperand) {
        this.secondOperand = secondOperand;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("firstOperand", firstOperand)
                .add("secondOperand", secondOperand)
                .add("operation", operation)
                .toString();
    }
}
