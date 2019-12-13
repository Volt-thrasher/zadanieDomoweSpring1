package org.javastart.zajecia1012;

import org.javastart.zajecia1012.controller.spring.zadanie2.TestControllerZ2;
import org.javastart.zajecia1012.controller.spring.zadanie2.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Zajecia1012Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Zajecia1012Application.class, args);
        //TestConnector bean = context.getBean(TestConnector.class);
        //bean.saveToDatabase();
    }

}
