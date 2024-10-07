package dev.ningli.content_calendar.JavaFoundations.IOAndFile;

import java.nio.file.Files;
import java.nio.file.Path;

public class pathFoundation {

    public static void read(String pathName) {
        Path path = Path.of("files/hello-file.txt");

        Path name = path.getFileName();
        Path parent = path.getParent();


    }

    public static void write(String pathName) {


    }

}
