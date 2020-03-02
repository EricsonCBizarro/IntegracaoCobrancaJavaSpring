package br.com.ericsoncbizarro.Integracao.cobranca.services.impl;

import br.com.ericsoncbizarro.Integracao.cobranca.model.modelPulsarPay.Carteira;
import br.com.ericsoncbizarro.Integracao.cobranca.services.CarteiraService;
import br.com.ericsoncbizarro.Integracao.cobranca.services.HttpPulsarPayCarteira;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarteiraServiceImpl implements CarteiraService {

    @Autowired
    private HttpPulsarPayCarteira httpPulsarPay;

    public List<Carteira> findAll() throws Exception {
        return httpPulsarPay.getCarteiras();
    }



}
