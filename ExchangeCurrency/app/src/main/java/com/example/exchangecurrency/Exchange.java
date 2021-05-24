package com.example.exchangecurrency;

import android.os.AsyncTask;
import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class Exchange {
    public final List<String> results = new ArrayList<>();
        public Document getDocument(String xml){
            Document document = null;
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            try {
                DocumentBuilder db = factory.newDocumentBuilder();
                InputSource is= new InputSource();
                is.setCharacterStream(new StringReader(xml));
                is.setEncoding("utf-8");
                document = db.parse(is);
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return  document;
        }
    public String getValue(Element item,String name){
        NodeList nodes = item.getElementsByTagName(name);
        return this.getTextNodeValue(nodes.item(0));
    }
    private final String getTextNodeValue(Node elem){
            Node child;
            if (elem !=null){
                if (elem.hasChildNodes()){
                    for(child = elem.getFirstChild();child !=null; child= child.getNextSibling()){
                            if(child.getNodeType()== Node.TEXT_NODE){
                                return child.getNodeValue();
                            }
                    }
                }
            }
            return "";
    }
}