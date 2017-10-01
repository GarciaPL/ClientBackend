package com.bloomberg.backend.service.commands.visitors.sub.visitors;

import com.bloomberg.backend.service.commands.AddIntegerCommand;
import com.bloomberg.backend.service.commands.AddLongCommand;
import com.bloomberg.backend.service.commands.visitors.sub.visitors.base.BaseVisitor;

public interface MultiplyVisitor<E extends Number> extends BaseVisitor {

    E execute(AddIntegerCommand addIntegerCommand);

    E execute(AddLongCommand addCommand);

}
