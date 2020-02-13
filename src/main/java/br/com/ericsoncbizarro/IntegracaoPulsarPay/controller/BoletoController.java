package br.com.ericsoncbizarro.IntegracaoPulsarPay.controller;

import br.com.ericsoncbizarro.IntegracaoPulsarPay.model.modelPulsarPay.Boleto;
import br.com.ericsoncbizarro.IntegracaoPulsarPay.model.modelPulsarPay.Cliente;
import br.com.ericsoncbizarro.IntegracaoPulsarPay.services.BoletoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/boleto")
public class BoletoController {

    @Autowired
    BoletoService services;

    @RequestMapping
            (
                    method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE
            )
    public List<Boleto> findAll() throws Exception {
        return services.findAll();
    }

    @RequestMapping
            (
                    method = RequestMethod.POST,
                    produces = MediaType.APPLICATION_JSON_VALUE,
                    consumes = MediaType.APPLICATION_JSON_VALUE
            )
    public List<Boleto> create(@RequestBody Boleto boleto) throws Exception {
        return services.create(boleto);
    }

}
