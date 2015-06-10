package com.nsn.jsonparser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;

public class App {

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            BufferedReader fileReader = new BufferedReader(
                    new FileReader("D:\\userdata\\pabiswas\\jsonParser\\src\\main\\resources\\TPDInst.json"));
            JsonNode rootNode = mapper.readTree(fileReader);
            JsonNode duModeNode = rootNode.path("DuMode");
            System.out.println("DUMODE : " + duModeNode.getTextValue());

            JsonNode ageNode = rootNode.path("Schema");
            System.out.println("SCHEMA : " + ageNode.getTextValue());
            System.out.println("");
            
            JsonNode ScalarsNode = rootNode.path("Scalars");
            JsonNode rootDuParamNode = ScalarsNode.path("DuParam");
            Iterator<JsonNode> it = rootDuParamNode.getElements();
            
            while(it.hasNext())
            {
                JsonNode duParamNode = it.next();
                
                JsonNode paramNode = duParamNode.path("Param");
                
                JsonNode valueNode = paramNode.path("Value");
                System.out.println("Value : " + valueNode.getTextValue());
                if(valueNode.getTextValue().equals("DN1"))
                {
                    ((ObjectNode)paramNode).put("Value", "Updated DN");
                }
                JsonNode nameNode = paramNode.path("Name");
                System.out.println("Name : " + nameNode.getTextValue());
                
                JsonNode keyNode = duParamNode.path("Key");
                System.out.println("Key : " + keyNode.getTextValue());
                
                System.out.println("");
            }
            
            ((ObjectNode) rootNode).put("Schema", "HLR Schema");
            
            mapper.writeValue(new File("d:\\user.json"), rootNode);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
