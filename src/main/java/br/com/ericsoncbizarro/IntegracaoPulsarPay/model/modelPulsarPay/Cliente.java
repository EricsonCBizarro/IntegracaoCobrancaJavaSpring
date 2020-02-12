package br.com.ericsoncbizarro.IntegracaoPulsarPay.model.modelPulsarPay;

import java.io.Serializable;
import java.util.Objects;

public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

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

    public Cliente() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome_fantasia() {
        return nome_fantasia;
    }

    public void setNome_fantasia(String nome_fantasia) {
        this.nome_fantasia = nome_fantasia;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public long getControle_externo() {
        return controle_externo;
    }

    public void setControle_externo(long controle_externo) {
        this.controle_externo = controle_externo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
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

    public String getConta_id() {
        return conta_id;
    }

    public void setConta_id(String conta_id) {
        this.conta_id = conta_id;
    }

    public String getEndereco_id() {
        return endereco_id;
    }

    public void setEndereco_id(String endereco_id) {
        this.endereco_id = endereco_id;
    }

    public String getValidado() {
        return validado;
    }

    public void setValidado(String validado) {
        this.validado = validado;
    }

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
