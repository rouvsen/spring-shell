package com.example.springshell;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.shell.command.annotation.Command;

@RequiredArgsConstructor
@Command(group = "Auth Commands")
public class AuthCommand {

    private final AuthenticationManager authenticationManager;
    private final ShellPrinter printer;
    private final ShellReader reader;

    @Command(command = "login", description = "for login to system")
    void login() {
        String username = reader.readLine("username");
        String password = reader.readLine("password");
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        printer.printSuccess("Successfully logged in!");
    }

    @Command(command = "logout", description = "for logout from system")
    void logout() {
        SecurityContextHolder.clearContext();
        printer.printSuccess("Successfully logged out!");
    }

}
