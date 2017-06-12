package edu.nju.soa;

import edu.nju.soa.controller.AuthController;
import edu.nju.soa.controller.ScoreController;
import edu.nju.soa.controller.StudentController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.ws.Endpoint;

/**
 * Created by cuihao on 2017-06-11.
 * Main entrance of student manage application
 */
@SpringBootApplication
public class StudentApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentApplication.class, args);
        new StudentApplication().run();
    }

    private void run() {
        Endpoint.publish("/auth", new AuthController());
        Endpoint.publish("/score", new ScoreController());
        Endpoint.publish("/student", new StudentController());
    }

}
