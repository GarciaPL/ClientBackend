package com.bloomberg.backend.service.commands.visitors.sub.visitors;

import com.bloomberg.backend.service.commands.AddIntegerCommand;
import com.bloomberg.backend.service.commands.AddLongCommand;

public class SubtractVisitorImpl<E extends Number> implements SubtractVisitor<Number> {

    @Override
    public Integer execute(AddIntegerCommand addIntegerCommand) {
        return null;
    }

    @Override
    public Long execute(AddLongCommand addCommand) {
        return null;
    }
}
