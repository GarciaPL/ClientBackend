package com.bloomberg.backend.service.commands.visitors.sub.visitors;

import com.bloomberg.backend.service.commands.AddDoubleCommand;
import com.bloomberg.backend.service.commands.AddIntegerCommand;
import com.bloomberg.backend.service.commands.AddLongCommand;

public class AddVisitorImpl<E extends Number> implements AddVisitor<Number> {

    @Override
    public Integer execute(AddIntegerCommand addIntegerCommand) {
        return null;
    }

    @Override
    public Long execute(AddLongCommand addLongCommand) {
        return null;
    }

    @Override
    public Number execute(AddDoubleCommand addDoubleCommand) {
        return null;
    }
}
