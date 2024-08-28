package com.api.BookstoreAPI.config;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

@Component
public class CustomMetrics {

    private final Counter bookCreationCounter;

    public CustomMetrics(MeterRegistry meterRegistry) {
        this.bookCreationCounter = meterRegistry.counter("custom.metrics.book.created");
    }

    public void incrementBookCreationCounter() {
        this.bookCreationCounter.increment();
    }
}
