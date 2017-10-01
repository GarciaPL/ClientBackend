package com.bloomberg.backend.service.commands.visitors.sub.visitors;

import com.bloomberg.backend.service.commands.AddIntegerCommand;
import com.bloomberg.backend.service.commands.AddLongCommand;

public class MultiplyVisitorImpl<E extends Number> implements MultiplyVisitor<Number> {

    @Override
    public Number execute(AddIntegerCommand addIntegerCommand) {
        return null;
    }

    @Override
    public Number execute(AddLongCommand addCommand) {
        return null;
    }
}
