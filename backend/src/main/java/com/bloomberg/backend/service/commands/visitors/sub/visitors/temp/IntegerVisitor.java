package com.bloomberg.backend.service.commands.visitors.sub.visitors.temp;

import com.bloomberg.backend.service.commands.AddIntegerCommand;
import com.bloomberg.backend.service.commands.AddLongCommand;
import com.bloomberg.backend.service.commands.DivideIntegerCommand;
import com.bloomberg.backend.service.commands.MultiplyIntegerCommand;
import com.bloomberg.backend.service.commands.SubtractIntegerCommand;

public class IntegerVisitor implements Visitor<Integer> {

    private Integer firstOperand;
    private Integer secondOperand;

    public IntegerVisitor(Number firstOperand, Number secondOperand) {
        this.firstOperand = firstOperand.intValue();
        this.secondOperand = secondOperand.intValue();
    }

    @Override
    public Integer execute(AddIntegerCommand addIntegerCommand) {
        return addIntegerCommand.execute(firstOperand, secondOperand);
    }

    @Override
    public Integer execute(AddLongCommand addCommand) {
        return null;
    }

    @Override
    public Integer execute(DivideIntegerCommand divideIntegerCommand) {
        return divideIntegerCommand.execute(firstOperand, secondOperand);
    }

    @Override
    public Integer execute(MultiplyIntegerCommand multiplyIntegerCommand) {
        return multiplyIntegerCommand.execute(firstOperand, secondOperand);
    }

    @Override
    public Integer execute(SubtractIntegerCommand subtractIntegerCommand) {
        return subtractIntegerCommand.execute(firstOperand, secondOperand);
    }
}
