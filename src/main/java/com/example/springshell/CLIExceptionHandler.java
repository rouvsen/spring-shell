package com.example.springshell;

import org.springframework.shell.ParameterValidationException;
import org.springframework.shell.command.CommandExceptionResolver;
import org.springframework.shell.command.CommandHandlingResult;

import java.util.stream.Collectors;

public class CLIExceptionHandler implements CommandExceptionResolver {

    @Override
    public CommandHandlingResult resolve(Exception ex) {
        if (ex instanceof ParameterValidationException)
        {
            return CommandHandlingResult.of(
                    ((ParameterValidationException) ex).getConstraintViolations()
                            .stream().map(
                                    x -> x.getPropertyPath() + " " + x.getMessage()
                            ).collect(Collectors.joining(". "))
                    + "\n"
            );
        }
        return CommandHandlingResult.of(ex.getMessage() + "\n", 1);
    }
}

