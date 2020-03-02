package br.com.ericsoncbizarro.Integracao.cobranca.services;

import br.com.ericsoncbizarro.Integracao.cobranca.model.modelPulsarPay.Produto;

import java.util.List;

public interface HttpPulsarPayProduto {

    List<Produto> getProduto() throws Exception;
    List<Produto> postProduto(Produto produtoBody) throws Exception;
}
