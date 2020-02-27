package br.com.ericsoncbizarro.IntegracaoPulsarPay.model.modelPulsarPay;

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
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    // @TODO rever tipos de dados.... data de nascimento etc... String ?
    // @TODO usar notação camelCase... trocar conta_id por contaId etc...
    private long id;
    private String nome;
    private String nome_fantasia;
    private String documento;
    private String data_nascimento;
    private String email;
    private String telefone;
    private String celular;
    private String skype;
    private long controle_externo;
    private String observacoes;
    private String ativo;
    private String created_at;
    private String updated_at;
    private String conta_id;
    private String endereco_id;
    private String validado;

    // @TODO porque precisou reimplementar equals e hashCode em Cliente mas nao em Boleto?
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id == cliente.id &&
                Objects.equals(nome, cliente.nome) &&
                Objects.equals(nome_fantasia, cliente.nome_fantasia) &&
                Objects.equals(documento, cliente.documento) &&
                Objects.equals(data_nascimento, cliente.data_nascimento) &&
                Objects.equals(email, cliente.email) &&
                Objects.equals(telefone, cliente.telefone) &&
                Objects.equals(celular, cliente.celular) &&
                Objects.equals(skype, cliente.skype) &&
                Objects.equals(controle_externo, cliente.controle_externo) &&
                Objects.equals(observacoes, cliente.observacoes) &&
                Objects.equals(ativo, cliente.ativo) &&
                Objects.equals(created_at, cliente.created_at) &&
                Objects.equals(updated_at, cliente.updated_at) &&
                Objects.equals(conta_id, cliente.conta_id) &&
                Objects.equals(endereco_id, cliente.endereco_id) &&
                Objects.equals(validado, cliente.validado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, nome_fantasia, documento, data_nascimento, email, telefone, celular, skype, controle_externo, observacoes, ativo, created_at, updated_at, conta_id, endereco_id, validado);
    }
}