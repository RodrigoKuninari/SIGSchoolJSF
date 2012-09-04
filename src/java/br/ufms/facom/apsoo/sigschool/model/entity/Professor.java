/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.apsoo.sigschool.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Rodrigo Kuninari
 */
@Entity
@Table(name = "tb_professor")
@NamedQueries({
@NamedQuery(name = "Professor.buscarProfessoresAtivos", query = "SELECT p FROM Professor AS p WHERE p.ativo = :ativo ORDER BY p.nome"),
@NamedQuery(name = "Professor.buscarProfessorPeloCPF", query = "SELECT p FROM Professor AS p WHERE p.cpf = :cpf ORDER BY p.nome")})
public class Professor extends Funcionario implements Serializable
{

    @OneToMany(mappedBy = "professor")
    private List<ProfessorDisciplina> professorDisciplinas = new ArrayList<ProfessorDisciplina>();

    public Professor()
    {
    }

    public Professor(String nome, Date dataNasc, String sexo, String telRes, String telCel, String email, String endereco, boolean ativo, String cpf, String rg, String matricula, String curriculum)
    {
        super(nome, dataNasc, sexo, telRes, telCel, email, endereco, ativo, cpf, rg, matricula, curriculum);
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