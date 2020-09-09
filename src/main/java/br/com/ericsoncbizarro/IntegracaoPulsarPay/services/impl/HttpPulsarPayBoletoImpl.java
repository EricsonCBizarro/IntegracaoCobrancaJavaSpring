package br.com.ericsoncbizarro.IntegracaoPulsarPay.services.impl;

import br.com.ericsoncbizarro.IntegracaoPulsarPay.exception.BadRequestHttpPulsarPayException;
import br.com.ericsoncbizarro.IntegracaoPulsarPay.feign.*;
import br.com.ericsoncbizarro.IntegracaoPulsarPay.model.modelPulsarPay.Boleto;
import br.com.ericsoncbizarro.IntegracaoPulsarPay.model.modelPulsarPay.User;
import br.com.ericsoncbizarro.IntegracaoPulsarPay.services.HttpPulsarPayService;
import br.com.ericsoncbizarro.IntegracaoPulsarPay.services.HttpPulsarPayBoleto;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HttpPulsarPayBoletoImpl implements HttpPulsarPayBoleto {

    @Autowired
    HttpPulsarPayService httpPulsarPayService;

    @Autowired
    UserServiceClient userServiceClient;

    @Autowired
    BoletoServiceClient boletoServiceClient;

    public List<Boleto> getBoletos() throws Exception {

        try {
                UserDTO userLoginParam = new UserDTO(">QcU]W0a!!{}7ZPeLYzbstBC!vwg+VgfuTqVwm3J", "123456");
                User retornoFeignCliente = userServiceClient.login(userLoginParam);
                BoletoDTO boletoDTO = boletoServiceClient.findAll("Bearer " + retornoFeignCliente.getToken());
                return boletoDTO.getData();
        } catch (Exception e) {
            throw new BadRequestHttpPulsarPayException("Critical Error.");
        }
    }

    public BoletoOutputDTO postBoleto(Boleto boletoBody) throws Exception {


        try {
            UserDTO userLoginParam = new UserDTO(">QcU]W0a!!{}7ZPeLYzbstBC!vwg+VgfuTqVwm3J", "123456");
            User retornoFeignCliente = userServiceClient.login(userLoginParam);
            BoletoInputDTO newBoleto = new BoletoInputDTO();
            Map<String, Object> parametros = new HashMap();
            parametros.put("valor_total", boletoBody.getValor_total());
            // @TODO a data de vencimento nao pode passar de 3 meses... que tal validar isso? e que tal adicionar um teste unitario para isso?
            parametros.put("vencimento", boletoBody.getVencimento());
            newBoleto.setBoleto(parametros);
            newBoleto.setDocumento(boletoBody.getDocumento());
            newBoleto.setData_nascimento(boletoBody.getData_nascimento());
            BoletoOutputDTO boletoDTO = boletoServiceClient.create("Bearer " + retornoFeignCliente.getToken(), newBoleto);
            return boletoDTO;
        } catch (Exception e) {
            throw new BadRequestHttpPulsarPayException("Critical Error.");
        }
    }

    private Boleto deserializePostBoleto(JSONObject objJSON) throws Exception {
        Boleto boleto = new Boleto();

        boleto.setNosso_numero(objJSON.getString("nosso_numero"));

        return boleto;
    }
}
