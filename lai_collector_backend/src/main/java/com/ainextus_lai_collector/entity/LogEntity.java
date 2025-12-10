package com.ainextus_lai_collector.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "log_entity")
public class LogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String service;
    private String level;

    @Column(columnDefinition = "text")
    private String message;

    @Column(name = "event_ts")
    private Instant eventTs; //Timestamp

    @Column(columnDefinition = "text")
    private String context;

    @Column(columnDefinition = "text")
    private String raw;

    @Column(name = "created_at")
    private Instant createdAt;
}
