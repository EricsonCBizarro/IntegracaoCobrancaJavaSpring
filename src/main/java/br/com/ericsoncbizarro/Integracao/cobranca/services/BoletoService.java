package br.com.ericsoncbizarro.Integracao.cobranca.services;

import br.com.ericsoncbizarro.Integracao.cobranca.model.modelPulsarPay.Boleto;

import java.util.List;

public interface BoletoService {

    List<Boleto> findAll() throws Exception;
    List<Boleto> create(Boleto boletoRequestBody) throws Exception;

}
