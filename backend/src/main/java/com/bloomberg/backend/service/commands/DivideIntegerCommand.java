package com.bloomberg.backend.service.commands;

import com.bloomberg.backend.service.commands.base.Command;

public class DivideIntegerCommand implements Command<Integer> {

    @Override
    public Integer execute(Integer firstOperand, Integer secondOperand) {
        return firstOperand / secondOperand;
    }

}
