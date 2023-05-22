package com.docengine.websocket;
import org.springframework.web.socket.*;
import org.springframework.stereotype.*;
import java.util.concurrent.*;
@Component
public class SessionManager {
    private final Map<String, WebSocketSession> sessions = new ConcurrentHashMap<>();
    public void addSession(WebSocketSession session) {
        sessions.put(session.getId(), session);
    }
    public void removeSession(WebSocketSession session) {
        sessions.remove(session.getId());
    }
}
