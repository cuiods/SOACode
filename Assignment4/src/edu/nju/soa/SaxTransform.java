package edu.nju.soa;

import org.xml.sax.helpers.AttributesImpl;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

/**
 * Created by sam on 2017/4/23.
 */
public class SaxTransform {


    public void transfer(String topath, List<Class> classes){
        //1:创建一个SAXTransformerFactory对象
        SAXTransformerFactory saxtransformerfactory = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
        try{
            //2:创建TransformerHandler对象
            TransformerHandler transformerhandler = saxtransformerfactory.newTransformerHandler();
            //3:创建Transformer对象
            Transformer transformer=transformerhandler.getTransformer();
            //4：利用transformer的对象对xml文件格式进行设置
                //1:利用OutputKeys.ENCODING设定xml文件的编码
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                //2:利用OutputKeys.INDENT设定xml文件是否换行
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            File file=new File(topath);
            if(!file.exists()){ //用一个if语句判断，file文件是否存在，如果不存在的话，则 创建一个相应的file文件
                file.createNewFile();
                
            }

            //6创建RESULT对象，使其与TransformerHandler的对象相关联
            Result result=new StreamResult(new FileOutputStream(file));
            transformerhandler.setResult(result);

            transformerhandler.startDocument();
            AttributesImpl attr = new AttributesImpl();

            transformerhandler.startElement("","","课程成绩列表",attr);

            for(Class cl:classes){
                attr.clear();
                attr.addAttribute("","","成绩性质","",cl.getType());
                attr.addAttribute("","","课程编号","",cl.getId());
                transformerhandler.startElement("","","课程成绩",attr);

                for(Score sc:cl.getScores()){
                    attr.clear();
                    transformerhandler.startElement("","","成绩",attr);

                    attr.clear();
                    transformerhandler.startElement("","","学号",attr);
                    transformerhandler.characters(sc.getNumber().toCharArray(),0,sc.getNumber().length());
                    transformerhandler.endElement("","","学号");

                    attr.clear();
                    transformerhandler.startElement("","","得分",attr);
                    transformerhandler.characters(sc.getScore().toCharArray(),0,sc.getScore().length());
                    transformerhandler.endElement("","","得分");

                    transformerhandler.endElement("","","成绩");
                }

                transformerhandler.endElement("","","课程成绩");
            }

            transformerhandler.endElement("","","课程成绩列表");
            transformerhandler.endDocument();


        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
