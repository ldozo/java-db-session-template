package com.enginaar.sessionauthtemplate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enginaar.sessionauthtemplate.entity.TransactionLog;

public interface LogRepository extends JpaRepository<TransactionLog, Long> {

}
