package com.baile.grupodebaile.services;

import com.baile.grupodebaile.models.EmailMessage;

public interface SendMailService {
    void SendMail (String inputName, String inputPhone, String to, String from, String subject, String message);

    //Método que pide crear el controlador
    void save(EmailMessage emailMessage);

    EmailMessage listOne(Long id);



 
}
