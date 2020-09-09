package br.com.ericsoncbizarro.IntegracaoPulsarPay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class IntegracaoPulsarPay {

    public static void main(String[] args) {
        SpringApplication.run(IntegracaoPulsarPay.class, args);
    }
}