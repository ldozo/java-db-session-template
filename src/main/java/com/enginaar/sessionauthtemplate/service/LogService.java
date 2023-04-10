package com.enginaar.sessionauthtemplate.service;

import org.springframework.stereotype.Service;

import com.enginaar.sessionauthtemplate.entity.TransactionLog;
import com.enginaar.sessionauthtemplate.repository.LogRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LogService {

    private LogRepository logs;

    @Transactional
    public void add(String key, String old, String nevv) {
        var entry = preapareLogEntry(key, nevv);
        entry.setOldPayload(old);
        logs.save(entry);
    }

    public void add(String key, String payload) {
        var entry = preapareLogEntry(key, payload);
        logs.save(entry);
    }

    private TransactionLog preapareLogEntry(String key, String payload) {
        var log = new TransactionLog();
        log.setStatus("NEW");
        log.setAction(key);
        log.setNewPayload(payload);
        return log;
    }

}
