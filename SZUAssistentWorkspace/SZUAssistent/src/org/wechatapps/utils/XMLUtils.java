package org.wechatapps.utils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.*;
import java.util.*;

/*
 * @Description XML Utilities
 * @author Charles Chen
 * @date 14-2-19
 * @version 1.0
 */
public class XMLUtils {
    /**
     * Parse XML to document
     *
     * @param is
     * @param charset
     * @return
     * @throws java.io.UnsupportedEncodingException
     */
    public static Document parseXmlToDoc(InputStream is, String charset) throws UnsupportedEncodingException, DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new InputStreamReader(is, charset));    // Read document
        return document;
    }

    /**
     * Parse XML to data map
     *
     * @param is Input stram
     * @return
     * @throws org.dom4j.DocumentException
     */
    public static Map<String, String> parseXmlToMap(InputStream is, String charset) throws DocumentException, IOException {
        Map<String, String> data = new HashMap<String, String>();
        SAXReader reader = new SAXReader();
        Document document = reader.read(new InputStreamReader(is, charset));    // Read document
        Element root = document.getRootElement(); // Get root element
        List<Element> elements = root.elements();
        // Retrieve all child element data
        for (Element element : elements) {
            data.put(element.getName(), element.getText());
        }
        return data;
    }

    /**
     * Parse object to XML
     *
     * @param object
     * @return
     */
    public static String objectToXml(Object object) {
        xstream.alias("xml", object.getClass());
        return xstream.toXML(object);
    }

    // Implement xstream to support CDATA
    private static XStream xstream = new XStream(new XppDriver() {
        public HierarchicalStreamWriter createWriter(Writer out) {
            return new PrettyPrintWriter(out) {
                boolean cdata = true;

                @SuppressWarnings("unchecked")
                public void startNode(String name, Class clazz) {
                    super.startNode(name, clazz);
                }

                protected void writeText(QuickWriter writer, String text) {
                    if (cdata) {
                        try {
                            Integer.parseInt(text);
                            writer.write(text);
                        } catch (NumberFormatException nfe) {
                            writer.write("<![CDATA[");
                            writer.write(text);
                            writer.write("]]>");
                        }

                    } else {
                        writer.write(text);
                    }
                }
            };
        }
    });

    public static void main(String[] args) {
//        String xmlStr = "<xml>\n" +
//                " <ToUserName><![CDATA[toUser]]></ToUserName>\n" +
//                " <FromUserName><![CDATA[fromUser]]></FromUserName> \n" +
//                " <CreateTime>1348831860</CreateTime>\n" +
//                " <MsgType><![CDATA[text]]></MsgType>\n" +
//                " <Content><![CDATA[this is a test]]></Content>\n" +
//                " <MsgId>1234567890123456</MsgId>\n" +
//                " </xml>\n";
//        try {
//            Map<String, String> data = parseXmlToMap(new ByteArrayInputStream(xmlStr.getBytes()), "UTF-8");
//            Set<String> keySet = data.keySet();
//            for (String key : keySet) {
//                System.out.println(key + ": " + data.get(key));
//            }
//
//            ReceiveTextMessage text = new ReceiveTextMessage();
//            text.setMsgId(data.get("MsgId"));
//            text.setFromUserName(data.get("FromUserName"));
//            text.setCreateTime(data.get("CreateTime"));
//            text.setContent(data.get("Content"));
//            text.setToUserName(data.get("ToUserName"));
//            text.setMsgType(data.get("MsgType"));
//            System.out.println(objectToXml(text));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
