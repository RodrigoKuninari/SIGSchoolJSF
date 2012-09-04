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
 * @author rkuninari
 */
@Entity
@Table(name = "tb_historico_notas")
@NamedQuery(name = "HistoricoNotas.buscarHistoricoNotasPeloProfessorDisciplina", query = "SELECT hn FROM HistoricoNotas AS hn WHERE hn.professorDisciplina = :professorDisciplina")
public class HistoricoNotas implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "media")
    private float media;

    @OneToMany(mappedBy = "historicoNotas")
    private List<AvaliacaoAluno> avaliacaoAlunos = new ArrayList<AvaliacaoAluno>();

    @JoinColumn(name = "professor_disciplina")
    @ManyToOne
    private ProfessorDisciplina professorDisciplina;

    @JoinColumn(name = "historico")
    @ManyToOne
    private Historico historico;

    public HistoricoNotas()
    {
    }

    public HistoricoNotas(float media, ProfessorDisciplina professorDisciplina, Historico historico)
    {
        this.media = media;
        this.professorDisciplina = professorDisciplina;
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

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public float getMedia()
    {
        return media;
    }

    public void setMedia(float media)
    {
        this.media = media;
    }

    public ProfessorDisciplina getProfessorDisciplina()
    {
        return professorDisciplina;
    }

    public void setProfessorDisciplina(ProfessorDisciplina professorDisciplina)
    {
        this.professorDisciplina = professorDisciplina;
    }

    public List<AvaliacaoAluno> getTipoAvaliacoes()
    {
        return avaliacaoAlunos;
    }

    public void setTipoAvaliacoes(List<AvaliacaoAluno> tipoAvaliacoes)
    {
        this.avaliacaoAlunos = tipoAvaliacoes;
    }
    
    public void adicionarAvaliacaoAluno(AvaliacaoAluno avaliacaoAluno)
    {
        avaliacaoAlunos.add(avaliacaoAluno);
    }

}
