package com.bloomberg.backend.service.commands;

import com.bloomberg.backend.service.commands.base.Command;

public class AddDoubleCommand implements Command<Double> {

    @Override
    public Double execute(Double firstOperand, Double secondOperand) {
        return firstOperand + secondOperand;
    }

}
