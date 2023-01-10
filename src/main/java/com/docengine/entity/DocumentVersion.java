package com.docengine.entity;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;
@Entity
@Table(name = "document_versions")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentVersion {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "document_id")
    private UUID documentId;
    @Column(nullable = false)
    private Integer version;
    @Column(columnDefinition = "TEXT")
    private String content;
    @Column(name = "created_by")
    private UUID createdBy;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
