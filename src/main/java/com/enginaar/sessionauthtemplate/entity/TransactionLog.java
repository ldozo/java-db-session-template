package com.enginaar.sessionauthtemplate.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "transaction_logs")
@Data
@EntityListeners(AuditingEntityListener.class)
public class TransactionLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "oldPayload", length = 1000)
    private String oldPayload;

    @Column(name = "newPayload", length = 1000)
    private String newPayload;

    @Column(name = "action")
    private String action;    

    @Column(name = "status", length = 10)
    private String status = "NEW";
    
    @CreatedBy
    private String insertedBy;
    
    @CreatedDate
    private LocalDateTime insertedAt;

    @LastModifiedBy
    private String lastMofidifedBy;
    
    @LastModifiedDate
    private LocalDateTime lastModifiedAt;
}
