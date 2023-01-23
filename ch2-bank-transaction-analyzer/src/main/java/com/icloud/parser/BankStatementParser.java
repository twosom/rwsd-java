package com.icloud.parser;

import com.icloud.model.BankTransaction;

import java.util.List;

public interface BankStatementParser {
    BankTransaction parseFrom(String line);

    default List<BankTransaction> parseLinesFrom(List<String> lines) {
        return lines.stream()
                .map(this::parseFrom)
                .toList();
    }
}
