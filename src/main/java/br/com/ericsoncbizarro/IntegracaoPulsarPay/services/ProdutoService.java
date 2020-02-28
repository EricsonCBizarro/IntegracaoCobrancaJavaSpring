package br.com.ericsoncbizarro.IntegracaoPulsarPay.services;

import br.com.ericsoncbizarro.IntegracaoPulsarPay.model.modelPulsarPay.Produto;
import java.util.List;

public interface ProdutoService {

    List<Produto> findAll() throws Exception;
    List<Produto> create(Produto produtoRequestBody) throws Exception;

}