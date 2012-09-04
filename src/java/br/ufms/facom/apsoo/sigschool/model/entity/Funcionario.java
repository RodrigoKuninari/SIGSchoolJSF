/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.apsoo.sigschool.model.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Rodrigo Kuninari
 */
@MappedSuperclass
public class Funcionario extends Pessoa implements Serializable
{

    @Column(name = "cpf")
    private String cpf;
    @Column(name = "rg")
    private String rg;
    @Column(name = "matricula")
    private String matricula;
    @Column(name = "curriculum")
    private String curriculum;

    public Funcionario()
    {
    }

    public Funcionario(String nome, Date dataNasc, String sexo, String telRes, String telCel, String email, String endereco, boolean ativo, String cpf, String rg, String matricula, String curriculum)
    {
        super(nome, dataNasc, sexo, telRes, telCel, email, endereco, ativo);
        this.cpf = cpf;
        this.rg = rg;
        this.matricula = matricula;
        this.curriculum = curriculum;
    }

    public String getCpf()
    {
        return cpf;
    }

    public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }

    public String getCurriculum()
    {
        return curriculum;
    }

    public void setCurriculum(String curriculum)
    {
        this.curriculum = curriculum;
    }

    public String getMatricula()
    {
        return matricula;
    }

    public void setMatricula(String matricula)
    {
        this.matricula = matricula;
    }

    public String getRg()
    {
        return rg;
    }

    public void setRg(String rg)
    {
        this.rg = rg;
    }
}