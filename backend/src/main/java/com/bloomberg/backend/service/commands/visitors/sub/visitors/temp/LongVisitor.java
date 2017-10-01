package com.bloomberg.backend.service.commands.visitors.sub.visitors.temp;

import com.bloomberg.backend.service.commands.AddIntegerCommand;
import com.bloomberg.backend.service.commands.AddLongCommand;
import com.bloomberg.backend.service.commands.DivideIntegerCommand;
import com.bloomberg.backend.service.commands.MultiplyIntegerCommand;
import com.bloomberg.backend.service.commands.SubtractIntegerCommand;

public class LongVisitor implements Visitor<Long> {

    private Long firstOperand;
    private Long secondOperand;

    public LongVisitor(Number firstOperand, Number secondOperand) {
        this.firstOperand = firstOperand.longValue();
        this.secondOperand = secondOperand.longValue();
    }

    @Override
    public Long execute(AddIntegerCommand addIntegerCommand) {
        return null;
    }

    @Override
    public Long execute(AddLongCommand addCommand) {
        return addCommand.execute(firstOperand, secondOperand);
    }

    @Override
    public Long execute(DivideIntegerCommand divideIntegerCommand) {
        return null;
    }

    @Override
    public Long execute(MultiplyIntegerCommand multiplyIntegerCommand) {
        return null;
    }

    @Override
    public Long execute(SubtractIntegerCommand subtractIntegerCommand) {
        return null;
    }
}
