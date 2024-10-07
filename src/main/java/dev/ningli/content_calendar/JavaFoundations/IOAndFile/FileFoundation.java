package dev.ningli.content_calendar.JavaFoundations.IOAndFile;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileFoundation {

    public static void read(String fileName) {
        try (FileReader fr = new FileReader(fileName)) {
            int is = fr.read();
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        File f = new File(fileName);
        String currentPath = new File("").getAbsolutePath();
        System.out.println("currentPath " + currentPath);

    }

    public static void write(String fileName) {
        File file = new File(fileName);

        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            Files.writeString(Paths.get(fileName), """
					Hello
					""");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readByte(String fileName){
        try {
            for(byte data : Files.readAllBytes(Paths.get(fileName))) {
                System.out.println("data: " + data);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
