package edu.nju.soa.controller;

import edu.nju.soa.dao.ScoreDao;
import edu.nju.soa.entity.ScoreEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.soap.*;
import java.io.IOException;
import java.util.List;

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
        System.out.println(request.getRequestURL());
        String sid =  request.getParameter("sid");
        List<ScoreEntity> entities = scoreDao.getScoresByStudentId(Integer.parseInt(sid));
        try {
            SOAPMessage message = messageFactory.createMessage();
            SOAPPart soapPart = message.getSOAPPart();
            SOAPEnvelope soapEnvelope = soapPart.getEnvelope();
            soapEnvelope.addNamespaceDeclaration("xsd","http://www.w3.org/2001/XMLSchema");
            SOAPBody soapBody = soapEnvelope.getBody();
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
            message.saveChanges();
            response.setStatus(HttpServletResponse.SC_OK);
            message.writeTo(response.getOutputStream());
        } catch (SOAPException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
