/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.apsoo.sigschool.model.dao.impl;

import br.ufms.facom.apsoo.sigschool.model.dao.AlunoDAO;
import br.ufms.facom.apsoo.sigschool.model.dao.CoordenadorDAO;
import br.ufms.facom.apsoo.sigschool.model.entity.Coordenador;
import br.ufms.facom.apsoo.sigschool.model.entity.Coordenador;
import br.ufms.facom.apsoo.sigschool.model.types.QueryParameter;
import java.util.List;

/**
 *
 * @author Rodrigo Kuninari
 */
public class CoordenadorDAOImpl extends GenericDAOImpl<Coordenador, Long> implements CoordenadorDAO
{

    @Override
    public Class<Coordenador> getDomainClass()
    {
        return Coordenador.class;
    }

    @Override
    public Coordenador buscarCoordenadorPeloCPF(String cpf)
    {
        String namedQuery = "Coordenador.buscarCoordenadorPeloCPF";
        QueryParameter parameter = new QueryParameter("cpf", cpf);
        Coordenador coordenadorFisico = (Coordenador) executeNamedQuerySingleResult(namedQuery, parameter);

        return coordenadorFisico;
    }

    @Override
    public List<Coordenador> buscarCoordenadoresAtivos(boolean ativo)
    {
        String namedQuery = "Coordenador.buscarCoordenadoresAtivos";
        QueryParameter parameter = new QueryParameter("ativo", ativo);
        List<Coordenador> resultList = executeNamedQuery(namedQuery, parameter);

        return resultList;
    }
}
