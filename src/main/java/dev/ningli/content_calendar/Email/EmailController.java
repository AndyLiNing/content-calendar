package dev.ningli.content_calendar.Email;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class EmailController {
    private final EmailService emailService;
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }
    @GetMapping(value = "api/send-email")
    public String send() {
        Email e = new Email("lining.france@gmail.com",
                "lining.france@gmail.com",
                "Hello email", "Spring boot + Google SMTP");
        return this.emailService.sendSimpleMail(e);
    }

}
