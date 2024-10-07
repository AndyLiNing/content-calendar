package dev.ningli.content_calendar.Email;


import java.util.Random;

public record Email(String to, String from, String content, String subject) {


    public int getId() {
        return new Random().nextInt(100000);
    }

    public String getHtmlContent() {
        return "<h3> Hello Spring boot email </h3>" +
                "<p> " + content + " </p>" +
                "<br>";
    }

    public String getSubject() {
        return subject;
    }

    public String[] getTo() {
        return new String[]{"lining.france@gmail.com" };
    }

    public String[] getCc() {
        return new String[]{ "lining.arthur@gmail.com", "ningli.france@gmail.com"};
    }

    public String[] getBcc() {
        return new String[]{"andyningli@gmail.com"};
    }

}
