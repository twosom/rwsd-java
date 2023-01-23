package com.icloud.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SummaryStatistics {
    private final double sum;
    private final double max;
    private final double min;
    private final double average;

}
