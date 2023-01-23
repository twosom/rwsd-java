package com.icloud.processor;

import com.icloud.model.BankTransaction;
import lombok.RequiredArgsConstructor;

import java.time.Month;
import java.util.List;

@RequiredArgsConstructor
public class BankStatementProcessor {
    private final List<BankTransaction> bankTransactions;

    public double calculateTotalAmount() {
        return bankTransactions.stream()
                .mapToDouble(BankTransaction::amount)
                .sum();
    }

    public double calculateTotalInMonth(final Month month) {
        return bankTransactions.stream()
                .filter(e -> e.date().getMonth() == month)
                .mapToDouble(BankTransaction::amount)
                .sum();
    }

    public double calculateTotalForCategory(final String category) {
        return bankTransactions.stream()
                .filter(e -> e.description().equals(category))
                .mapToDouble(BankTransaction::amount)
                .sum();
    }


}
