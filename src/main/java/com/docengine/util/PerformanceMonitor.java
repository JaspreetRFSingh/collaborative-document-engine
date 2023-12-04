package com.docengine.util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.*;
@Component
@Slf4j
public class PerformanceMonitor {
    public void logLatency(String operation, long durationMs) {
        log.info("Operation: {} took {}ms", operation, durationMs);
    }
}
