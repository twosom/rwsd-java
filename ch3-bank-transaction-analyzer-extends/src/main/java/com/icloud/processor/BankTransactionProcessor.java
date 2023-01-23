package com.icloud.processor;

import com.icloud.model.BankTransaction;
import com.icloud.model.SummaryStatistics;
import com.icloud.processor.filter.BankTransactionFilter;
import lombok.RequiredArgsConstructor;

import java.time.Month;
import java.util.List;

@RequiredArgsConstructor
public class BankTransactionProcessor {
    private final List<BankTransaction> bankTransactions;

    public double summarizeTransactions(final BankTransactionSummarizer bankTransactionSummarizer) {
        double result = 0;
        for (final BankTransaction bankTransaction : bankTransactions) {
            result = bankTransactionSummarizer.summarize(result, bankTransaction);
        }
        return result;
    }

    public SummaryStatistics getSummarize(final BankTransactionSummarizer bankTransactionSummarizer) {
        return bankTransactionSummarizer.summarize(0, bankTransactions);
    }

    public double calculateTotalInMonth(final Month month) {
        return bankTransactions.stream()
                .filter(e -> e.date().getMonth() == month)
                .mapToDouble(BankTransaction::amount)
                .sum();
    }

    public List<BankTransaction> findTransactions(final BankTransactionFilter bankTransactionFilter) {
        return bankTransactions.stream()
                .filter(bankTransactionFilter::test)
                .toList();
    }

    public List<BankTransaction> findTransactionsGreaterThanEqual(final int amount) {
        return findTransactions(bankTransaction -> bankTransaction.amount() >= amount);
    }



}
