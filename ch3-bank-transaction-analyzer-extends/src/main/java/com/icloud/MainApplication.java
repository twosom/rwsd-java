package com.icloud;

import com.icloud.analyzer.BankStatementAnalyzer;
import com.icloud.exporter.HTMLExporter;
import com.icloud.parser.BankStatementCSVParser;
import com.icloud.parser.BankStatementParser;

import java.io.IOException;
import java.net.URISyntaxException;

public class MainApplication {
    public static void main(final String[] args) throws URISyntaxException, IOException {
        final BankStatementAnalyzer bankStatementAnalyzer
                = new BankStatementAnalyzer(new HTMLExporter());

        final BankStatementParser bankStatementParser
                = new BankStatementCSVParser();

        String analyzeResult = bankStatementAnalyzer.analyze(args[0], bankStatementParser);
        System.out.println(analyzeResult);
    }
}
