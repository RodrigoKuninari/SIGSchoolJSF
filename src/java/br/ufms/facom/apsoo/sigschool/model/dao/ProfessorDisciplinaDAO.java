/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.apsoo.sigschool.model.dao;

import br.ufms.facom.apsoo.sigschool.model.entity.CoordenadorTurma;
import br.ufms.facom.apsoo.sigschool.model.entity.ProfessorDisciplina;
import java.util.List;

/**
 *
 * @author Rodrigo Kuninari
 */
public interface ProfessorDisciplinaDAO extends GenericDAO<ProfessorDisciplina, Long>
{
    public List<ProfessorDisciplina> buscarProfessorDisciplinaPorCoordenadorTurma(CoordenadorTurma coordenadorTurma);
    
    public ProfessorDisciplina buscarProfessorDisciplina(Long turma, Long professor, Long disciplina);
}
