package br.com.ericsoncbizarro.Integracao.cobranca.controller;

import br.com.ericsoncbizarro.Integracao.cobranca.model.modelPulsarPay.Cliente;
import br.com.ericsoncbizarro.Integracao.cobranca.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping( produces = MediaType.APPLICATION_JSON_VALUE )
    public List<Cliente> findAll() throws Exception {
        // @TODO nome da classe em PT-BR, nome dos métodos em inglês. sugiro padronizar
        return clienteService.findAll();
    }

    @PostMapping ( produces = MediaType.APPLICATION_JSON_VALUE,
                   consumes = MediaType.APPLICATION_JSON_VALUE )
    public List<Cliente> create(@RequestBody Cliente cliente) throws Exception {
        // @TODO nome da classe em PT-BR, nome dos métodos em inglês. sugiro padronizar
        return clienteService.create(cliente);
    }

}