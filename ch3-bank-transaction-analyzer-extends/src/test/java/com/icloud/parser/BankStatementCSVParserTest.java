package com.icloud.parser;

import com.icloud.model.BankTransaction;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class BankStatementCSVParserTest {

    private final BankStatementParser statementParser = new BankStatementCSVParser();

    @Test
    void should_parse_one_correct_line() {
        // GIVEN
        final String line = "30-01-2017,-50,Tesco";

        // WHEN
        final BankTransaction result = statementParser.parseFrom(line);

        // THEN
        final BankTransaction expected
                = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -50, "Tesco");
        final double tolerance = 0.0d;
        assertEquals(expected.date(), result.date());
        assertEquals(expected.amount(), result.amount());
        assertEquals(expected.description(), result.description());
    }

    @Test
    void should_parse_many_correct_lines() {
        // GIVEN
        final List<String> lines =
                List.of("30-01-2017,-50,Tesco", "05-02-2017,-30,Cinema", "02-02-2017,2000,Royalties");

        // WHEN
        final List<BankTransaction> bankTransactions
                = statementParser.parseLinesFrom(lines);


        assertEquals(3,bankTransactions.size());


    }
}
