package com.docengine.service;
import com.docengine.crdt.ORSet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Service
@Slf4j
public class CollaborationService {
    private final Map<String, ORSet<String>> documentOperations = new ConcurrentHashMap<>();
    public void applyOperation(String documentId, String operation, String nodeId) {
        documentOperations.computeIfAbsent(documentId, k -> new ORSet<>())
                .add(operation, nodeId);
        log.info("Applied operation {} to document {}", operation, documentId);
    }
    public ORSet<String> getDocumentState(String documentId) {
        return documentOperations.get(documentId);
    }
}
