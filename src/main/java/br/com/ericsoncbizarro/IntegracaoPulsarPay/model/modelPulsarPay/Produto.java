package br.com.ericsoncbizarro.IntegracaoPulsarPay.model.modelPulsarPay;

import java.io.Serializable;
import java.util.Objects;

public class Produto  implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;
    private String descricao;
    private String valor;
    private String created_at;
    private String updated_at;

    public Produto(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return id == produto.id &&
                Objects.equals(descricao, produto.descricao) &&
                Objects.equals(valor, produto.valor) &&
                Objects.equals(created_at, produto.created_at) &&
                Objects.equals(updated_at, produto.updated_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, valor, created_at, updated_at);
    }
}
