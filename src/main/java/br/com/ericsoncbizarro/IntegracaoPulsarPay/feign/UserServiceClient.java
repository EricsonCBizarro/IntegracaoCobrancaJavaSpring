package br.com.ericsoncbizarro.IntegracaoPulsarPay.feign;

import br.com.ericsoncbizarro.IntegracaoPulsarPay.model.modelPulsarPay.User;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url="https://api-sandbox.pulsarpay.com/api/", name = "userLogin")
public interface UserServiceClient {

    @PostMapping("/usuario/login")
    @Headers({"Content-Type: application/json","Accept: application/json","Cache-Control: no-cache"})
    User login(@RequestBody UserDTO loginParam);
}