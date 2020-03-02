package br.com.ericsoncbizarro.Integracao.cobranca.services;

import br.com.ericsoncbizarro.Integracao.cobranca.model.modelPulsarPay.Boleto;

import java.util.List;

public interface HttpPulsarPayBoleto {

    List<Boleto> getBoletos() throws Exception;
    List<Boleto> postBoleto(Boleto boletoBody) throws Exception;
}
