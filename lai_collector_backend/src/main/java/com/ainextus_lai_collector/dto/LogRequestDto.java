package com.ainextus_lai_collector.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Map;

@Data
public class LogRequestDto {

    @NotBlank
    private String service;
    private String level;

    @NotBlank
    private String message;
    private String timestamp;
    private Map<String, Object> context;
    private String raw;
}
