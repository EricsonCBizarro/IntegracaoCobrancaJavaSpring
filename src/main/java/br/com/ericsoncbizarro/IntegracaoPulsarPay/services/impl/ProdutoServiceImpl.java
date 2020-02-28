package br.com.ericsoncbizarro.IntegracaoPulsarPay.services.impl;

import br.com.ericsoncbizarro.IntegracaoPulsarPay.model.modelPulsarPay.Produto;
import br.com.ericsoncbizarro.IntegracaoPulsarPay.services.HttpPulsarPayProduto;
import br.com.ericsoncbizarro.IntegracaoPulsarPay.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private HttpPulsarPayProduto httpPulsarPay;

    public List<Produto> findAll() throws Exception {
        return httpPulsarPay.getProduto();
    }

    public List<Produto> create(Produto produtoRequestBody) throws Exception { // criar um dto para cliente
        Produto produtoMock = mockProduto(produtoRequestBody);
        return httpPulsarPay.postProduto(produtoMock);
    }

    private Produto mockProduto(Produto produtoRequestBody){
        Produto produtoHttp = new Produto();
        produtoHttp.setDescricao(produtoRequestBody.getDescricao());
        produtoHttp.setValor(produtoRequestBody.getValor());
        return produtoHttp;
    }
}