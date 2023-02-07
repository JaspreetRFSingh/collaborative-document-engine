package com.docengine.service;
import com.docengine.dto.DocumentRequest;
import com.docengine.dto.DocumentResponse;
import com.docengine.entity.Document;
import com.docengine.repository.DocumentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
@Slf4j
public class DocumentService {
    private final DocumentRepository documentRepository;
    @Transactional
    public DocumentResponse createDocument(DocumentRequest request) {
        Document doc = Document.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .version(0)
                .build();
        doc = documentRepository.save(doc);
        return toResponse(doc);
    }
    @Transactional(readOnly = true)
    public DocumentResponse getDocument(UUID id) {
        return documentRepository.findById(id)
                .map(this::toResponse)
                .orElseThrow(() -> new RuntimeException("Document not found"));
    }
    private DocumentResponse toResponse(Document doc) {
        return DocumentResponse.builder()
                .id(doc.getId())
                .title(doc.getTitle())
                .content(doc.getContent())
                .version(doc.getVersion())
                .build();
    }
    public void handleWebSocketMessage(WebSocketSession session, String payload) {
        log.info("Received WebSocket message: {}", payload);
    }
}
