package dev.ningli.content_calendar.Database.PureJDBC;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Properties;

public class LoadDatabaseProperties {
    private static final Properties properties = new Properties();

    static {
        try {
            properties.load(
                    Files.newInputStream(
                            Path.of(""),
                            StandardOpenOption.READ)
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Properties getDatabaseProperties() {
        return properties;
    }


}
