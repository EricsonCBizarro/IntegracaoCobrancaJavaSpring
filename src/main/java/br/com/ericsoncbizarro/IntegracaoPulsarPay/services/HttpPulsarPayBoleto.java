package br.com.ericsoncbizarro.IntegracaoPulsarPay.services;

import br.com.ericsoncbizarro.IntegracaoPulsarPay.model.modelPulsarPay.Boleto;
import java.util.List;

public interface HttpPulsarPayBoleto {

    List<Boleto> getBoletos() throws Exception;
    List<Boleto> postBoleto(Boleto boletoBody) throws Exception;
}
