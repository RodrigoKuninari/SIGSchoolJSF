/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.apsoo.sigschool.model.dao.impl;

import br.ufms.facom.apsoo.sigschool.model.dao.DisciplinaDAO;
import br.ufms.facom.apsoo.sigschool.model.entity.Disciplina;
import br.ufms.facom.apsoo.sigschool.model.types.QueryParameter;
import java.util.List;

/**
 *
 * @author Rodrigo Kuninari
 */
public class DisciplinaDAOImpl extends GenericDAOImpl<Disciplina, Long> implements DisciplinaDAO {

    @Override
    public Class<Disciplina> getDomainClass() {
        return Disciplina.class;
    }

    @Override
    public Disciplina buscarDisciplinaPeloNome(String nome) {
        String namedQuery = "Disciplina.buscarDisciplinaPeloNome";
        QueryParameter parameter = new QueryParameter("nome", nome);
        Disciplina disciplinaFisica = (Disciplina) executeNamedQuerySingleResult(namedQuery, parameter);

        return disciplinaFisica;
    }
    
    @Override
    public List<Disciplina> buscarDisciplinasAtivas(boolean ativa)
    {
        String namedQuery = "Disciplina.buscarDisciplinasAtivas";
        QueryParameter parameter = new QueryParameter("ativa", ativa);
        List<Disciplina> resultList = executeNamedQuery(namedQuery, parameter);

        return resultList;
    }
}
