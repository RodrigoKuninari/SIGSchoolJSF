/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.apsoo.sigschool.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Rodrigo Kuninari
 */
@Entity
@Table(name = "tb_historico")
@NamedQuery(name = "Historico.buscarHistoricoPelaSituacao", query = "SELECT h FROM Historico AS h WHERE h.situacao =:situacao ORDER BY h.aluno.nome")
public class Historico implements Serializable, Comparable<Historico>
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "situacao")
    private String situacao;

    @JoinColumn(name = "aluno")
    @OneToOne
    private Aluno aluno;

    @OneToMany(mappedBy = "historico")
    private List<Turma> turmas = new ArrayList<Turma>();

    @OneToMany(mappedBy = "historico")
    private List<HistoricoNotas> historicoNotas = new ArrayList<HistoricoNotas>();

    public Historico()
    {
    }

    public Historico(String situacao, Aluno aluno)
    {
        this.situacao = situacao;
        this.aluno = aluno;
    }

    public Aluno getAluno()
    {
        return aluno;
    }

    public void setAluno(Aluno aluno)
    {
        this.aluno = aluno;
    }

    public List<HistoricoNotas> getHistoricoNotas()
    {
        return historicoNotas;
    }

    public void setHistoricoNotas(List<HistoricoNotas> historicoNotas)
    {
        this.historicoNotas = historicoNotas;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String isSituacao()
    {
        return situacao;
    }

    public void setSituacao(String situacao)
    {
        this.situacao = situacao;
    }

    public List<Turma> getTurmas()
    {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas)
    {
        this.turmas = turmas;
    }

    public String getSituacao()
    {
        return situacao;
    }
    
    @Override
    public int compareTo(Historico o)
    {
        return aluno.getNome().compareTo(o.getAluno().getNome());
    }
    
    public void adicionarTurma(Turma turma)
    {
        turmas.add(turma);
    }

}
