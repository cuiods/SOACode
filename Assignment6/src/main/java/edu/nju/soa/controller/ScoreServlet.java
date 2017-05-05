package edu.nju.soa.controller;

import edu.nju.soa.dao.ScoreDao;
import edu.nju.soa.entity.ScoreEntity;
import edu.nju.soa.tool.EditScore;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;
import javax.xml.soap.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

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
        String sid =  request.getParameter("sid");
        generateResult(response,sid);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        MimeHeaders headers = new MimeHeaders();
        List<EditScore> scoreList = new ArrayList<EditScore>();
        try {
            InputStream inputStream = request.getInputStream();
            SOAPMessage message = messageFactory.createMessage(headers,inputStream);
            SOAPBody soapBody = message.getSOAPBody();
            Iterator iterator = soapBody.getChildElements();
            SOAPElement element = (SOAPElement) iterator.next();
            Iterator dataIterator = element.getChildElements();
            while (dataIterator.hasNext()) {
                SOAPElement soapElement = (SOAPElement) dataIterator.next();
                String courseType = soapElement.getAttribute("jw:成绩性质");
                String cid = soapElement.getAttribute("jw:课程编号");
                SOAPElement scoreElement = (SOAPElement) soapElement.getChildElements().next();
                String sid = scoreElement.getFirstChild().getTextContent();
                String score = scoreElement.getLastChild().getTextContent();
                EditScore editScore = new EditScore(Integer.parseInt(sid),Integer.parseInt(cid),courseType,Integer.parseInt(score));
                scoreList.add(editScore);
            }
            for (EditScore editScore: scoreList) {
                String msg = scoreDao.update(editScore);
                if (!msg.equals("")) {
                    generateFault(response, msg);
                    return;
                }
            }
            generateMsg(response,message);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SOAPException e) {
            e.printStackTrace();
        }
    }

    private void generateFault(HttpServletResponse response, String msg) {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-type","text/xml;charset=UTF-8");
        PrintWriter writer;
        try {
            response.setStatus(HttpServletResponse.SC_OK);
            writer = response.getWriter();
            writer.print(generateFaultMsg(msg));
        } catch (IOException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }
    }

    private void generateMsg(HttpServletResponse response, SOAPMessage message) {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-type","text/xml;charset=UTF-8");
        PrintWriter writer;
        try {
            SOAPPart soapPart = message.getSOAPPart();
            SOAPEnvelope soapEnvelope = soapPart.getEnvelope();
            soapEnvelope.addNamespaceDeclaration("xsd","http://www.w3.org/2001/XMLSchema");
            soapEnvelope.addNamespaceDeclaration("my","http://www.example.com/");
            //header
            SOAPHeader soapHeader = soapEnvelope.getHeader();
            SOAPElement headelement = soapHeader.addChildElement(soapEnvelope.createName("transaction","t","http://thirdparty.example.org/transaction")).addTextNode("5");
            headelement.addAttribute(soapEnvelope.createQName("encodingStyle","env"),"http://www.w3.org/2001/12/soap-encoding");
            headelement.addAttribute(soapEnvelope.createQName("mustUnderstand","env"),"false");

            SOAPElement security = soapHeader.addChildElement(soapEnvelope.createName("Security","s","http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd"));
            security.addAttribute(soapEnvelope.createQName("mustUnderstand","env"),"true");
            SOAPElement name = security.addChildElement(security.createQName("UsernameToken","s"));
            name.addChildElement(name.createQName("Username","s")).addTextNode("UserName");
            name.addChildElement(name.createQName("Password","s")).addTextNode("Password");
            response.setStatus(HttpServletResponse.SC_OK);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            message.writeTo(stream);
            String result =  new String(stream.toByteArray(), "utf-8");
            writer = response.getWriter();
            writer.print(result);
        } catch (IOException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        } catch (SOAPException e) {
            e.printStackTrace();
        }
    }

    private void generateResult(HttpServletResponse response, String sid) {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-type","text/xml;charset=UTF-8");
        PrintWriter writer;
        try {
            response.setStatus(HttpServletResponse.SC_OK);
            writer = response.getWriter();
            writer.print(generateMsg(sid));
        } catch (IOException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }
    }

    private String generateFaultMsg(String msg) {
        try {
            SOAPMessage message = messageFactory.createMessage();
            SOAPPart soapPart = message.getSOAPPart();
            SOAPEnvelope soapEnvelope = soapPart.getEnvelope();
            soapEnvelope.addNamespaceDeclaration("xsd","http://www.w3.org/2001/XMLSchema");
            soapEnvelope.addNamespaceDeclaration("my","http://www.example.com/");
            //header
            SOAPHeader soapHeader = soapEnvelope.getHeader();
            SOAPElement headelement = soapHeader.addChildElement(soapEnvelope.createName("transaction","t","http://thirdparty.example.org/transaction")).addTextNode("5");
            headelement.addAttribute(soapEnvelope.createQName("encodingStyle","env"),"http://www.w3.org/2001/12/soap-encoding");
            headelement.addAttribute(soapEnvelope.createQName("mustUnderstand","env"),"false");

            SOAPElement security = soapHeader.addChildElement(soapEnvelope.createName("Security","s","http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd"));
            security.addAttribute(soapEnvelope.createQName("mustUnderstand","env"),"true");
            SOAPElement name = security.addChildElement(security.createQName("UsernameToken","s"));
            name.addChildElement(name.createQName("Username","s")).addTextNode("UserName");
            name.addChildElement(name.createQName("Password","s")).addTextNode("Password");

            SOAPBody soapBody = soapEnvelope.getBody();
            SOAPFault fault = soapBody.addFault();
            fault.setFaultCode("env:Receiver");
            QName subcode = soapEnvelope.createQName("bad argument","my");
            fault.appendFaultSubcode(subcode);
            fault.addFaultReasonText("未找到："+msg,Locale.CHINESE);
            Detail detail = fault.addDetail();
            detail.addChildElement(soapEnvelope.createQName("adivce","my")).addTextNode("请确认输入的学号和课程编号存在");
            message.saveChanges();
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            message.writeTo(stream);
            return new String(stream.toByteArray(), "utf-8");
        } catch (SOAPException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    private String generateMsg(String sid) {
        List<ScoreEntity> entities = scoreDao.getScoresByStudentId(Integer.parseInt(sid));
        try {
            SOAPMessage message = messageFactory.createMessage();
            SOAPPart soapPart = message.getSOAPPart();
            SOAPEnvelope soapEnvelope = soapPart.getEnvelope();
            soapEnvelope.addNamespaceDeclaration("xsd","http://www.w3.org/2001/XMLSchema");
            soapEnvelope.addNamespaceDeclaration("my","http://www.example.com/");
            //header
            SOAPHeader soapHeader = soapEnvelope.getHeader();
            SOAPElement headelement = soapHeader.addChildElement(soapEnvelope.createName("transaction","t","http://thirdparty.example.org/transaction")).addTextNode("5");
            headelement.addAttribute(soapEnvelope.createQName("encodingStyle","env"),"http://www.w3.org/2001/12/soap-encoding");
            headelement.addAttribute(soapEnvelope.createQName("mustUnderstand","env"),"false");

            SOAPElement security = soapHeader.addChildElement(soapEnvelope.createName("Security","s","http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd"));
            security.addAttribute(soapEnvelope.createQName("mustUnderstand","env"),"true");
            SOAPElement name = security.addChildElement(security.createQName("UsernameToken","s"));
            name.addChildElement(name.createQName("Username","s")).addTextNode("UserName");
            name.addChildElement(name.createQName("Password","s")).addTextNode("Password");

            SOAPBody soapBody = soapEnvelope.getBody();
            if (entities.size()>0) {
                SOAPElement element = soapBody.addChildElement(soapEnvelope.createName("课程成绩列表","jw","http://jw.nju.edu.cn/schema"));
                for (ScoreEntity entity: entities) {
                    SOAPElement courseElement = element.addChildElement(element.createQName("课程成绩","jw"));
                    courseElement.addAttribute(element.createQName("成绩性质","jw"),
                            entity.getEntity().getType());
                    courseElement.addAttribute(element.createQName("课程编号","jw"),
                            entity.getEntity().getCid()+"");
                    SOAPElement scoreElement = courseElement.addChildElement(courseElement.createQName("成绩","jw"));
                    scoreElement.addChildElement(scoreElement.createQName("学号","jw"))
                            .addTextNode(entity.getSid()+"");
                    scoreElement.addChildElement(scoreElement.createQName("得分","jw"))
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
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            message.writeTo(stream);
            return new String(stream.toByteArray(), "utf-8");
        } catch (SOAPException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
