package com.docengine.service;
import com.docengine.entity.DocumentVersion;
import com.docengine.repository.DocumentVersionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class VersioningService {
    private final DocumentVersionRepository versionRepository;
    public void createVersion(UUID documentId, String content, UUID userId) {
        DocumentVersion version = DocumentVersion.builder()
                .documentId(documentId)
                .content(content)
                .createdBy(userId)
                .build();
        versionRepository.save(version);
    }
    public List<DocumentVersion> getVersions(UUID documentId) {
        return versionRepository.findByDocumentIdOrderByVersionDesc(documentId);
    }
}
