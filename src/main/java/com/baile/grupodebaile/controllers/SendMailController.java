package com.baile.grupodebaile.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.baile.grupodebaile.models.EmailMessage;
import com.baile.grupodebaile.services.SendMailService;

@RestController
public class SendMailController {

    private final SendMailService sendMailService;

    public SendMailController(SendMailService sendMailService) {
        this.sendMailService = sendMailService;
    }

    @PostMapping(path = "/api/sendemail")
    public ResponseEntity<?> sendMail(@RequestBody EmailMessage emailMessage) {
        emailMessage.setFrom("xareudochobre35@gmail.com");
        emailMessage.setTo("jehisel.rrp@gmail.com");
        emailMessage.setSubject("Mensaje para Xaréu D´Ochobre");

        this.sendMailService.SendMail(emailMessage.getFrom(), emailMessage.getTo(), emailMessage.getSubject(), emailMessage.getInputName(),
                emailMessage.getInputPhone(),  emailMessage.getMessage());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "/api/mail")
    public void store(@RequestBody EmailMessage email) {
        sendMailService.save(email);

    }

    @GetMapping("/api/sendemail")
    public EmailMessage listOne(@PathVariable Long id) {
        return sendMailService.listOne(id);
    }

}
