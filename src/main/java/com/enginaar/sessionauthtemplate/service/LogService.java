package com.enginaar.sessionauthtemplate.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.enginaar.sessionauthtemplate.entity.TransactionLog;
import com.enginaar.sessionauthtemplate.helpers.MailSender;
import com.enginaar.sessionauthtemplate.repository.LogRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LogService {

    private LogRepository logs;
    private MailSender mail;


    public List<TransactionLog> list() {
        return logs.findAll();
    }

    public List<TransactionLog> findPendingLogs() {
        var list = logs.findByStatus("NEW");
        return list;
    }
    
    @Transactional
    public void add(String key, String old, String nevv) {
        var entry = preapareLogEntry(key, nevv);
        entry.setOldPayload(old);
        var saved = logs.save(entry);
        mail.send(saved);
    }

    @Transactional
    public void add(String key, String payload) {
        var entry = preapareLogEntry(key, payload);
        var saved = logs.save(entry);
        mail.send(saved);
    }

    private TransactionLog preapareLogEntry(String key, String payload) {
        var log = new TransactionLog();
        log.setStatus("NEW");
        log.setAction(key);
        log.setNewPayload(payload);
        return log;
    }

}
