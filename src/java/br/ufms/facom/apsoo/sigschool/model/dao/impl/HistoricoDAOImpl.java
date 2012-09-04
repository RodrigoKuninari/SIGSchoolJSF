/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.apsoo.sigschool.model.dao.impl;

import br.ufms.facom.apsoo.sigschool.model.dao.HistoricoDAO;
import br.ufms.facom.apsoo.sigschool.model.entity.Historico;
import br.ufms.facom.apsoo.sigschool.model.types.QueryParameter;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Rodrigo Kuninari
 */
public class HistoricoDAOImpl extends GenericDAOImpl<Historico, Long> implements HistoricoDAO
{

    @Override
    public Class<Historico> getDomainClass()
    {
        return Historico.class;
    }

    @Override
    public Historico buscarHistoricoPelaSituacao(String situacao)
    {
        String namedQuery = "Historico.buscarHistoricoPelaSituacao";
        QueryParameter parameter = new QueryParameter("situacao", situacao);
        Historico historicoFisico = (Historico) executeNamedQuerySingleResult(namedQuery, parameter);

        return historicoFisico;
    }

    @Override
    public List<Historico> buscarHistoricosPelaSituacao(String situacao)
    {
        String namedQuery = "Historico.buscarHistoricoPelaSituacao";
        QueryParameter parameter = new QueryParameter("situacao", situacao);
        List<Historico> resultList = executeNamedQuery(namedQuery, parameter);

        return resultList;
    }
    
    @Override
    public Historico buscarPorId(Long id) {
        Query q = getEntityManager().createQuery("SELECT h FROM Historico h WHERE h.id = :id");
        q.setParameter("id", id);
        return (Historico) q.getSingleResult();
    }

}
