/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.apsoo.sigschool.model.dao.impl;

import br.ufms.facom.apsoo.sigschool.model.dao.ResponsavelDAO;
import br.ufms.facom.apsoo.sigschool.model.entity.Responsavel;
import br.ufms.facom.apsoo.sigschool.model.types.QueryParameter;
import java.util.List;

/**
 *
 * @author Rodrigo Kuninari
 */
public class ResponsavelDAOImpl extends GenericDAOImpl<Responsavel, Long> implements ResponsavelDAO {

    @Override
    public Class<Responsavel> getDomainClass() {
        return Responsavel.class;
    }

    @Override
    public Responsavel buscarResponsavelPeloCPF(String cpf) {
        String namedQuery = "Responsavel.buscarResponsavelPeloCPF";
        QueryParameter parameter = new QueryParameter("cpf", cpf);
        Responsavel responsavelFisico = (Responsavel) executeNamedQuerySingleResult(namedQuery, parameter);

        return responsavelFisico;
    }
    
    @Override
    public List<Responsavel> buscarResponsaveisAtivos(boolean ativo)
    {
        String namedQuery = "Responsavel.buscarResponsaveisAtivos";
        QueryParameter parameter = new QueryParameter("ativo", ativo);
        List<Responsavel> resultList = executeNamedQuery(namedQuery, parameter);

        return resultList;
    }
}
