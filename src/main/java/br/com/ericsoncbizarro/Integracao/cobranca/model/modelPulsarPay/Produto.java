package br.com.ericsoncbizarro.Integracao.cobranca.model.modelPulsarPay;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Accessors(chain=true)
@NoArgsConstructor
public class Produto  implements Serializable {

    // @TODO rever tipos de dados.... created_at etc... String ?
    private static final long serialVersionUID = 1L;
    private long id;
    private String descricao;
    private String valor;
    private String created_at;
    private String updated_at;

    // @TODO porque precisou reimplementar equals e hashCode em Produto mas nao em Boleto?
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
