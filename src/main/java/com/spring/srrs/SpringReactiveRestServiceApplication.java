package com.spring.srrs;

import com.spring.srrs.client.GreetingClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringReactiveRestServiceApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringReactiveRestServiceApplication.class, args);
        GreetingClient greetingClient = context.getBean(GreetingClient.class);
        System.out.println(">> message = " + greetingClient.getMessage().block());
    }

}
