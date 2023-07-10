package com.docengine.config;
import org.springframework.messaging.*;
import org.springframework.messaging.simp.stomp.*;
import org.springframework.stereotype.*;
@Component
public class WebSocketAuthInterceptor implements ChannelInterceptor {
    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        return message;
    }
}
