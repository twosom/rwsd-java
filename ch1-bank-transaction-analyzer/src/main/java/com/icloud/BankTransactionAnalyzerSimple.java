package com.icloud;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

public class BankTransactionAnalyzerSimple {

    private static final String RESOURCES = "src/main/resources/";

    public static void main(String[] args) throws IOException, URISyntaxException {
        final Path path = Paths.get(getUri(args));
        final List<String> lines = Files.readAllLines(path);

        double total = 0d;
        final DateTimeFormatter DATE_PATTERN =
                DateTimeFormatter.ofPattern("dd-MM-yyyy");

        for (final var line : lines) {
            final String[] columns = line.split(",");
            final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
            if (date.getMonth() == Month.JANUARY) {
                final double amount = Double.parseDouble(columns[1]);
                total += amount;
            }
        }
        System.out.println("The total for all transactions in January is " + total);
    }


    private static URI getUri(String[] args) throws URISyntaxException {
        return Objects.requireNonNull(BankTransactionAnalyzerSimple.class
                        .getClassLoader()
                        .getResource(args[0]))
                .toURI();
    }
}
