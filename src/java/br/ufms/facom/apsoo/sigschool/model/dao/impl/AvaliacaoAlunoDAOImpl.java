/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.apsoo.sigschool.model.dao.impl;

import br.ufms.facom.apsoo.sigschool.model.dao.AvaliacaoAlunoDAO;
import br.ufms.facom.apsoo.sigschool.model.entity.AvaliacaoAluno;
import br.ufms.facom.apsoo.sigschool.model.types.QueryParameter;
import java.util.List;

/**
 *
 * @author Rodrigo Kuninari
 */
public class AvaliacaoAlunoDAOImpl extends GenericDAOImpl<AvaliacaoAluno, Long> implements AvaliacaoAlunoDAO {

    @Override
    public Class<AvaliacaoAluno> getDomainClass() {
        return AvaliacaoAluno.class;
    }
    
    @Override
    public List<AvaliacaoAluno> buscarAvaliacaoAlunosAtivos(boolean ativo)
    {
        String namedQuery = "AvaliacaoAluno.buscarAvaliacaoAlunoAtivos";
        QueryParameter parameter = new QueryParameter("ativo", ativo);
        List<AvaliacaoAluno> resultList = executeNamedQuery(namedQuery, parameter);

        return resultList;
    }

}
