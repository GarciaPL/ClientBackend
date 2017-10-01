package com.bloomberg.backend.service.commands.base;

public interface Command<E extends Number> {

    E execute(E firstOperand, E secondOperand);

}
