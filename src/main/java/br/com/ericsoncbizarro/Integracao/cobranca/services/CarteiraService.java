package br.com.ericsoncbizarro.Integracao.cobranca.services;

import br.com.ericsoncbizarro.Integracao.cobranca.model.modelPulsarPay.Carteira;

import java.util.List;

public interface CarteiraService {

    List<Carteira> findAll() throws Exception;

}
