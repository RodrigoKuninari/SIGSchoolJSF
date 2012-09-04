/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.apsoo.sigschool.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author rkuninari
 */
@Entity
@Table(name = "tb_professor_disciplina")
@NamedQuery(name = "ProfessorDisciplina.buscarProfessorDisciplinaPeloCoordenadorTurma", query = "SELECT pd FROM ProfessorDisciplina AS pd WHERE pd.coordenadorTurma =:coordenadorTurma")
public class ProfessorDisciplina implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false)
    private Long id;

    @JoinColumn(name = "professor")
    @ManyToOne
    private Professor professor;

    @JoinColumn(name = "disciplina")
    @ManyToOne
    private Disciplina disciplina;

    @JoinColumn(name = "coordenador_turma")
    @ManyToOne
    private CoordenadorTurma coordenadorTurma;

    @OneToMany(mappedBy = "professorDisciplina")
    private List<HistoricoNotas> historicoNotas = new ArrayList<HistoricoNotas>();
    
    @OneToMany(mappedBy="professorDisciplina")
    private List<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();

    public ProfessorDisciplina()
    {
    }

    public ProfessorDisciplina(Professor professor, Disciplina disciplina, CoordenadorTurma coordenadorTurma)
    {
        this.professor = professor;
        this.disciplina = disciplina;
        this.coordenadorTurma = coordenadorTurma;
    }

    public List<Avaliacao> getAvaliacoes()
    {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes)
    {
        this.avaliacoes = avaliacoes;
    }

    public CoordenadorTurma getCoordenadorTurma()
    {
        return coordenadorTurma;
    }

    public void setCoordenadorTurma(CoordenadorTurma coordenadorTurma)
    {
        this.coordenadorTurma = coordenadorTurma;
    }

    public Disciplina getDisciplina()
    {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina)
    {
        this.disciplina = disciplina;
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

    public Professor getProfessor()
    {
        return professor;
    }

    public void setProfessor(Professor professor)
    {
        this.professor = professor;
    }
    
    public void adicionarHistoricoNotas(HistoricoNotas historicoNota)
    {
        historicoNotas.add(historicoNota);
    }
    
    public void adicionarAvaliacao(Avaliacao avaliacao)
    {
        avaliacoes.add(avaliacao);
    }
}
