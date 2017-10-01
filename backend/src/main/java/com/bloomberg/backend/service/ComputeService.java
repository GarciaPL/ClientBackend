package com.bloomberg.backend.service;

import static com.nurkiewicz.typeof.TypeOf.whenTypeOf;

import com.bloomberg.backend.model.Operation;
import com.bloomberg.backend.model.Request;
import com.bloomberg.backend.service.commands.AddDoubleCommand;
import com.bloomberg.backend.service.commands.AddIntegerCommand;
import com.bloomberg.backend.service.commands.AddLongCommand;
import com.bloomberg.backend.service.commands.DivideDoubleCommand;
import com.bloomberg.backend.service.commands.DivideIntegerCommand;
import com.bloomberg.backend.service.commands.DivideLongCommand;
import com.bloomberg.backend.service.commands.MultiplyDoubleCommand;
import com.bloomberg.backend.service.commands.MultiplyIntegerCommand;
import com.bloomberg.backend.service.commands.MultiplyLongCommand;
import com.bloomberg.backend.service.commands.SubtractDoubleCommand;
import com.bloomberg.backend.service.commands.SubtractIntegerCommand;
import com.bloomberg.backend.service.commands.SubtractLongCommand;
import com.bloomberg.backend.service.commands.visitors.sub.visitors.AddVisitor;
import com.bloomberg.backend.service.commands.visitors.sub.visitors.AddVisitorImpl;
import com.bloomberg.backend.service.commands.visitors.sub.visitors.DivideVisitor;
import com.bloomberg.backend.service.commands.visitors.sub.visitors.DivideVisitorImpl;
import com.bloomberg.backend.service.commands.visitors.sub.visitors.MultiplyVisitor;
import com.bloomberg.backend.service.commands.visitors.sub.visitors.MultiplyVisitorImpl;
import com.bloomberg.backend.service.commands.visitors.sub.visitors.SubtractVisitor;
import com.bloomberg.backend.service.commands.visitors.sub.visitors.SubtractVisitorImpl;
import com.bloomberg.backend.service.commands.visitors.sub.visitors.base.BaseVisitor;
import com.bloomberg.backend.service.exceptions.ComputeException;
import com.bloomberg.backend.service.exceptions.NotSupportedException;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;
import org.springframework.stereotype.Service;

@Service
public class ComputeService {

    private static final Map<Operation, BaseVisitor> operations = new EnumMap<>(Operation.class);

    public ComputeService() {
        operations.put(Operation.ADD, new AddVisitorImpl());
        operations.put(Operation.SUBTRACT, new SubtractVisitorImpl());
        operations.put(Operation.MULTIPLY, new MultiplyVisitorImpl());
        operations.put(Operation.DIVIDE, new DivideVisitorImpl());
    }

    public Number compute(Request request) {
        BaseVisitor baseVisitor = operations.get(request.getOperation());
        if (baseVisitor != null) {
            try {
                Number result = whenTypeOf(baseVisitor).is(AddVisitor.class).thenReturn(addVisitor -> {
                    Number inside = whenTypeOf(request.getFirstOperand()).is(Integer.class).thenReturn(
                            (Function<Integer, Number>) integer -> {
                                Integer execute = new AddIntegerCommand()
                                        .execute(request.getFirstOperand().intValue(), request.getSecondOperand().intValue());
                                return execute;
                            }).is(Long.class).thenReturn(aLong -> {
                        Long execute = new AddLongCommand()
                                .execute(request.getFirstOperand().longValue(), request.getSecondOperand().longValue());
                        return execute;
                    }).is(Double.class).thenReturn(aLong -> {
                        Double execute = new AddDoubleCommand()
                                .execute(request.getFirstOperand().doubleValue(), request.getSecondOperand().doubleValue());
                        return execute;
                    }).orElse(0);
                    return inside;
                }).is(SubtractVisitor.class).thenReturn(subtractVisitor -> {
                    Number inside = whenTypeOf(request.getFirstOperand()).is(Integer.class).thenReturn(
                            (Function<Integer, Number>) integer -> {
                                Integer execute = new SubtractIntegerCommand()
                                        .execute(request.getFirstOperand().intValue(), request.getSecondOperand().intValue());
                                return execute;
                            }).is(Long.class).thenReturn(aLong -> {
                        Long execute = new SubtractLongCommand()
                                .execute(request.getFirstOperand().longValue(), request.getSecondOperand().longValue());
                        return execute;
                    }).is(Double.class).thenReturn(aLong -> {
                        Double execute = new SubtractDoubleCommand()
                                .execute(request.getFirstOperand().doubleValue(), request.getSecondOperand().doubleValue());
                        return execute;
                    }).orElse(0);
                    return inside;
                }).is(MultiplyVisitor.class).thenReturn(subtractVisitor -> {
                    Number inside = whenTypeOf(request.getFirstOperand()).is(Integer.class).thenReturn(
                            (Function<Integer, Number>) integer -> {
                                Integer execute = new MultiplyIntegerCommand()
                                        .execute(request.getFirstOperand().intValue(), request.getSecondOperand().intValue());
                                return execute;
                            }).is(Long.class).thenReturn(aLong -> {
                        Long execute = new MultiplyLongCommand()
                                .execute(request.getFirstOperand().longValue(), request.getSecondOperand().longValue());
                        return execute;
                    }).is(Double.class).thenReturn(aLong -> {
                        Double execute = new MultiplyDoubleCommand()
                                .execute(request.getFirstOperand().doubleValue(), request.getSecondOperand().doubleValue());
                        return execute;
                    }).orElse(0);
                    return inside;
                }).is(DivideVisitor.class).thenReturn(subtractVisitor -> {
                    Number inside = whenTypeOf(request.getFirstOperand()).is(Integer.class).thenReturn(
                            (Function<Integer, Number>) integer -> {
                                Integer execute = new DivideIntegerCommand()
                                        .execute(request.getFirstOperand().intValue(), request.getSecondOperand().intValue());
                                return execute;
                            }).is(Long.class).thenReturn(aLong -> {
                        Long execute = new DivideLongCommand()
                                .execute(request.getFirstOperand().longValue(), request.getSecondOperand().longValue());
                        return execute;
                    }).is(Double.class).thenReturn(aLong -> {
                        Double execute = new DivideDoubleCommand()
                                .execute(request.getFirstOperand().doubleValue(), request.getSecondOperand().doubleValue());
                        return execute;
                    }).orElse(0);
                    return inside;
                }).orElse(0);
                return result;
            } catch (Exception ex) {
                throw new ComputeException(
                        String.format("Compute exception during running %s operation with operands %s and %s", request.getOperation(),
                                request.getFirstOperand(),
                                request.getSecondOperand()), ex);
            }
        } else {
            throw new NotSupportedException("Not supported operation");
        }
    }
}
