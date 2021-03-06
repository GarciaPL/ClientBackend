package com.bloomberg.backend.service.commands;

import com.bloomberg.backend.service.commands.base.Command;

public class DivideLongCommand implements Command<Long> {

    @Override
    public Long execute(Long firstOperand, Long secondOperand) {
        return firstOperand / secondOperand;
    }

}
