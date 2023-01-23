package com.icloud.processor;

import com.icloud.model.BankTransaction;
import com.icloud.model.SummaryStatistics;

import java.util.List;

public class BankTransactionSummarizerImpl implements BankTransactionSummarizer {

    @Override
    public double summarize(double accumulator, BankTransaction bankTransaction) {
        return accumulator + bankTransaction.amount();
    }

    @Override
    public SummaryStatistics summarize(double accumulator, List<BankTransaction> bankTransactions) {
        var summaryStatistics = bankTransactions.stream()
                .mapToDouble(BankTransaction::amount)
                .summaryStatistics();

        return new SummaryStatistics(summaryStatistics.getSum(), summaryStatistics.getMax(), summaryStatistics.getMin(), summaryStatistics.getAverage());
    }
}
