package br.com.ericsoncbizarro.Integracao.cobranca.services;

import br.com.ericsoncbizarro.Integracao.cobranca.model.modelPulsarPay.Cliente;

import java.util.List;

public interface HttpPulsarPayCliente {

    List<Cliente> getClientes() throws Exception;
    List<Cliente> postCliente(Cliente clienteBody) throws Exception;
}
