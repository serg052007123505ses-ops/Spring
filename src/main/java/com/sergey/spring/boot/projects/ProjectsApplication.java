package com.sergey.spring.boot.projects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
public class ProjectsApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ProjectsApplication.class);
        app.setDefaultProperties(Map.of(
                "server.port", getPortFromArgs(args)
        ));
        app.run(args);
    }

    private static String getPortFromArgs(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if ("--port".equals(args[i]) && i + 1 < args.length) {
                return args[i + 1];
            }
        }
        return "8080";
    }

}
