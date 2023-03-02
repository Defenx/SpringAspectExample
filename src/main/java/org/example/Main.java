package org.example;

import org.example.service.HumanService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("org.example");

        var bean = applicationContext.getBean(HumanService.class);
        bean.findHumansByAge(25);
        bean.findHumansByName("Roma");
    }
}