package com.lucas.emailsender.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.emailsender.dto.EmailDTO;
import com.lucas.emailsender.model.EmailModel;
import com.lucas.emailsender.service.EmailService;

import jakarta.validation.Valid;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/sending-email")
    public ResponseEntity<EmailModel> sendEmail(@RequestBody @Valid EmailDTO emailDTO){
        EmailModel email = new EmailModel();
        BeanUtils.copyProperties(emailDTO, email);
        emailService.sendEmail(email);
        return new ResponseEntity<>(email, HttpStatus.CREATED);

    }
}
