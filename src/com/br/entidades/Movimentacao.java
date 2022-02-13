/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Criar as entidades referente ao banco de dados e encapsulamento
 * @author Felipe Chagas
 */
@Entity
@Table(name = "movimentacao")
@NamedQueries({
    @NamedQuery(name = "Movimentacao.findAll", query = "SELECT m FROM Movimentacao m"),
    @NamedQuery(name = "Movimentacao.findByIdMovimentacao", query = "SELECT m FROM Movimentacao m WHERE m.idMovimentacao = :idMovimentacao"),
    @NamedQuery(name = "Movimentacao.findByValor", query = "SELECT m FROM Movimentacao m WHERE m.valor = :valor"),
    @NamedQuery(name = "Movimentacao.findByData", query = "SELECT m FROM Movimentacao m WHERE m.data = :data"),
    @NamedQuery(name = "Movimentacao.findByDataCadastro", query = "SELECT m FROM Movimentacao m WHERE m.dataCadastro = :dataCadastro"),
    @NamedQuery(name = "Movimentacao.findByObservacao", query = "SELECT m FROM Movimentacao m WHERE m.observacao = :observacao"),
    @NamedQuery(name = "Movimentacao.findByNome", query = "SELECT m FROM Movimentacao m WHERE m.nome = :nome"),
    @NamedQuery(name = "Movimentacao.findByCnpj", query = "SELECT m FROM Movimentacao m WHERE m.cnpj = :cnpj"),
    @NamedQuery(name = "Movimentacao.findByCpf", query = "SELECT m FROM Movimentacao m WHERE m.cpf = :cpf"),
    @NamedQuery(name = "Movimentacao.findByEndere\u00e7o", query = "SELECT m FROM Movimentacao m WHERE m.endere\u00e7o = :endere\u00e7o"),
    @NamedQuery(name = "Movimentacao.findByContas", query = "SELECT m FROM Movimentacao m WHERE m.contas = :contas"),
    @NamedQuery(name = "Movimentacao.findByTelefone", query = "SELECT m FROM Movimentacao m WHERE m.telefone = :telefone")})
public class Movimentacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMovimentacao")
    private Integer idMovimentacao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Double valor;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "dataCadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;
    @Column(name = "observacao")
    private String observacao;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "cnpj")
    private String cnpj;
    @Basic(optional = false)
    @Column(name = "cpf")
    private String cpf;
    @Basic(optional = false)
    @Column(name = "endere\u00e7o")
    private String endereço;
    @Basic(optional = false)
    @Column(name = "contas")
    private int contas;
    @Basic(optional = false)
    @Column(name = "telefone")
    private String telefone;
    @JoinColumn(name = "idCategoria", referencedColumnName = "idCategoria")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Categoria idCategoria;

    public Movimentacao() {
    }

    public Movimentacao(Integer idMovimentacao) {
        this.idMovimentacao = idMovimentacao;
    }

    public Movimentacao(Integer idMovimentacao, String nome, String cnpj, String cpf, String endereço, int contas, String telefone) {
        this.idMovimentacao = idMovimentacao;
        this.nome = nome;
        this.cnpj = cnpj;
        this.cpf = cpf;
        this.endereço = endereço;
        this.contas = contas;
        this.telefone = telefone;
    }

    public Integer getIdMovimentacao() {
        return idMovimentacao;
    }

    public void setIdMovimentacao(Integer idMovimentacao) {
        this.idMovimentacao = idMovimentacao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public int getContas() {
        return contas;
    }

    public void setContas(int contas) {
        this.contas = contas;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMovimentacao != null ? idMovimentacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movimentacao)) {
            return false;
        }
        Movimentacao other = (Movimentacao) object;
        if ((this.idMovimentacao == null && other.idMovimentacao != null) || (this.idMovimentacao != null && !this.idMovimentacao.equals(other.idMovimentacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.entidades.Movimentacao[ idMovimentacao=" + idMovimentacao + " ]";
    }
    
}
