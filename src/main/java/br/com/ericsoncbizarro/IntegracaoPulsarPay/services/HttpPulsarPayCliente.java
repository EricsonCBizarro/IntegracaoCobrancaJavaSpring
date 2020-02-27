package br.com.ericsoncbizarro.IntegracaoPulsarPay.services;

import br.com.ericsoncbizarro.IntegracaoPulsarPay.model.modelPulsarPay.Cliente;
import java.util.List;

public interface HttpPulsarPayCliente {

    List<Cliente> getClientes() throws Exception;
    List<Cliente> postCliente(Cliente clienteBody) throws Exception;
}
