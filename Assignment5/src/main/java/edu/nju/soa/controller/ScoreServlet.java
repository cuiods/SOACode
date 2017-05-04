package edu.nju.soa.controller;

import edu.nju.soa.dao.ScoreDao;
import edu.nju.soa.entity.ScoreEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;
import javax.xml.soap.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/**
 * score servlet
 */
@WebServlet("/score")
public class ScoreServlet extends HttpServlet{

    private ScoreDao scoreDao;
    private MessageFactory messageFactory;

    @Override
    public void init() throws ServletException {
        scoreDao = ScoreDao.instance();
        try {
            messageFactory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
        } catch (SOAPException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        System.out.println(request.getRequestURL());
        String sid =  request.getParameter("sid");
        List<ScoreEntity> entities = scoreDao.getScoresByStudentId(Integer.parseInt(sid));
        try {
            SOAPMessage message = messageFactory.createMessage();
            SOAPPart soapPart = message.getSOAPPart();
            SOAPEnvelope soapEnvelope = soapPart.getEnvelope();
            soapEnvelope.addNamespaceDeclaration("xsd","http://www.w3.org/2001/XMLSchema");
            soapEnvelope.addNamespaceDeclaration("my","http://www.example.com/");
            //header
            SOAPHeader soapHeader = soapEnvelope.getHeader();
            SOAPElement headelement = soapHeader.addChildElement(soapEnvelope.createName("transaction","t","http://thirdparty.example.org/transaction"));
            headelement.addAttribute(soapEnvelope.createQName("encodingStyle","env"),"http://example.com/encoding");
            headelement.addAttribute(soapEnvelope.createQName("role","env"),"http://www.w3.org/2003/05/soap-envelope/role/next");
            headelement.addAttribute(soapEnvelope.createQName("mustUnderstand","env"),"true");

            headelement.addChildElement(headelement.createQName("group","t")).addTextNode("18");
            Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int date = c.get(Calendar.DATE);
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);
            int second = c.get(Calendar.SECOND);
            headelement.addChildElement(headelement.createQName("date","t")).addTextNode(year + "/" + month + "/" + date + " " +hour + ":" +minute + ":" + second);

            SOAPBody soapBody = soapEnvelope.getBody();
            if (entities.size()>0) {
                SOAPElement element = soapBody.addChildElement(soapEnvelope.createName("课程成绩列表","jw","http://jw.nju.edu.cn/schema"));
                for (ScoreEntity entity: entities) {
                    SOAPElement courseElement = element.addChildElement(element.createQName("课程成绩","jw"));
                    courseElement.addAttribute(element.createQName("成绩性质","jw"),
                            entity.getEntity().getType());
                    courseElement.addAttribute(element.createQName("课程编号","jw"),
                            entity.getEntity().getCid()+"");
                    courseElement.addChildElement(courseElement.createQName("学号","jw"))
                            .addTextNode(entity.getSid()+"");
                    courseElement.addChildElement(courseElement.createQName("成绩","jw"))
                            .addTextNode(entity.getScore().toString());
                }
            } else {
                SOAPFault fault = soapBody.addFault();
                fault.setFaultCode("env:Receiver");
                QName subcode = soapEnvelope.createQName("bad argument","my");
                fault.appendFaultSubcode(subcode);
                fault.addFaultReasonText("no such sid found in score list:"+sid, Locale.ENGLISH);
                fault.addFaultReasonText("成绩单中无此学号："+sid,Locale.CHINESE);
                Detail detail = fault.addDetail();
                detail.addChildElement(soapEnvelope.createQName("adivce","my")).addTextNode("请确认输入的学号为9位，且合法。");
            }
            message.saveChanges();
            response.setStatus(HttpServletResponse.SC_OK);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            message.writeTo(stream);
            String messageStr = new String(stream.toByteArray(), "utf-8");
            System.out.println(messageStr);
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-type","text/xml;charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(messageStr);
        } catch (SOAPException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
