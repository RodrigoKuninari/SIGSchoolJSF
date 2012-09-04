/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.apsoo.sigschool.model.dao.impl;

import br.ufms.facom.apsoo.sigschool.model.dao.AvaliacaoDAO;
import br.ufms.facom.apsoo.sigschool.model.entity.Avaliacao;
import br.ufms.facom.apsoo.sigschool.model.types.QueryParameter;
import java.util.List;

/**
 *
 * @author Rodrigo Kuninari
 */
public class AvaliacaoDAOImpl extends GenericDAOImpl<Avaliacao, Long> implements AvaliacaoDAO {

    @Override
    public Class<Avaliacao> getDomainClass() {
        return Avaliacao.class;
    }
    
    @Override
    public List<Avaliacao> buscarAvaliacoesAprovadas(boolean aprovada)
    {
        String namedQuery = "Avaliacao.buscarAvaliacoesAprovadas";
        QueryParameter parameter = new QueryParameter("aprovada", aprovada);
        List<Avaliacao> resultList = executeNamedQuery(namedQuery, parameter);

        return resultList;
    }


}
