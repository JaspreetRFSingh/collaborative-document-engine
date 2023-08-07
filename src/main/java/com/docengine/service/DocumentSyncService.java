package com.docengine.service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.*;
@Service
@Slf4j
public class DocumentSyncService {
    public String syncDocument(String documentId, String clientState) {
        log.info("Syncing document: {}", documentId);
        return clientState;
    }
}
