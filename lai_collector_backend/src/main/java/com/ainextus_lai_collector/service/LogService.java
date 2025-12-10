package com.ainextus_lai_collector.service;

import com.ainextus_lai_collector.dto.LogRequestDto;
import com.ainextus_lai_collector.entity.LogEntity;
import com.ainextus_lai_collector.repository.LogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@RequiredArgsConstructor
@Service
public class LogService {

    private final LogRepository logRepository;
    private final ObjectMapper mapper = new ObjectMapper();

    public LogEntity save(LogRequestDto req){
        LogEntity e = LogEntity.builder()
                .service(req.getService())
                .level(req.getLevel())
                .message(req.getMessage())
                .raw(req.getRaw())
                .createdAt(Instant.now())
                .eventTs(parseTs(req.getTimestamp()))
                .context(serialize(req.getContext()))
                .build();

        return logRepository.save(e);
    }
    private Instant parseTs(String ts) {
        try {
            return ts == null ? Instant.now() : Instant.parse(ts);
        } catch (Exception ex) {
            return Instant.now();
        }
    }

    private String serialize(Object obj) {
        try { return obj == null ? null : mapper.writeValueAsString(obj); }
        catch (Exception ex) { return null; }
    }
}
