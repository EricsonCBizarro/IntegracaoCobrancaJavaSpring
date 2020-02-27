package br.com.ericsoncbizarro.IntegracaoPulsarPay.model.modelPulsarPay;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain=true)
@NoArgsConstructor
public class Boleto {

    private String boleto_id;
    private String nosso_numero;
    private String credito_id;
    private String vencimento;
    private String documento;
    private String data_nascimento = "";
    private String valor;
    private String link_boleto;
    private String linha_digitavel;
    private String valor_total;

    public Boleto(String vencimento, String documento, String data_nascimento, String valor_total) {
        this.vencimento = vencimento;
        this.documento = documento;
        this.data_nascimento = data_nascimento;
        this.valor_total = valor_total;
    }

    public Boleto(String vencimento, String documento, String valor_total) {
        this.vencimento = vencimento;
        this.documento = documento;
        this.valor_total = valor_total;
    }

    public Boleto(String boleto_id, String nosso_numero, String credito_id, String vencimento, String valor, String link_boleto, String linha_digitavel) {
        this.boleto_id = boleto_id;
        this.nosso_numero = nosso_numero;
        this.credito_id = credito_id;
        this.vencimento = vencimento;
        this.valor = valor;
        this.link_boleto = link_boleto;
        this.linha_digitavel = linha_digitavel;
    }
}
