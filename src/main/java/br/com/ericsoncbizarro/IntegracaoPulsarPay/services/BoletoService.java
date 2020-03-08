package br.com.ericsoncbizarro.IntegracaoPulsarPay.services;

import br.com.ericsoncbizarro.IntegracaoPulsarPay.feign.BoletoOutputDTO;
import br.com.ericsoncbizarro.IntegracaoPulsarPay.model.modelPulsarPay.Boleto;
import java.util.List;

public interface BoletoService {

    List<Boleto> findAll() throws Exception;
    BoletoOutputDTO create(Boleto boletoRequestBody) throws Exception;

}
