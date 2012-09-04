/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.apsoo.sigschool.model.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Rodrigo Kuninari
 */
@Entity
@Table(name = "tb_aluno")
@NamedQuery(name = "Aluno.buscarAlunoPelaMatricula", query = "SELECT a FROM Aluno AS a WHERE a.matricula = :matricula ORDER BY a.nome")
public class Aluno extends Pessoa implements Serializable
{

    @Column(name = "matricula")
    private String matricula;
    @JoinColumn(name = "responsavel")
    @ManyToOne
    private Responsavel responsavel;
    @OneToOne(mappedBy = "aluno")
    private Historico historico;

    public Aluno()
    {
    }

    public Aluno(String nome, Date dataNasc, String sexo, String telRes, String telCel, String email, String endereco, boolean ativo, String matricula, Responsavel responsavel, Historico historico)
    {
        super(nome, dataNasc, sexo, telRes, telCel, email, endereco, ativo);
        this.matricula = matricula;
        this.responsavel = responsavel;
        this.historico = historico;
    }

    public Historico getHistorico()
    {
        return historico;
    }

    public void setHistorico(Historico historico)
    {
        this.historico = historico;
    }

    public String getMatricula()
    {
        return matricula;
    }

    public void setMatricula(String matricula)
    {
        this.matricula = matricula;
    }

    public Responsavel getResponsavel()
    {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel)
    {
        this.responsavel = responsavel;
    }
}