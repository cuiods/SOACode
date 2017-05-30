package edu.nju.soa;

import edu.nju.soa.entity.ScoreList;
import edu.nju.soa.entity.StudentList;
import edu.nju.soa.translate.Generator;
import edu.nju.soa.translate.Translator;
import edu.nju.soa.translate.XmlParser;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        try {
            OutputStream outputStream = new FileOutputStream(new File("doc/文档2.xml"));
            String result = XmlParser.marshal(Generator.generateData());
            outputStream.write(result.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            InputStream inputStream = new FileInputStream(new File("doc/文档2.xml"));
            ScoreList scoreList = Translator.convert(XmlParser.unmarshal(inputStream, StudentList.class));
            File file = new File("doc/文档3.xml");
            OutputStream outputStream = new FileOutputStream(file);
            outputStream.write(XmlParser.marshal(scoreList).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            InputStream inputStream = new FileInputStream(new File("doc/文档3.xml"));
            ScoreList scoreList = XmlParser.unmarshal(inputStream, ScoreList.class);
            File file = new File("doc/文档4.xml");
            OutputStream outputStream = new FileOutputStream(file);
            outputStream.write(XmlParser.marshal(Translator.convert(scoreList)).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
