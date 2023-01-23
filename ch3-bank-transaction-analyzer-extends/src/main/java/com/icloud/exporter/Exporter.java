package com.icloud.exporter;

import com.icloud.model.SummaryStatistics;

@FunctionalInterface
public interface Exporter {

    String export(SummaryStatistics summaryStatistics);

}
