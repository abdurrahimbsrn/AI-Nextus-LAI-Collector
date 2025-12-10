package com.ainextus_lai_collector.controller;

import com.ainextus_lai_collector.dto.LogRequestDto;
import com.ainextus_lai_collector.entity.LogEntity;
import com.ainextus_lai_collector.service.LogService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/logs")
public class LogController {

    private final LogService logService;

    @PostMapping
    public ResponseEntity<?> receive(@Valid @RequestBody LogRequestDto req) {
        LogEntity saved = logService.save(req);
        return ResponseEntity.accepted().body(saved.getId());
    }
}
