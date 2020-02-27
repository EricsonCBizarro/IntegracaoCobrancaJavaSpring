package br.com.ericsoncbizarro.IntegracaoPulsarPay.services;

import br.com.ericsoncbizarro.IntegracaoPulsarPay.model.modelPulsarPay.Cliente;
import java.util.List;

public interface ClienteService {

    List<Cliente> findAll() throws Exception;
    List<Cliente> create(Cliente clienteRequestBody) throws Exception;

}