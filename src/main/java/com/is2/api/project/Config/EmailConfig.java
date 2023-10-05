package com.is2.api.project.Config;

import java.util.Properties;

public class EmailConfig {
    public static Properties getProperties() {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.user", "witagomi2@gmail.com");
        properties.put("mail.password", "hjhb mvdl wmuy rmmg");
        return properties;
    }
}
