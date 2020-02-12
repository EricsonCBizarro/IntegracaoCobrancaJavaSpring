package br.com.ericsoncbizarro.IntegracaoPulsarPay.services;

import br.com.ericsoncbizarro.IntegracaoPulsarPay.services.httpPulsarPay.HttpPulsarPay;
import br.com.ericsoncbizarro.IntegracaoPulsarPay.model.modelPulsarPay.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ClienteServices {

    @Autowired
    private HttpPulsarPay httpPulsarPay;

    private final AtomicLong counter = new AtomicLong();

    public List<Cliente> findAll() throws Exception {
        return httpPulsarPay.getClientes();
    }

    public Cliente create() throws Exception {
        Cliente cliente = mockCliente();
        return httpPulsarPay.postCliente(cliente);
    }

    private Cliente mockCliente(){
        Cliente cliente = new Cliente();
        cliente.setControle_externo(counter.incrementAndGet());
        cliente.setNome("Ericson C Bizarro");
        cliente.setDocumento("03253300005");
        cliente.setData_nascimento("1994-06-02");
        return cliente;
    }
}
