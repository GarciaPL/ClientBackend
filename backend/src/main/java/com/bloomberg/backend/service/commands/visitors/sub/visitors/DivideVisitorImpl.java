package com.bloomberg.backend.service.commands.visitors.sub.visitors;

import com.bloomberg.backend.service.commands.AddDoubleCommand;
import com.bloomberg.backend.service.commands.AddIntegerCommand;
import com.bloomberg.backend.service.commands.AddLongCommand;

public class DivideVisitorImpl<E extends Number> implements DivideVisitor<Number> {

    @Override
    public Number execute(AddIntegerCommand addIntegerCommand) {
        return null;
    }

    @Override
    public Number execute(AddLongCommand addLongCommand) {
        return null;
    }

    @Override
    public Number execute(AddDoubleCommand addDoubleCommand) {
        return null;
    }
}
