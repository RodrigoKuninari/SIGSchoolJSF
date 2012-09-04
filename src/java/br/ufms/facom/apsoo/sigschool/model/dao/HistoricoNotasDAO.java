/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.apsoo.sigschool.model.dao;

import br.ufms.facom.apsoo.sigschool.model.entity.HistoricoNotas;
import br.ufms.facom.apsoo.sigschool.model.entity.ProfessorDisciplina;
import java.util.List;

/**
 *
 * @author Rodrigo Kuninari
 */
public interface HistoricoNotasDAO extends GenericDAO<HistoricoNotas, Long>
{
    public List<HistoricoNotas> buscarHistoricoNotasPeloProfessorDisciplina(ProfessorDisciplina professorDisciplina);
}
