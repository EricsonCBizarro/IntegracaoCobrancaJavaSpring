package br.com.ericsoncbizarro.Integracao.cobranca.services;

import br.com.ericsoncbizarro.Integracao.cobranca.model.modelPulsarPay.Produto;

import java.util.List;

public interface ProdutoService {

    List<Produto> findAll() throws Exception;
    List<Produto> create(Produto produtoRequestBody) throws Exception;

}