package com.duxetech.thevaram;

import android.content.Context;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by Karthik Swamy on 13-12-2018.
 */
public class xml_parser {
    Context c;
    String name, title, question, answer, id, file;
    NodeList nList;
    List<String> names;

    public NodeList xmlParse(Context context, String file){
        try{
            InputStream is =context.getAssets().open(file);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(is);
            Element element = doc.getDocumentElement();
            element.normalize();
            nList = doc.getElementsByTagName("names");
        } catch (Exception e){
            e.printStackTrace();
        }
        return nList;
    }
    public List<String> getQuiz(Context c, String file){
        xmlParse(c,file);
        names = new ArrayList<>();
        for(int i =0;i<nList.getLength();i++){
            Node node = nList.item(i);
            if(node.getNodeType()==Node.ELEMENT_NODE){
                Element element2 = (Element) node;
                name = element2.getElementsByTagName("name").item(0).getTextContent();

                names.add(name);
            }
        }
        return names;

    }


}
