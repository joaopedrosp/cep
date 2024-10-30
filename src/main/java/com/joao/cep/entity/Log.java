package com.joao.cep.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_LOG")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Log {

    @Id
    @Column(name = "UUID", nullable = false)
    private String uuid;

    @CreationTimestamp
    @Column(name = "DT")
    private LocalDateTime dtCreation;

    @Column(name = "SEVERITY")
    private String severity;

    @Column(name = "CONTENT")
    private String content;
}
