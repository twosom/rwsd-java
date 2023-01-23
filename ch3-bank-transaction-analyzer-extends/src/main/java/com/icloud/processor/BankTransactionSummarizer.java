package com.icloud.processor;

import com.icloud.model.BankTransaction;
import com.icloud.model.SummaryStatistics;

import java.util.List;

public interface BankTransactionSummarizer {

    double summarize(double accumulator, BankTransaction bankTransaction);

    SummaryStatistics summarize(double accumulator, List<BankTransaction> bankTransactions);

}
