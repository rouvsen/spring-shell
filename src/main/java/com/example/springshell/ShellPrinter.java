package com.example.springshell;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;
import org.springframework.stereotype.Component;

@Component
public class ShellPrinter {

    void print(String message) {
        System.out.println(message);
    }

    void print(String message, Ansi.Color front, Ansi.Color back) {
        AnsiConsole.systemInstall();
        System.out.println(
                Ansi.ansi()
                        .fg(front)
                        .bg(back)
                        .a(message)
                        .reset()
        );
        AnsiConsole.systemUninstall();
    }

    void printSuccess(String message) {
        print(message, Ansi.Color.WHITE, Ansi.Color.GREEN);
    }

    void printError(String message) {
        print(message, Ansi.Color.WHITE, Ansi.Color.RED);
    }
}
