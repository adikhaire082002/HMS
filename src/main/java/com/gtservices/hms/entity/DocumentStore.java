package com.gtservices.hms.entity;

import com.gtservices.hms.enums.DocumentType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "document_store")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DocumentStore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "document_id")
    private Integer documentId;

    @Enumerated(EnumType.STRING)
    @Column(name = "document_type")
    private DocumentType documentType;

    @Column(name = "reference_id")
    private Integer referenceId;

    @Column(name = "file_path", length = 255)
    private String filePath;

    @Column(name = "generated_at")
    private LocalDateTime generatedAt;
}