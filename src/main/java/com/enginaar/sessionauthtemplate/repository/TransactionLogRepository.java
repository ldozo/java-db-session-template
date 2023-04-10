package com.enginaar.sessionauthtemplate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enginaar.sessionauthtemplate.entity.TransactionLog;

public interface TransactionLogRepository extends JpaRepository<TransactionLog, Long> {

}
