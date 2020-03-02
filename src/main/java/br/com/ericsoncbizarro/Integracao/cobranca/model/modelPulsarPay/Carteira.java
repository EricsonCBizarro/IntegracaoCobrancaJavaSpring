package br.com.ericsoncbizarro.Integracao.cobranca.model.modelPulsarPay;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain=true)
@NoArgsConstructor

public class Carteira {

    private String id;
    private String titulo;
    private String saque_automatico;
    private String inconsistente;
    private String ativo;
    private String saldo;
    private String created_at;
    private String updated_at;
    private String conta_id;
    private String carteira_tipo_id;
    private String saldo_bloqueado;
    private String bloqueado;

    // @TODO listagem de carteiras, verificar como melhorar esta parte
    public Carteira(String id, String titulo, String saque_automatico, String inconsistente, String ativo, String saldo, String created_at, String updated_at, String conta_id, String carteira_tipo_id, String saldo_bloqueado, String bloqueado) {
        this.id = id;
        this.titulo = titulo;
        this.saque_automatico = saque_automatico;
        this.inconsistente = inconsistente;
        this.ativo = ativo;
        this.saldo = saldo;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.conta_id = conta_id;
        this.carteira_tipo_id = carteira_tipo_id;
        this.saldo_bloqueado = saldo_bloqueado;
        this.bloqueado = bloqueado;
    }
}
