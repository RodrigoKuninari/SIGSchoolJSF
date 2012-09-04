/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.apsoo.sigschool.model.dao;

import br.ufms.facom.apsoo.sigschool.model.entity.Aluno;

/**
 *
 * @author Rodrigo Kuninari
 */
public interface AlunoDAO extends GenericDAO<Aluno, Long>
{
    public Aluno buscarAlunoPeloNome(String nome);
    
    public Aluno buscarAlunoPelaMatricula(String matricula);
}
