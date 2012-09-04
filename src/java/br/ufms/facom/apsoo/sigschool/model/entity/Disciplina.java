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
@Table(name = "tb_disciplina")
@NamedQueries(
{
    @NamedQuery(name = "Disciplina.buscarDisciplinasAtivas", query = "SELECT d FROM Disciplina AS d WHERE d.ativa = :ativa ORDER BY d.nome"),
    @NamedQuery(name = "Disciplina.buscarDisciplinaPeloNome", query = "SELECT d FROM Disciplina AS d WHERE d.nome = :nome ORDER BY d.nome")
})
public class Disciplina implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false)
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "ativa")
    private boolean ativa = true;
    @OneToMany(mappedBy = "disciplina")
    private List<ProfessorDisciplina> professorDisciplinas = new ArrayList<ProfessorDisciplina>();

    public Disciplina()
    {
    }

    public Disciplina(String nome, boolean ativa)
    {
        this.nome = nome;
        this.ativa = ativa;
    }

    public boolean isAtiva()
    {
        return ativa;
    }

    public void setAtiva(boolean ativa)
    {
        this.ativa = ativa;
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

    public List<ProfessorDisciplina> getProfessorDisciplinas()
    {
        return professorDisciplinas;
    }

    public void setProfessorDisciplinas(List<ProfessorDisciplina> professorDisciplinas)
    {
        this.professorDisciplinas = professorDisciplinas;
    }
    
    public void adicionarProfessorDisciplina(ProfessorDisciplina professorDisciplina)
    {
        professorDisciplinas.add(professorDisciplina);
    }
}
