/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.apsoo.sigschool.model.dao.impl;

import br.ufms.facom.apsoo.sigschool.model.dao.ProfessorDisciplinaDAO;
import br.ufms.facom.apsoo.sigschool.model.entity.CoordenadorTurma;
import br.ufms.facom.apsoo.sigschool.model.entity.ProfessorDisciplina;
import br.ufms.facom.apsoo.sigschool.model.types.QueryParameter;
import java.util.List;

/**
 *
 * @author Rodrigo Kuninari
 */
public class ProfessorDisciplinaDAOImpl extends GenericDAOImpl<ProfessorDisciplina, Long> implements ProfessorDisciplinaDAO
{

    @Override
    public Class<ProfessorDisciplina> getDomainClass()
    {
        return ProfessorDisciplina.class;
    }

    @Override
    public List<ProfessorDisciplina> buscarProfessorDisciplinaPorCoordenadorTurma(CoordenadorTurma coordenadorTurma)
    {
        String namedQuery = "ProfessorDisciplina.buscarProfessorDisciplinaPeloCoordenadorTurma";
        QueryParameter parameter = new QueryParameter("coordenadorTurma", coordenadorTurma);
        List<ProfessorDisciplina> resultList = executeNamedQuery(namedQuery, parameter);

        return resultList;
    }
    
    @Override
    public ProfessorDisciplina buscarProfessorDisciplina(Long turma, Long professor, Long disciplina)
    {
        String sql = "SELECT pd FROM ProfessorDisciplina AS pd WHERE pd.coordenadorTurma.id ="+turma+" AND pd.professor.id ='"+professor+"' AND pd.disciplina.id ='"+disciplina+"'";
        ProfessorDisciplina professorDisciplina = (ProfessorDisciplina) executeQuery(sql);

        return professorDisciplina;
    }

}
