package com.codenation.aceleradev;

import java.util.Collections;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaAuditing
@EnableSwagger2
public class AceleradevApplication {

    public static void main(String[] args) {
        SpringApplication.run(AceleradevApplication.class, args);
    }

    @Api(value = "Docs", description = "API Launched and Documentation avaliable")
    @RestController
    @RequestMapping(path = "/")
    class Docs {

        @ApiOperation(value = "Link to Documentation API")
        @GetMapping
        public Map<String, String> docs() {
            return Collections.singletonMap("Docs", "https://log-center.herokuapp.com/swagger-ui.html");
        }

    }

}
