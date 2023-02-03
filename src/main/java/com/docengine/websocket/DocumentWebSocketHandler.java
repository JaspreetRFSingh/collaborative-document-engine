package com.docengine.websocket;
import com.docengine.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;
@RequiredArgsConstructor
public class DocumentWebSocketHandler extends TextWebSocketHandler {
    private final DocumentService documentService;
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
        documentService.handleWebSocketMessage(session, message.getPayload());
    }
}
