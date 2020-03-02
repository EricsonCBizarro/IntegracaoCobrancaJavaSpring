package br.com.ericsoncbizarro.Integracao.cobranca.services;

import br.com.ericsoncbizarro.Integracao.cobranca.model.modelPulsarPay.Cliente;
import java.util.List;

public interface ClienteService {

    List<Cliente> findAll() throws Exception;
    List<Cliente> create(Cliente clienteRequestBody) throws Exception;

}