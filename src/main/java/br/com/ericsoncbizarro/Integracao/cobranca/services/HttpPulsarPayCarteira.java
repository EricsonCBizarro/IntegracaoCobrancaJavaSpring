package br.com.ericsoncbizarro.Integracao.cobranca.services;

import br.com.ericsoncbizarro.Integracao.cobranca.model.modelPulsarPay.Carteira;

import java.util.List;

public interface HttpPulsarPayCarteira {

    List<Carteira> getCarteiras() throws Exception;

}
