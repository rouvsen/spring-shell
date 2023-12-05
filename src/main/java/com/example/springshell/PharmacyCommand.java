package com.example.springshell;

import lombok.RequiredArgsConstructor;
import org.fusesource.jansi.Ansi;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.Option;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Command(group = "Pharmacy Commands")
public class PharmacyCommand {

    private final PharmacyFormatter pharmacyFormatter;
    private final PharmacyApiClient pharmacyApiClient;
    private final ShellPrinter shellPrinter;

    @Command(command = "pharmacy")
    void pharmacy(
//            @Option(required = true, shortNames = 'c', longNames = "city", description = "city name") String city,
//            @Option(required = false, shortNames = 'd', longNames = "district", description = "district name") String district
//            @Option(required = true, shortNames = 'i', longNames = "id", description = "Todo id") int id
    ) {
        Arrays.asList(
                        Objects.requireNonNull(pharmacyApiClient.getPharmacies().getBody())
//                                .result()
                )
                .forEach(item -> shellPrinter.print(item.title()));
    }

    @Command(command = "pharmacyTable")
    void pharmacyFormatted(
//            @Option(required = true, shortNames = 'c', longNames = "city", description = "city name") String city,
//            @Option(required = false, shortNames = 'd', longNames = "district", description = "district name") String district
//            @Option(required = true, shortNames = 'i', longNames = "id", description = "Todo id") int id
    ) {
//        var data = Arrays.asList(
//                Objects.requireNonNull(pharmacyApiClient.getPharmacies().getBody())
//                                .result()
//        );
//                .forEach(item -> shellPrinter.print(item.title()));

        var data = Objects.requireNonNull(pharmacyApiClient.getPharmacies().getBody());

        shellPrinter.print(pharmacyFormatter.convertToTable(data), Ansi.Color.WHITE, Ansi.Color.RED);
    }
}
