package com.spring.srrs.client;

import com.spring.srrs.entity.Greeting;
import reactor.core.publisher.Mono;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class GreetingClient {

    private final WebClient client;

    public GreetingClient(WebClient.Builder builder) {
        this.client = builder.baseUrl("http://localhost:8080").build();
    }

    public Mono<String> getMessage() {
        return this.client.get().uri("/message").accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Greeting.class)
                .map(Greeting::getMessage);
    }

}