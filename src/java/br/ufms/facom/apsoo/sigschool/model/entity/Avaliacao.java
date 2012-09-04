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
@Table(name = "tb_avaliacao")
@NamedQuery(name = "Avaliacao.buscarAvaliacoesAprovadas", query = "SELECT a FROM Avaliacao AS a WHERE a.aprovada = :aprovada ORDER BY a.data")
public class Avaliacao implements Serializable
{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false)
    private Long id;
    
    @Column(name = "data_avaliacao", nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data;
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "descricao")
    private String descricao;
    
    @Column(name = "observacao")
    private String observacao;
    
    @Column(name = "aprovada")
    private boolean aprovada = false;
    
    @JoinColumn(name="professor_disciplina")
    @ManyToOne
    private ProfessorDisciplina professorDisciplina;
    
    @OneToMany(mappedBy = "avaliacao")
    private List<AvaliacaoAluno> avaliacaoAlunos = new ArrayList<AvaliacaoAluno>();
    
    public Avaliacao()
    {
    }
    
    public Avaliacao(Date data, String nome, String descricao, String observacao)
    {
        this.data = data;
        this.nome = nome;
        this.descricao = descricao;
        this.observacao = observacao;
    }

    public boolean isAprovada()
    {
        return aprovada;
    }

    public void setAprovada(boolean aprovada)
    {
        this.aprovada = aprovada;
    }

    public List<AvaliacaoAluno> getAvaliacaoAlunos()
    {
        return avaliacaoAlunos;
    }

    public void setAvaliacaoAlunos(List<AvaliacaoAluno> avaliacaoAlunos)
    {
        this.avaliacaoAlunos = avaliacaoAlunos;
    }

    public Date getData()
    {
        return data;
    }

    public void setData(Date data)
    {
        this.data = data;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
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

    public String getObservacao()
    {
        return observacao;
    }

    public void setObservacao(String observacao)
    {
        this.observacao = observacao;
    }

    public ProfessorDisciplina getProfessorDisciplina()
    {
        return professorDisciplina;
    }

    public void setProfessorDisciplina(ProfessorDisciplina professorDisciplina)
    {
        this.professorDisciplina = professorDisciplina;
    }
    
    public void adicionarAvaliacaoAluno(AvaliacaoAluno avaliacaoAluno)
    {
        avaliacaoAlunos.add(avaliacaoAluno);
    }
    
//    public void getAvaliacaoAluno(AvaliacaoAluno avaliacaoAluno)
//    {
//        return avaliacaoAlunos.
//    }

}
