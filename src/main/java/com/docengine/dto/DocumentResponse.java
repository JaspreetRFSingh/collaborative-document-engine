package com.docengine.dto;
import lombok.*;
import java.util.UUID;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentResponse {
    private UUID id;
    private String title;
    private String content;
    private Integer version;
}
