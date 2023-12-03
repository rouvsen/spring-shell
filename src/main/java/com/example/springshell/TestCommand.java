package com.example.springshell;

import org.springframework.shell.command.annotation.Command;

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
}

// >> 7.50 minute <<
