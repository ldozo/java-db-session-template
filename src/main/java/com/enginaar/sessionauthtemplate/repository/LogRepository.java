package com.enginaar.sessionauthtemplate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enginaar.sessionauthtemplate.entity.TransactionLog;

public interface LogRepository extends JpaRepository<TransactionLog, Long> {

    List<TransactionLog> findByStatus(String string);

}
