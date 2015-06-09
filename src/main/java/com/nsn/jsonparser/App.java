package com.nsn.jsonparser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.ObjectMapper;

public class App {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            BufferedReader fileReader = new BufferedReader(
                    new FileReader("D:\\userdata\\pabiswas\\jsonParser\\src\\main\\java\\com\\nsn\\jsonparser\\user.json"));
            JsonNode rootNode = mapper.readTree(fileReader);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
