package br.com.ericsoncbizarro.IntegracaoPulsarPay.controller;

import br.com.ericsoncbizarro.IntegracaoPulsarPay.model.modelPulsarPay.Produto;
import br.com.ericsoncbizarro.IntegracaoPulsarPay.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService services;

    @RequestMapping
            (
                    method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE
            )
    public List<Produto> findAll() throws Exception {
        return services.findAll();
    }

}
