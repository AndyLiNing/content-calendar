package dev.ningli.content_calendar.Email;

import jakarta.mail.MessagingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController()
public class EmailController {
    private final EmailService emailService;
    private final EmailSenderService emailSenderService;

    public EmailController(EmailService emailService,
                           EmailSenderService emailSenderService) {
        this.emailService = emailService;
        this.emailSenderService = emailSenderService;
    }
    @GetMapping(value = "api/send-email")
    public String send() throws MessagingException, UnsupportedEncodingException {
        Email email = new Email("lining.france@gmail.com",
                "lining.france@gmail.com",
                "Hello email", "Spring boot + Google SMTP");

        // simulateSendingProcess(email);
        // emailSenderService.send(email);
        emailSenderService.sendAsync(email);
        return "OK";
    }

    private void simulateSendingProcess(Email email) {
        Runnable task = () -> {
            try {
                Thread.sleep(30000);
                emailSenderService.send(email);
            } catch (MessagingException | UnsupportedEncodingException | InterruptedException ex) {
                ex.printStackTrace();
            }
        };
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        try{
            executorService.submit(task);
        } finally {
            executorService.shutdown();
        }
    }



}
