package edu.nju.soa.client;

import edu.nju.soa.resolver.DefaultResolver;
import service.*;

/**
 * Created by cuihao on 2017-06-26.
 * Client
 */
public class SoaClient {

    public static void main(String[] args) {
        MyService myService = new MyService();
        myService.setHandlerResolver(new DefaultResolver());
        HelloServiceInterface helloServiceInterface = myService.getHelloServicePort();
        Login login = new Login();
        login.setLoginUsername("141250019@smail.nju.edu.cn");
        login.setLoginPassword("123456");
        try {
            LoginResponse response = helloServiceInterface.login(login);
            System.out.println(response.getLoginResults().getKind());
        } catch (LoginException e) {
            System.out.println(e.getFaultInfo());
        }
    }

}
