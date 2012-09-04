/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.apsoo.sigschool.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Rodrigo Kuninari
 */
@Entity
@Table(name = "tb_responsavel")
@NamedQueries({
@NamedQuery(name = "Responsavel.buscarResponsavelPeloCPF", query = "SELECT r FROM Responsavel AS r WHERE r.cpf = :cpf ORDER BY r.nome"),
@NamedQuery(name = "Responsavel.buscarResponsaveisAtivos",query = "SELECT r FROM Responsavel AS r WHERE r.ativo = :ativo ORDER BY r.nome")})
public class Responsavel extends Pessoa implements Serializable
{
    
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "rg")
    private String rg;
    @OneToMany(mappedBy = "responsavel")
    private List<Aluno> alunos = new ArrayList<Aluno>();
    
    public Responsavel()
    {
    }
    
    public Responsavel(String nome, Date dataNasc, String sexo, String telRes, String telCel, String email, String endereco, boolean ativo, String cpf, String rg)
    {
        super(nome, dataNasc, sexo, telRes, telCel, email, endereco, ativo);
        this.cpf = cpf;
        this.rg = rg;
    }
    
    public List<Aluno> getAlunos()
    {
        return alunos;
    }
    
    public void setAlunos(List<Aluno> alunos)
    {
        this.alunos = alunos;
    }
    
    public String getCpf()
    {
        return cpf;
    }
    
    public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }
    
    public String getRg()
    {
        return rg;
    }
    
    public void setRg(String rg)
    {
        this.rg = rg;
    }
    
    public void adicionarAluno(Aluno aluno)
    {
        alunos.add(aluno);
    }
}
