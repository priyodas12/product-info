package io.microservicelab.productinfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/product-info")
public class GenericController {

    @Value("${spring.application.name}")
    String applicationName;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/ping")
    public String pingProductInfoService(){
        return "200 OK from "+applicationName;
    }

    @GetMapping("/ping/payment-service")
    public String pingGatewayService(){

        String url="http://EUREKA-CLIENT-PAYMENT-GATEWAY/payment-gateway/ping";

        return restTemplate.getForObject(url,String.class);
    }
}
