package edu.nju.soa.handler;

import cn.edu.nju.jw.wsdl.StudentInfoService;
import cn.edu.nju.jw.wsdl.StudentInfoServiceImplService;
import cn.edu.nju.jw.wsdl.*;
import edu.nju.soa.resolver.DefaultResolver;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPException;
import javax.xml.ws.Holder;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by cuihao on 2017-06-28.
 * modify student info
 */
public class StudentModifyHandler implements SOAPHandler<SOAPMessageContext> {
    @Override
    public Set<QName> getHeaders() {
        return null;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        if (!(Boolean) context.get(SOAPMessageContext.MESSAGE_OUTBOUND_PROPERTY)) {
            StudentInfoServiceImplService serviceImplService = new StudentInfoServiceImplService();
            serviceImplService.setHandlerResolver(new DefaultResolver());
            StudentInfoService service = serviceImplService.getStudentInfoServicePort();
            try {
                SOAPBody soapBody = context.getMessage().getSOAPBody();
                Node courseScoreList = soapBody.getFirstChild();
                NodeList courseScores = courseScoreList.getChildNodes();
                for (int i = 0; i < courseScores.getLength(); i++) {
                    Node courseScore = courseScores.item(i);
                    String cid = courseScore.getAttributes().getNamedItem("课程编号").getTextContent();
                    String ctype = courseScore.getAttributes().getNamedItem("成绩性质").getTextContent();
                    NodeList scores = courseScore.getChildNodes();
                    for (int j = 0; j < scores.getLength(); j++) {
                        Node score = scores.item(j);
                        String sid = score.getChildNodes().item(0).getTextContent();
                        String scoreStr = score.getChildNodes().item(1).getTextContent();
                        课程成绩类型 courseScoreType = new 课程成绩类型();
                        courseScoreType.set课程编号(cid);
                        courseScoreType.set成绩性质(成绩性质类型.fromValue(ctype));
                        List<成绩类型> scoreTypes = new ArrayList<>();
                        成绩类型 scoreType = new 成绩类型();
                        scoreType.set学号(sid);
                        scoreType.set得分(Integer.parseInt(scoreStr));
                        scoreTypes.add(scoreType);
                        courseScoreType.set成绩(scoreTypes);
                        学生信息 studentInfo = packageStudentInfo(service.queryInfo(sid),courseScoreType);
                        service.modifyInfo(new Holder<>(studentInfo));
                    }
                }
            } catch (SOAPException | DataFormatError e) {
                e.printStackTrace();
                return false;
            } catch (InvalidStudentId invalidStudentId) {
                invalidStudentId.printStackTrace();
            }
        }
        return true;
    }

    private 学生信息 packageStudentInfo(学生信息 studentInfo, 课程成绩类型 courseScoreType) {
        List<课程成绩类型> courseScoreTypes = studentInfo.get课程成绩列表().get课程成绩();
        for (int i = 0; i < courseScoreTypes.size(); i++) {
            课程成绩类型 courseScore = courseScoreTypes.get(i);
            if (courseScore.get课程编号().equals(courseScoreType.get课程编号())
                    && courseScore.get成绩性质().equals(courseScoreType.get成绩性质())) {
                courseScoreTypes.set(i,courseScoreType);
                return studentInfo;
            }
        }
        courseScoreTypes.add(courseScoreType);
        return studentInfo;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        return true;
    }

    @Override
    public void close(MessageContext context) {

    }
}
