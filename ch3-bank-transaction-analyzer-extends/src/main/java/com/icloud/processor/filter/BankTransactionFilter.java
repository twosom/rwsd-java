package com.icloud.processor.filter;

import com.icloud.model.BankTransaction;

@FunctionalInterface
public interface BankTransactionFilter {

    boolean test(BankTransaction bankTransaction);

}
