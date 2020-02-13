package br.com.ericsoncbizarro.IntegracaoPulsarPay.model.modelPulsarPay;

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

    public Boleto(){

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

    public String getBoleto_id() {
        return boleto_id;
    }

    public void setBoleto_id(String boleto_id) {
        this.boleto_id = boleto_id;
    }

    public String getNosso_numero() {
        return nosso_numero;
    }

    public void setNosso_numero(String nosso_numero) {
        this.nosso_numero = nosso_numero;
    }

    public String getCredito_id() {
        return credito_id;
    }

    public void setCredito_id(String credito_id) {
        this.credito_id = credito_id;
    }

    public String getVencimento() {
        return vencimento;
    }

    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getLink_boleto() {
        return link_boleto;
    }

    public void setLink_boleto(String link_boleto) {
        this.link_boleto = link_boleto;
    }

    public String getLinha_digitavel() {
        return linha_digitavel;
    }

    public void setLinha_digitavel(String linha_digitavel) {
        this.linha_digitavel = linha_digitavel;
    }

    public String getValor_total() {
        return valor_total;
    }

    public void setValor_total(String valor_total) {
        this.valor_total = valor_total;
    }
}
