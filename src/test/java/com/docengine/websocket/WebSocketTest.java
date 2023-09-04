package com.docengine.websocket;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class WebSocketTest {
    @Test
    void testSessionManager() {
        SessionManager manager = new SessionManager();
        assertNotNull(manager);
    }
}
