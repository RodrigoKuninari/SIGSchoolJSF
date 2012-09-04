/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.apsoo.sigschool.model.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;

/**
 *
 * @author Rodrigo Kuninari
 */
@MappedSuperclass
public abstract class Pessoa implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false)
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "dataNasc", nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNasc;
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "telRes")
    private String telRes;
    @Column(name = "telCel")
    private String telCel;
    @Column(name = "email")
    private String email;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "ativo")
    private boolean ativo = true;

    public Pessoa()
    {
    }

    public Pessoa(String nome, Date dataNasc, String sexo, String telRes, String telCel, String email, String endereco, boolean ativo)
    {
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.sexo = sexo;
        this.telRes = telRes;
        this.telCel = telCel;
        this.email = email;
        this.endereco = endereco;
        this.ativo = ativo;
    }

    public boolean isAtivo()
    {
        return ativo;
    }

    public void setAtivo(boolean ativo)
    {
        this.ativo = ativo;
    }

    public Date getDataNasc()
    {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc)
    {
        this.dataNasc = dataNasc;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEndereco()
    {
        return endereco;
    }

    public void setEndereco(String endereco)
    {
        this.endereco = endereco;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getSexo()
    {
        return sexo;
    }

    public void setSexo(String sexo)
    {
        this.sexo = sexo;
    }

    public String getTelCel()
    {
        return telCel;
    }

    public void setTelCel(String telCel)
    {
        this.telCel = telCel;
    }

    public String getTelRes()
    {
        return telRes;
    }

    public void setTelRes(String telRes)
    {
        this.telRes = telRes;
    }
}