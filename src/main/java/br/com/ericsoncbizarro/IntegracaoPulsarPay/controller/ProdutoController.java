package br.com.ericsoncbizarro.IntegracaoPulsarPay.controller;

import br.com.ericsoncbizarro.IntegracaoPulsarPay.model.modelPulsarPay.Produto;
import br.com.ericsoncbizarro.IntegracaoPulsarPay.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping ( produces = MediaType.APPLICATION_JSON_VALUE )
    public List<Produto> findAll() throws Exception {
        // @TODO nome da classe em PT-BR, nome dos métodos em inglês. sugiro padronizar
        return produtoService.findAll();
    }

    @PostMapping ( produces = MediaType.APPLICATION_JSON_VALUE,
                    consumes = MediaType.APPLICATION_JSON_VALUE )
    public List<Produto> create(@RequestBody Produto produto) throws Exception {
        // @TODO nome da classe em PT-BR, nome dos métodos em inglês. sugiro padronizar
        return produtoService.create(produto);
    }
}