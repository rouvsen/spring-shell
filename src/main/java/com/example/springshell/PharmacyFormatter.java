package com.example.springshell;

import org.springframework.shell.table.ArrayTableModel;
import org.springframework.shell.table.BorderStyle;
import org.springframework.shell.table.TableBuilder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Component
public class PharmacyFormatter {

    private static String[] toRow(PharmacyItem pharmacyItem) {
        return new String[] {
                String.valueOf(pharmacyItem.userId()),
                pharmacyItem.title(),
                String.valueOf(pharmacyItem.id()),
                String.valueOf(pharmacyItem.completed())
        };
    }

    public String convertToTable(PharmacyItem[] pharmacyItems) {
        var data = Arrays.stream(pharmacyItems).map(PharmacyFormatter::toRow).collect(Collectors.toList());

        data.add(0, new String[]{"userId", "title", "id", "completed"});
        data = data.subList(0, Math.min(101, data.size()));
        ArrayTableModel arrayTableModel = new ArrayTableModel(data.toArray(Object[][]::new));
        TableBuilder tableBuilder = new TableBuilder(arrayTableModel);

        tableBuilder.addHeaderAndVerticalsBorders(BorderStyle.fancy_light);
        return tableBuilder.build().render(170);
    }
}
