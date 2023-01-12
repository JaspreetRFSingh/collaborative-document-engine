package com.docengine.entity;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;
@Entity
@Table(name = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(name = "display_name")
    private String displayName;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
