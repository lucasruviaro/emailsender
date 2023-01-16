package com.lucas.emailsender.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucas.emailsender.model.EmailModel;

public interface EmailRepository extends JpaRepository<EmailModel, UUID> {
    
}
