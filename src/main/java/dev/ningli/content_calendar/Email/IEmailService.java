package dev.ningli.content_calendar.Email;

import jakarta.mail.MessagingException;

public interface IEmailService {
    String sendSimpleMail(Email email);

    String sendMailWithAttachment(Email email) throws MessagingException;
}
