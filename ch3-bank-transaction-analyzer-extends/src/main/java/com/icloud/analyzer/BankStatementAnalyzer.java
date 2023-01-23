package com.icloud.analyzer;

import com.icloud.exporter.Exporter;
import com.icloud.model.BankTransaction;
import com.icloud.model.SummaryStatistics;
import com.icloud.parser.BankStatementParser;
import com.icloud.processor.BankTransactionProcessor;
import com.icloud.processor.BankTransactionSummarizerImpl;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
public class BankStatementAnalyzer {

    private final Exporter exporter;


    public String analyze(final String fileName,
                          final BankStatementParser bankStatementParser)
            throws URISyntaxException, IOException {

        final Path path = Paths.get(getUri(fileName));
        final List<String> lines = Files.readAllLines(path);
        final List<BankTransaction> bankTransactions
                = bankStatementParser.parseLinesFrom(lines);
        final BankTransactionProcessor bankTransactionProcessor
                = new BankTransactionProcessor(bankTransactions);
        correctSummary(bankTransactionProcessor);

        SummaryStatistics summarizeStatistics = bankTransactionProcessor.getSummarize(new BankTransactionSummarizerImpl());
        return exporter.export(summarizeStatistics);

    }

    private void correctSummary(BankTransactionProcessor bankTransactionProcessor) {
//        System.out.println("The total for all transactions is " + bankTransactionProcessor.calculateTotalAmount());
        System.out.println("The total for transactions in January is " + bankTransactionProcessor.calculateTotalInMonth(Month.JANUARY));
        System.out.println("The total for transactions in February is " + bankTransactionProcessor.calculateTotalInMonth(Month.FEBRUARY));
//        System.out.println("The total salary received is " + bankTransactionProcessor.calculateTotalForCategory("Salary"));
    }

    private URI getUri(final String fileName) throws URISyntaxException {
        return Objects.requireNonNull(BankStatementAnalyzer.class
                        .getClassLoader()
                        .getResource(fileName))
                .toURI();
    }
}
