package br.com.ericsoncbizarro.IntegracaoPulsarPay.services;

import br.com.ericsoncbizarro.IntegracaoPulsarPay.model.modelPulsarPay.Produto;
import java.util.List;

public interface HttpPulsarPayProduto {

    List<Produto> getProduto() throws Exception;
    List<Produto> postProduto(Produto produtoBody) throws Exception;
}
