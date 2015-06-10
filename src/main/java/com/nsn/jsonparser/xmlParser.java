package com.nsn.jsonparser;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author soup
 */
public class xmlParser {

    public void parse() {
        try {
            File fXmlFile = new File("D:\\tpd\\TZZ\\V92\\TZZY0V922000\\TZZxahcfg\\reloc\\descriptors\\TZZxahcfg_hlri_ddh_afw_CD.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("DIBoolean");
            NodeList nList1 = doc.getElementsByTagName("DIStringKey");
            NodeList nList2 = doc.getElementsByTagName("DIInteger");

            System.setOut(new PrintStream(new FileOutputStream("D:\\userdata\\soup\\Desktop\\12345.txt")));
            for (int temp2 = 0; temp2 < nList1.getLength(); temp2++) {
                for (int temp1 = 0; temp1 < nList2.getLength(); temp1++) {
                    for (int temp = 0; temp < nList.getLength(); temp++) {

                        Node nNode = nList.item(temp);

                        Element eElement = (Element) nNode;

                        System.out.println(eElement.getAttributeNode("Name"));
                        System.out.println(eElement.getAttributeNode("Value"));
                    }
                    Node nNode1 = nList1.item(temp1);
                    Element eElement1 = (Element) nNode1;
                    System.out.println(eElement1.getAttributeNode("Name"));
                    System.out.println(eElement1.getAttributeNode("Value"));
                }
                Node nNode2 = nList2.item(temp2);
                Element eElement2 = (Element) nNode2;
                System.out.println(eElement2.getAttributeNode("Name"));
                System.out.println(eElement2.getAttributeNode("Value"));

            }
        } catch (Exception e) {

        }
    }
}
