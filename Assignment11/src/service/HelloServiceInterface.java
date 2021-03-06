package service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;

/**
 * This class was generated by Apache CXF 3.1.11
 * 2017-06-26T19:58:16.285+08:00
 * Generated source version: 3.1.11
 * 
 */
@WebService(targetNamespace = "http://service/", name = "HelloServiceInterface")
@XmlSeeAlso({mail.login.ObjectFactory.class, ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface HelloServiceInterface {

    @WebMethod
    @Action(input = "http://service/HelloServiceInterface/loginRequest", output = "http://service/HelloServiceInterface/loginResponse", fault = {@FaultAction(className = LoginException.class, value = "http://service/HelloServiceInterface/login/Fault/LoginException")})
    @WebResult(name = "loginResponse", targetNamespace = "http://service/", partName = "parameters")
    public LoginResponse login(
        @WebParam(partName = "parameters", name = "login", targetNamespace = "http://service/")
        Login parameters
    ) throws LoginException;
}
