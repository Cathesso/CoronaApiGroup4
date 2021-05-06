package de.neuefische.coronaapigroup4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CoronaApiGroup4Application {

    public static void main(String[] args) {
        SpringApplication.run(CoronaApiGroup4Application.class, args);
    }

    @Bean
    public RestTemplate createRestTemplate(){
        return new RestTemplate();
    }
}
