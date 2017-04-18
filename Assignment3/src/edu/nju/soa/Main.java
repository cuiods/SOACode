package edu.nju.soa;

import edu.nju.soa.parser.DomParser;

public class Main {

    public static void main(String[] args) {
        DomParser domParser = new DomParser();
        domParser.createStudentsXML("文档2.xml");
    }
}
