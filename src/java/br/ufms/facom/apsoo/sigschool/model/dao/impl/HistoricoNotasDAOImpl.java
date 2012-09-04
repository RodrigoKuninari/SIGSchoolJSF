/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.apsoo.sigschool.model.dao.impl;

import br.ufms.facom.apsoo.sigschool.model.dao.HistoricoNotasDAO;
import br.ufms.facom.apsoo.sigschool.model.entity.HistoricoNotas;
import br.ufms.facom.apsoo.sigschool.model.entity.ProfessorDisciplina;
import br.ufms.facom.apsoo.sigschool.model.types.QueryParameter;
import java.util.List;

/**
 *
 * @author Rodrigo Kuninari
 */
public class HistoricoNotasDAOImpl extends GenericDAOImpl<HistoricoNotas, Long> implements HistoricoNotasDAO
{

    @Override
    public Class<HistoricoNotas> getDomainClass()
    {
        return HistoricoNotas.class;
    }

    @Override
    public List<HistoricoNotas> buscarHistoricoNotasPeloProfessorDisciplina(ProfessorDisciplina professorDisciplina)
    {
        String namedQuery = "HistoricoNotas.buscarHistoricoNotasPeloProfessorDisciplina";
        QueryParameter parameter = new QueryParameter("professorDisciplina", professorDisciplina);
        List<HistoricoNotas> resultList = executeNamedQuery(namedQuery, parameter);

        return resultList;
    }
}
