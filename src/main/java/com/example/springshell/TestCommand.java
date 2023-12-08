package com.example.springshell;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.CommandAvailability;
import org.springframework.shell.command.annotation.Option;

@RequiredArgsConstructor
@Command(group = "Test Commands")
public class TestCommand {

    private final ShellPrinter printer;
    private final ShellReader reader;

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
            @Option(shortNames = 's', longNames = "surname", description = "input surname") String surname
    ) {
        System.out.printf("Hello, World! (3) %s %s %n", name, surname);
    }

    @Command(command = "hi5", description = "This command will print 'Hello, World!' and entered values")
    void hello5(
            @NotBlank
            @Size(min = 3, max = 7)
            @Option(shortNames = 'n', longNames = "name", description = "input name") String name,
            @NotBlank
            @Size(min = 3, max = 7)
            @Option(shortNames = 's', longNames = "surname", description = "input surname") String surname
    ) {
        AnsiConsole.systemInstall();
        System.out.print
                (
                        Ansi.ansi()
                                .fg(Ansi.Color.RED)
                                .bg(Ansi.Color.WHITE)
                                .a("Hello, World! (3) %s %s %n".formatted(name, surname))
                                .reset()
                );
        AnsiConsole.systemUninstall();
    }

    @Command(command = "hi6", description = "This command will print 'Hello, World!' and entered values")
    void hello6(
            @NotBlank
            @Size(min = 3, max = 7)
            @Option(shortNames = 'n', longNames = "name", description = "input name") String name,
            @NotBlank
            @Size(min = 3, max = 7)
            @Option(shortNames = 's', longNames = "surname", description = "input surname") String surname
    ) {
        printer.printSuccess("%s %s".formatted(name, surname));
        printer.printError("Error message !");
    }

    @CommandAvailability(provider = {"userLoggedInProvider"})
    @Command(command = "inputs", description = "This command will get inputs from console")
    void inputs() {
        String name = reader.readLine("Your name");
        String surname = reader.readLine("Your surname");
        String password = reader.readLinePassword("Your password");
        printer.print(name + " " + surname + " " + password);
    }

}


