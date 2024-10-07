package dev.ningli.content_calendar.Email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;


@Service
public class EmailService implements IEmailService {

    private final JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public String sendSimpleMail(Email email) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        // Setting up necessary details
        simpleMailMessage.setFrom(email.from());
        simpleMailMessage.setTo(email.to());
        simpleMailMessage.setText(email.content());
        simpleMailMessage.setSubject(email.subject());

        javaMailSender.send(simpleMailMessage);
        return "OK";
    }

    @Override
    public String sendMailWithAttachment(Email email) throws MessagingException {
        // Creating a mime message
        MimeMessage mimeMessage
                = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;
        // Setting multipart as true for attachments to
        // be send
        mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
//        mimeMessageHelper.setFrom(sender);
//        mimeMessageHelper.setTo(details.getRecipient());
//        mimeMessageHelper.setText(details.getMsgBody());
//        mimeMessageHelper.setSubject(
//                details.getSubject());

        // Adding the attachment
        FileSystemResource file
                = new FileSystemResource(
                new File(""));

        mimeMessageHelper.addAttachment(
                file.getFilename(), file);

        // Sending the mail
        javaMailSender.send(mimeMessage);
        return "Mail sent Successfully";
    }
}
