package com.example.springshell;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.Option;

@Command(group = "Test Commands")
public class TestCommand {

    @Command(command = "hi", description = "This command will print 'Hello, World!'")
    void hello() { //this is the best choice (with void, and println)
        System.out.println("Hello, World!");
    }

    @Command(command = "hi2", description = "This command will print 'Hello, World! - 2'")
    String hello2() { //also you can return String
        return "Hello, World! - 2";
    }

    @Command(command = "hi3", description = "This command will print 'Hello, World!'")
    void hello3(
            @NotBlank
            @Size(min = 3, max = 7)
            @Option(shortNames = 'n', longNames = "name", description = "input name") String name
            ) {
        System.out.printf("Hello, World! (3) %s%n", name);
    }

    @Command(command = "hi4", description = "This command will print 'Hello, World!'")
    void hello4(
            @NotBlank
            @Size(min = 3, max = 7)
            @Option(shortNames = 'n', longNames = "name", description = "input name") String name,
            @NotBlank
            @Size(min = 3, max = 7)
            @Option(shortNames = 'n', longNames = "name", description = "input name") String surname
    ) {
        System.out.printf("Hello, World! (3) %s %s %n", name, surname);
    }
}

