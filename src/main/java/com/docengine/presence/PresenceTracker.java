package com.docengine.presence;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
@Component
@Slf4j
public class PresenceTracker {
    private final Map<String, Set<String>> documentUsers = new ConcurrentHashMap<>();
    public void userJoined(String documentId, String userId) {
        documentUsers.computeIfAbsent(documentId, k -> ConcurrentHashMap.newKeySet()).add(userId);
        log.info("User {} joined document {}", userId, documentId);
    }
    public void userLeft(String documentId, String userId) {
        documentUsers.getOrDefault(documentId, Collections.emptySet()).remove(userId);
    }
    public Set<String> getActiveUsers(String documentId) {
        return documentUsers.getOrDefault(documentId, Collections.emptySet());
    }
}
