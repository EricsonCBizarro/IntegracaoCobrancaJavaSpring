package br.com.ericsoncbizarro.Integracao.cobranca.controller;

import br.com.ericsoncbizarro.Integracao.cobranca.model.modelPulsarPay.Carteira;
import br.com.ericsoncbizarro.Integracao.cobranca.services.CarteiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/carteira")
public class CarteiraController {

    @Autowired
    private CarteiraService carteiraService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Carteira> findAll() throws Exception {
        // @TODO nome da classe em PT-BR, nome dos métodos em inglês. sugiro padronizar
        return carteiraService.findAll();
    }


}
