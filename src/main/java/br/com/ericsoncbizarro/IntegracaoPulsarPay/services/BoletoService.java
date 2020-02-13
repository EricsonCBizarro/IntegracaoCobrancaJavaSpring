package br.com.ericsoncbizarro.IntegracaoPulsarPay.services;

import br.com.ericsoncbizarro.IntegracaoPulsarPay.model.modelPulsarPay.Boleto;
import br.com.ericsoncbizarro.IntegracaoPulsarPay.model.modelPulsarPay.Cliente;
import br.com.ericsoncbizarro.IntegracaoPulsarPay.services.httpPulsarPay.HttpPulsarPay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BoletoService {

    @Autowired
    private HttpPulsarPay httpPulsarPay;

    public List<Boleto> findAll() throws Exception {
        return httpPulsarPay.getBoletos();
    }

    public List<Boleto> create(Boleto boletoRequestBody) throws Exception { // criar um dto para cliente
        Boleto boletoMock = mockBoleto(boletoRequestBody);
        return httpPulsarPay.postBoleto(boletoMock);
    }

    private Boleto mockBoleto(Boleto boletoRequestBody){
        Boleto boletoHttp = new Boleto();
        boletoHttp.setValor_total(boletoRequestBody.getValor_total());
        boletoHttp.setDocumento(boletoRequestBody.getDocumento());
        boletoHttp.setData_nascimento(boletoRequestBody.getData_nascimento());
        boletoHttp.setVencimento(boletoRequestBody.getVencimento());
        return boletoHttp;
    }


}
