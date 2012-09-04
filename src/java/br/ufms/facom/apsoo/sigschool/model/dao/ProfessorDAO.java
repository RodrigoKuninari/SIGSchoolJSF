/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.apsoo.sigschool.model.dao;

import br.ufms.facom.apsoo.sigschool.model.entity.Professor;
import java.util.List;

/**
 *
 * @author Rodrigo Kuninari
 */
public interface ProfessorDAO extends GenericDAO<Professor, Long>
{
    public Professor buscarProfessorPeloCPF(String cpf);
    
    public List<Professor> buscarProfessoresAtivos(boolean ativo);
}
