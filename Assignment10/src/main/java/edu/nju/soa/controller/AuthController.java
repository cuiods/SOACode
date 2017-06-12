package edu.nju.soa.controller;

import edu.nju.soa.definition.MyAuth;
import edu.nju.soa.schema.tns.AuthVerifyType;
import edu.nju.soa.schema.tns.IdNotFoundException;
import edu.nju.soa.schema.tns.PswErrorException;
import edu.nju.soa.schema.tns.VerifyType;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by cuihao on 2017-06-12.
 * Auth Service impl
 */
@WebService(name = "MyAuth", targetNamespace = "http://jw.nju.edu.cn/schema")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public class AuthController implements MyAuth {
    /**
     * Auth controller
     *
     * @param parameters {@link AuthVerifyType}
     * @return returns cn.edu.nju.jw.schema.VerifyType
     * @throws IdNotFoundException {@link IdNotFoundException} cannot find id
     * @throws PswErrorException   {@link PswErrorException} password error
     */
    @Override
    public VerifyType verify(AuthVerifyType parameters) throws IdNotFoundException, PswErrorException {
        return null;
    }
}
