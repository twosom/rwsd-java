package com.icloud.model;

import java.time.LocalDate;

/**
 * Java 17 의 기능을 살리기 위해 {@link Record} 형태로 변환
 *
 * @param date
 * @param amount
 * @param description
 */
public record BankTransaction(LocalDate date, double amount, String description) {
}
