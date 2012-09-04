/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.apsoo.sigschool.model.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Rodrigo Kuninari
 */
@Entity
@Table(name = "tb_avaliacao_aluno")
@NamedQuery(name = "AvaliacaoAluno.buscarAvaliacaoAlunoAtivos", query = "SELECT aa FROM AvaliacaoAluno AS aa WHERE aa.historicoNotas.historico.aluno.ativo = :ativo AND aa.avaliacao.aprovada = :ativo ORDER BY aa.historicoNotas.historico.aluno.nome")
public class AvaliacaoAluno implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "nota")
    private float nota;

    @JoinColumn(name = "historico_notas")
    @ManyToOne
    private HistoricoNotas historicoNotas;
    
    @JoinColumn(name="avaliacao")
    @ManyToOne
    private Avaliacao avaliacao;

    public AvaliacaoAluno()
    {
    }

    public AvaliacaoAluno(float nota, HistoricoNotas historicoNotas, Avaliacao avaliacao)
    {
        this.nota = nota;
        this.historicoNotas = historicoNotas;
        this.avaliacao = avaliacao;
    }

    public Avaliacao getAvaliacao()
    {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao)
    {
        this.avaliacao = avaliacao;
    }

    public HistoricoNotas getHistoricoNotas()
    {
        return historicoNotas;
    }

    public void setHistoricoNotas(HistoricoNotas historicoNotas)
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

    public float getNota()
    {
        return nota;
    }

    public void setNota(float nota)
    {
        this.nota = nota;
    }
}
