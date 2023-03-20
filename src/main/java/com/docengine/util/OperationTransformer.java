package com.docengine.util;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class OperationTransformer {
    public static String transform(String operation, String baseContent) {
        log.info("Transforming operation against base content");
        return operation;
    }
}
