package edu.nju.soa.client;

import cn.edu.nju.jw.wsdl.*;
import com.sun.xml.ws.api.message.Headers;
import com.sun.xml.ws.developer.WSBindingProvider;
import edu.nju.soa.resolver.ComplexResolver;
import edu.nju.soa.resolver.SimpleResolver;
import edu.nju.soa.tools.WsdlUrl;

import javax.xml.namespace.QName;
import javax.xml.ws.Holder;

/**
 * Created by cuihao on 2017-06-27.
 *
 */
public class ScoreService {

    //teacher@nju.edu.cn
    //MF121250001@smail.nju.edu.cn
    //MG111250001@smail.nju.edu.cn
    public void addScore(课程成绩列表类型 listType, String email, String password) {
        ScoreManageServiceImplService service = new ScoreManageServiceImplService();
        service.setHandlerResolver(new ComplexResolver());
        ScoreManageService scoreManageService = service.getScoreManageServicePort();
        WSBindingProvider bp = (WSBindingProvider)scoreManageService;
        bp.setOutboundHeaders(Headers.create(new QName(WsdlUrl.AUTH_NS,"email"),email),
                Headers.create(new QName(WsdlUrl.AUTH_NS,"password"),password));
        Holder<课程成绩列表类型> param = new Holder<>(listType);
        try {
            scoreManageService.addGrade(param);
        } catch (InvalidCourseId | InvalidStudentId | InvalidScore invalidCourseId) {
            invalidCourseId.printStackTrace();
        }
    }

    public void deleteScore(学号课程号类型 scoreCourse, String email, String password) {
        ScoreManageServiceImplService service = new ScoreManageServiceImplService();
        service.setHandlerResolver(new ComplexResolver());
        ScoreManageService scoreManageService = service.getScoreManageServicePort();
        WSBindingProvider bp = (WSBindingProvider)scoreManageService;
        bp.setOutboundHeaders(Headers.create(new QName(WsdlUrl.AUTH_NS,"email"),email),
                Headers.create(new QName(WsdlUrl.AUTH_NS,"password"),password));
        try {
            scoreManageService.deleteGrade(scoreCourse);
        } catch (InvalidCourseId | InvalidStudentId invalidCourseId) {
            invalidCourseId.printStackTrace();
        }
    }

    public void queryScore(String sid, String email, String password) {
        ScoreManageServiceImplService service = new ScoreManageServiceImplService();
        service.setHandlerResolver(new SimpleResolver());
        ScoreManageService scoreManageService = service.getScoreManageServicePort();
        WSBindingProvider bp = (WSBindingProvider)scoreManageService;
        bp.setOutboundHeaders(Headers.create(new QName(WsdlUrl.AUTH_NS,"email"),email),
                Headers.create(new QName(WsdlUrl.AUTH_NS,"password"),password));
        try {
            scoreManageService.queryGrade(sid);
        } catch (InvalidStudentId invalidStudentId) {
            invalidStudentId.printStackTrace();
        }
    }

    public void modifyScore(课程成绩类型 courseScore, String email, String password) {
        ScoreManageServiceImplService service = new ScoreManageServiceImplService();
        service.setHandlerResolver(new ComplexResolver());
        ScoreManageService scoreManageService = service.getScoreManageServicePort();
        WSBindingProvider bp = (WSBindingProvider)scoreManageService;
        bp.setOutboundHeaders(Headers.create(new QName(WsdlUrl.AUTH_NS,"email"),email),
                Headers.create(new QName(WsdlUrl.AUTH_NS,"password"),password));
        try {
            scoreManageService.modifyGrade(courseScore);
        } catch (InvalidCourseId | InvalidStudentId | InvalidScore invalidCourseId) {
            invalidCourseId.printStackTrace();
        }
    }

}
