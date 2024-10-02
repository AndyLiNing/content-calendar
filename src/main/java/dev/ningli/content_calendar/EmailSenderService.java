package com.bouygtel.portailventedad.serviceihm.util.sendemail;

import com.bouygtel.portailventedad.serviceihm.util.sendemail.model.Attachment;
import com.bouygtel.portailventedad.serviceihm.util.sendemail.model.Email;
import jakarta.activation.DataHandler;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import jakarta.mail.util.ByteArrayDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class EmailSenderService {

    private final Logger logger = LoggerFactory.getLogger(EmailSenderService.class);

    private final JavaMailSender javaMailSender;

    private final String[] images = {
            "logo_bouygues_telecom",
            "logo_bouygues_telecom_footer",
            "picto_satisfait",
            "picto_smsmessage",
            "picto_telephone",
            "youtube",
            "twitter",
            "instagram",
            "facebook"
    };

    public EmailSenderService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void send(Email email) throws MessagingException, UnsupportedEncodingException {

        MimeMultipart htmlMultipart = getMimeMultipart(email);

        addAttachments(email, htmlMultipart);

        MimeMessage mimeMessage = buildMimeMessage(email, htmlMultipart);

        javaMailSender.send(mimeMessage);

    }
    
    private MimeMultipart getMimeMultipart(Email email) throws MessagingException {

        MimeMultipart htmlMultipart = new MimeMultipart("mixed");
        MimeBodyPart bodyPart = new MimeBodyPart();

        if (null == email.getHtmlContent()) {
            email.setHtmlContent("<span>" + email.getTextContent().replaceAll("\n", "<br>") + "</span>");
        }

        bodyPart.setContent(email.getHtmlContent(), "text/html; charset=utf-8");

        htmlMultipart.addBodyPart(bodyPart);
        return htmlMultipart;
    }

    private void addAttachments(Email email, MimeMultipart htmlMultipart) {
        for( String image: images) {
            getImagesAttachment(htmlMultipart, image);
        }

        for(Attachment attachment : email.getAttachments()){
            getPdfAttachment(htmlMultipart, attachment);
        }
    }

    private MimeMessage buildMimeMessage(Email email, MimeMultipart htmlMultipart) throws MessagingException, UnsupportedEncodingException {
        // Create a message with the specified information.
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        // mimeMessage.setFrom(new InternetAddress(email.getFrom(), email.getFromName()));
        // TODO: check the from values
        mimeMessage.setFrom(new InternetAddress("xxx@bouygues-telecom.fr", "BYTEL"));

        mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(email.getTo()));

        if (null != email.getCc() && !email.getCc().isEmpty()) {
            mimeMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(email.getCc()));
        }

        if (null != email.getBcc() && !email.getBcc().isEmpty()) {
            mimeMessage.addRecipient(Message.RecipientType.BCC, new InternetAddress(email.getBcc()));
        }

        mimeMessage.setSubject(email.getSubject());
        mimeMessage.setContent(htmlMultipart);
        mimeMessage.setHeader("References", "<" + email.getId() + "@bouyguestelecom.cloud>");

        return mimeMessage;
    }

    private void getImagesAttachment(Multipart htmlMultipart, String imageName) {
        try {
            MimeBodyPart imageBodyPart = new MimeBodyPart();

            byte[] imageBytes = Files.readAllBytes(Paths.get("images/"+imageName+".png"));

            ByteArrayDataSource dataSource = new ByteArrayDataSource(imageBytes, "image/png");
            imageBodyPart.setDataHandler(new DataHandler(dataSource));

            imageBodyPart.setHeader("Content-ID", "<"+imageName+">");
            imageBodyPart.setDisposition(MimeBodyPart.INLINE);

            htmlMultipart.addBodyPart(imageBodyPart);
        } catch (Exception e) {
            logger.error("Exception", e);
        }

    }

    public void getPdfAttachment( Multipart htmlMultipart, Attachment attachment ) {
        byte[] content = attachment.getContent();
        String attachmentName = attachment.getName();

        if (null != content) {
            try {
                MimeBodyPart attachmentBodyPart = new MimeBodyPart();

                ByteArrayDataSource dataSource = new ByteArrayDataSource(content, "application/pdf");

                attachmentBodyPart.setDataHandler(new DataHandler(dataSource));
                attachmentBodyPart.setFileName(attachmentName);

                htmlMultipart.addBodyPart(attachmentBodyPart);
            } catch (Exception e) {
                logger.error("Exception", e);
            }
        }
    }
}
