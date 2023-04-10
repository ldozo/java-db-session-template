package com.enginaar.sessionauthtemplate.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.enginaar.sessionauthtemplate.entity.TransactionLog;
import com.enginaar.sessionauthtemplate.repository.TransactionLogRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TransactionLogService {

    private TransactionLogRepository repo;
    
    public List<TransactionLog> list() {
        return repo.findAll();
    }

}
