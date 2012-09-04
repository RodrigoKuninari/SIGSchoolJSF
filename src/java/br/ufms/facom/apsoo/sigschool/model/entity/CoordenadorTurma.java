/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.apsoo.sigschool.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author rkuninari
 */
@Entity
@Table(name = "tb_coordenador_turma")
public class CoordenadorTurma implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "ano")
    private String ano;

    @Column(name = "serie")
    private String serie;

    @JoinColumn(name = "coordenador")
    @ManyToOne
    private Coordenador coordenador;

    @OneToMany(mappedBy = "coordenadorTurma")
    private List<ProfessorDisciplina> professorDisciplinas = new ArrayList<ProfessorDisciplina>();

    @OneToMany(mappedBy = "coordenadorTurma")
    private List<Turma> turmas = new ArrayList<Turma>();

    public CoordenadorTurma()
    {
    }

    public CoordenadorTurma(String ano, String serie, Coordenador coordenador)
    {
        this.ano = ano;
        this.serie = serie;
        this.coordenador = coordenador;
    }

    public String getAno()
    {
        return ano;
    }

    public void setAno(String ano)
    {
        this.ano = ano;
    }

    public Coordenador getCoordenador()
    {
        return coordenador;
    }

    public void setCoordenador(Coordenador coordenador)
    {
        this.coordenador = coordenador;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public List<ProfessorDisciplina> getProfessorDisciplinas()
    {
        return professorDisciplinas;
    }

    public void setProfessorDisciplinas(List<ProfessorDisciplina> professorDisciplinas)
    {
        this.professorDisciplinas = professorDisciplinas;
    }

    public String getSerie()
    {
        return serie;
    }

    public void setSerie(String serie)
    {
        this.serie = serie;
    }

    public List<Turma> getTurmas()
    {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas)
    {
        this.turmas = turmas;
    }
    
    public void adicionarTurma(Turma turma)
    {
        turmas.add(turma);
    }
    
    public void adicionarProfessorDisciplina(ProfessorDisciplina professorDisciplina)
    {
        professorDisciplinas.add(professorDisciplina);
    }

}
