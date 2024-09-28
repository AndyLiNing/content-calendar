package dev.ningli.content_calendar.JsonLoader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.ningli.content_calendar.JsonLoader.model.Company;
import dev.ningli.content_calendar.JsonLoader.model.User;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Loader {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final Path basedir = Paths.get("").toAbsolutePath();
    public List<User> loadNonStaticData() throws IOException {
        // objectMapper.readTree(new File("user/users.json"));
        try{
            // Another way to get the base dir
            // System.getProperty("user.dir")
            return objectMapper.readValue(Files.readAllBytes(Paths.get(basedir + "/data/users.json")), new TypeReference<>(){} );
        }
        catch (IOException e) {
            throw new RuntimeException("Failed to read JSON data", e);
        }
    }

    public List<User> loadStaticData() throws IOException {
        try(InputStream inputStream = TypeReference.class.getResourceAsStream("/user/users.json")) {
            return objectMapper.readValue(inputStream, new TypeReference<>(){});
            // Returns JsonNode
            // return objectMapper.readValue(inputStream, JsonNode.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JSON data", e);
        }
    }

    public void writeJson() {
        String writeToFile = basedir + "/data/companies.json";
        Company company = new Company("Andy", "Never give up", " hahaha");
        try {
            objectMapper.writeValue(new File(writeToFile), company);
        } catch (IOException ioException){
            throw new RuntimeException("Failed to write JSON data", ioException);
        }

    }

}
