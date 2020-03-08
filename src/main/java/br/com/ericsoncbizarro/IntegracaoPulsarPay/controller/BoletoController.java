package br.com.ericsoncbizarro.IntegracaoPulsarPay.controller;

import br.com.ericsoncbizarro.IntegracaoPulsarPay.feign.BoletoOutputDTO;
import br.com.ericsoncbizarro.IntegracaoPulsarPay.model.modelPulsarPay.Boleto;
import br.com.ericsoncbizarro.IntegracaoPulsarPay.services.BoletoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@RestController
@RequestMapping("/boleto")
public class BoletoController {

    @Autowired
    private BoletoService boletoService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Boleto> findAll() throws Exception {
        // @TODO nome da classe em PT-BR, nome dos métodos em inglês. sugiro padronizar
        return boletoService.findAll();
    }

    @PostMapping( produces = MediaType.APPLICATION_JSON_VALUE,
                  consumes = MediaType.APPLICATION_JSON_VALUE)
    public BoletoOutputDTO create(@RequestBody Boleto boleto) throws Exception {
        // @TODO nome da classe em PT-BR, nome dos métodos em inglês. sugiro padronizar
        return boletoService.create(boleto);
    }

}