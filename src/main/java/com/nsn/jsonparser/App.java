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
        xmlParser afwXmlParser = new xmlParser();
        afwXmlParser.parse();
        
        jsonParser tpdJsonParser = new jsonParser();
        tpdJsonParser.parse();
    }
}
