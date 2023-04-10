package com.enginaar.sessionauthtemplate.helpers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.enginaar.sessionauthtemplate.entity.TransactionLog;
import com.enginaar.sessionauthtemplate.repository.LogRepository;
import com.enginaar.sessionauthtemplate.service.LogService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MailSender {
    
    private LogRepository logs;
    @Qualifier("appMessages")
    private Map<String, String> messages;

    // for retrial - to be later
    public void sendEmail() {
        var list = logs.findByStatus("NEW");
        for(var log : list) {
            System.out.printf(messages.get(log.getAction()), log.toString());
        }
    }

    @Async
    public void send(TransactionLog log) {
        System.out.printf(messages.get(log.getAction()), log.toString());
        log.setStatus("MAIL_SENT");
        logs.save(log);
    }
}
