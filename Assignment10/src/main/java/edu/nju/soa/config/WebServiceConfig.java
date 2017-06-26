package edu.nju.soa.config;

import com.google.common.collect.Lists;
import edu.nju.soa.controller.AuthController;
import edu.nju.soa.controller.ScoreController;
import edu.nju.soa.controller.StudentController;
import edu.nju.soa.handler.AuthHandler;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.xml.ws.Endpoint;

/**
 * Created by cuihao on 2017-06-12.
 * Web controller config
 */

@Configuration
public class WebServiceConfig {

    @Resource
    private AuthController authController;

    @Resource
    private ScoreController scoreController;

    @Resource
    private StudentController studentController;

    @Resource
    private AuthHandler authHandler;

    @Bean
    public ServletRegistrationBean dispatcherServlet() {
        return new ServletRegistrationBean(new CXFServlet(), "/soap-api/*");
    }

    @Bean(name= Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean(name = "authEndpoint")
    public Endpoint endpoint1() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), authController);
        endpoint.publish("/auth");
        return endpoint;
    }

    @Bean(name = "scoreEndpoint")
    public Endpoint endpoint2() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), scoreController);
        endpoint.setHandlers(Lists.newArrayList(authHandler));
        endpoint.publish("/score");
        return endpoint;
    }

    @Bean(name = "studentEndpoint")
    public Endpoint endpoint3() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), studentController);
        endpoint.setHandlers(Lists.newArrayList(authHandler));
        endpoint.publish("/student");
        return endpoint;
    }
}
