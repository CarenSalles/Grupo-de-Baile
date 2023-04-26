package com.baile.grupodebaile.controllers;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
        emailMessage.setTo("info@johnnyramirez.es");
        emailMessage.setSubject("Mensaje para Xaréu D´Ochobre");

        this.sendMailService.SendMail(emailMessage.getFrom(), emailMessage.getTo(), emailMessage.getSubject(), emailMessage.getInputName(),
                emailMessage.getInputPhone(),  emailMessage.getMessage());
                sendMailService.save(emailMessage);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/api/listemails")
    public List<EmailMessage> listAll() {
        return sendMailService.listAll();
    }

    @DeleteMapping("/api/listemails/{id}")
    public void delete(@PathVariable Long id) {
        sendMailService.delete(id);
    }

}
