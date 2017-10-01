package com.bloomberg.backend.service.commands.visitors.sub.visitors.temp;

import com.bloomberg.backend.service.commands.AddIntegerCommand;
import com.bloomberg.backend.service.commands.AddLongCommand;
import com.bloomberg.backend.service.commands.DivideIntegerCommand;
import com.bloomberg.backend.service.commands.MultiplyIntegerCommand;
import com.bloomberg.backend.service.commands.SubtractIntegerCommand;

public interface Visitor<E extends Number> {

    E execute(AddIntegerCommand addIntegerCommand);

    E execute(AddLongCommand addCommand);

    E execute(DivideIntegerCommand divideIntegerCommand);

    E execute(MultiplyIntegerCommand multiplyIntegerCommand);

    E execute(SubtractIntegerCommand subtractIntegerCommand);

}
