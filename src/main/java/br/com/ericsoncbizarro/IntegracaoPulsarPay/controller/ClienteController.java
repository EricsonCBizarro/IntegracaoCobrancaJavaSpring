package br.com.ericsoncbizarro.IntegracaoPulsarPay.controller;

import br.com.ericsoncbizarro.IntegracaoPulsarPay.model.modelPulsarPay.Cliente;
import br.com.ericsoncbizarro.IntegracaoPulsarPay.services.ClienteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteServices services;

    @RequestMapping
            (
                    method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE
            )
    public List<Cliente> findAll() throws Exception {
        return services.findAll();
    }

    @RequestMapping
            (
                    method = RequestMethod.POST,
                    produces = MediaType.APPLICATION_JSON_VALUE,
                    consumes = MediaType.APPLICATION_JSON_VALUE
            )
    public Cliente create() throws Exception {
        return services.create();
    }

}
