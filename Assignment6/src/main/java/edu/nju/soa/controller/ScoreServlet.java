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
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

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
            messageFactory = MessageFactory.newInstance();
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
        String sid =  "";
        MimeHeaders headers = new MimeHeaders();
        try {
            InputStream inputStream = request.getInputStream();
            SOAPMessage message = messageFactory.createMessage(headers,inputStream);
            SOAPBody soapBody = message.getSOAPBody();
            Iterator iterator = soapBody.getChildElements();
            SOAPElement element = (SOAPElement) iterator.next();
            sid = element.getTextContent();
            System.out.println(sid);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SOAPException e) {
            e.printStackTrace();
        }
        generateResult(response,sid);
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

    private String generateMsg(String sid) {
        List<ScoreEntity> entities = scoreDao.getScoresByStudentId(Integer.parseInt(sid));
        try {
            SOAPMessage message = messageFactory.createMessage();
            SOAPPart soapPart = message.getSOAPPart();
            SOAPEnvelope soapEnvelope = soapPart.getEnvelope();
            soapEnvelope.addNamespaceDeclaration("xsd","http://www.w3.org/2001/XMLSchema");
            SOAPBody soapBody = soapEnvelope.getBody();
            if (entities.size()>0) {
                SOAPElement element = soapBody.addChildElement(soapEnvelope.createName("课程成绩列表","jw","http://jw.nju.edu.cn/schema"));
                for (ScoreEntity entity: entities) {
                    SOAPElement courseElement = element.addChildElement(element.createQName("课程成绩","jw"));
                    courseElement.addAttribute(element.createQName("成绩性质","jw"),
                            entity.getEntity().getType().toString());
                    courseElement.addAttribute(element.createQName("课程编号","jw"),
                            entity.getEntity().getCid()+"");
                    courseElement.addChildElement(courseElement.createQName("学号","jw"))
                            .addTextNode(entity.getSid()+"");
                    courseElement.addChildElement(courseElement.createQName("成绩","jw"))
                            .addTextNode(entity.getScore().toString());
                }
            } else {
                SOAPFault fault = soapBody.addFault();
                QName faultName = new QName(SOAPConstants.URI_NS_SOAP_ENVELOPE, "Server");
                fault.setFaultCode(faultName);
                fault.setFaultString("Cannot find any score for student id:"+sid);
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
