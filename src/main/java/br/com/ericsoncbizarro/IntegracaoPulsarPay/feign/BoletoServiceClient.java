package br.com.ericsoncbizarro.IntegracaoPulsarPay.feign;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(url="https://api-sandbox.pulsarpay.com/api", name = "boleto",configuration=BoletoServiceClientConfig.class)
public interface BoletoServiceClient {

    @GetMapping("/boleto/listar")
    @Headers({"Content-Type: application/json","Accept: application/json","Cache-Control: no-cache"})
    BoletoDTO findAll(@RequestHeader("Authorization") String token);

    @PostMapping("/boleto/gerar")
    @Headers({"Content-Type: application/json","Accept: application/json","Cache-Control: no-cache"})
    BoletoOutputDTO create(@RequestHeader("Authorization") String token, @RequestBody BoletoInputDTO input);

}