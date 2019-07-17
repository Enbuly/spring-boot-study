package com.example.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.IOException;
import java.io.StringWriter;

/***
 * dom4j example
 *
 * @author lazy cat
 * @since 2019-07-17
 **/
public class Dom4jExample {

    public static void main(String[] args) {
        String xml = genXmlStr(DocumentHelper.createDocument());
        System.out.println(xml);
        Document document = DocumentHelper.createDocument();
        try {
            document = analyzeXmlString(xml);
        } catch (DocumentException e) {
            System.out.println(e.getMessage());
        }
        printDocument(document);
    }

    private static String genXmlStr(Document document) {
        Element rootEle = document.addElement("root");
        Element platformEle = rootEle.addElement("platform");
        Element typeEle = platformEle.addElement("type");
        typeEle.addAttribute("name", "iOS");
        Element languageEle = typeEle.addElement("language");
        languageEle.setText("swift");
        Element companyEle = typeEle.addElement("company");
        companyEle.setText("apple");
        typeEle = platformEle.addElement("type");
        typeEle.addAttribute("name", "Android");
        languageEle = typeEle.addElement("language");
        languageEle.setText("java");
        companyEle = typeEle.addElement("company");
        companyEle.setText("google");
        //这个不换行
        OutputFormat format = OutputFormat.createCompactFormat();
        //这个换行
        //OutputFormat format = OutputFormat.createPrettyPrint();
        format.setTrimText(false);
        StringWriter writer = new StringWriter();
        XMLWriter output = new XMLWriter(writer, format);
        try {
            output.write(document);
            writer.close();
            output.close();
            return writer.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Document analyzeXmlString(String xmlStr) throws DocumentException {
        return DocumentHelper.parseText(xmlStr);
    }

    private static void printDocument(Document document) {
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setTrimText(false);
        StringWriter writer = new StringWriter();
        XMLWriter output = new XMLWriter(writer, format);
        try {
            output.write(document);
            writer.close();
            output.close();
            System.out.println(writer.toString());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

}