/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.apsoo.sigschool.model.dao.impl;

import br.ufms.facom.apsoo.sigschool.model.dao.ProfessorDAO;
import br.ufms.facom.apsoo.sigschool.model.entity.Professor;
import br.ufms.facom.apsoo.sigschool.model.types.QueryParameter;
import java.util.List;

/**
 *
 * @author Rodrigo Kuninari
 */
public class ProfessorDAOImpl extends GenericDAOImpl<Professor, Long> implements ProfessorDAO
{

    @Override
    public Class<Professor> getDomainClass()
    {
        return Professor.class;
    }

    @Override
    public Professor buscarProfessorPeloCPF(String cpf)
    {
        String namedQuery = "Professor.buscarProfessorPeloCPF";
        QueryParameter parameter = new QueryParameter("cpf", cpf);
        Professor professorFisico = (Professor) executeNamedQuerySingleResult(namedQuery, parameter);

        return professorFisico;
    }

    @Override
    public List<Professor> buscarProfessoresAtivos(boolean ativo)
    {
        String namedQuery = "Professor.buscarProfessoresAtivos";
        QueryParameter parameter = new QueryParameter("ativo", ativo);
        List<Professor> resultList = executeNamedQuery(namedQuery, parameter);

        return resultList;
    }

}
