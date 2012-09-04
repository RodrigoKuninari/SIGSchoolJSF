/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.apsoo.sigschool.model.dao.impl;

import br.ufms.facom.apsoo.sigschool.model.dao.CoordenadorTurmaDAO;
import br.ufms.facom.apsoo.sigschool.model.entity.Coordenador;
import br.ufms.facom.apsoo.sigschool.model.entity.CoordenadorTurma;
import br.ufms.facom.apsoo.sigschool.model.types.QueryParameter;

/**
 *
 * @author Rodrigo Kuninari
 */
public class CoordenadorTurmaDAOImpl extends GenericDAOImpl<CoordenadorTurma, Long> implements CoordenadorTurmaDAO
{

    @Override
    public Class<CoordenadorTurma> getDomainClass()
    {
        return CoordenadorTurma.class;
    }
    
    @Override
    public CoordenadorTurma buscarCoordenadorTurma(Long coordenador, String ano, String serie)
    {
        String sql = "SELECT ct FROM CoordenadorTurma AS ct WHERE ct.coordenador.id ="+coordenador+" AND ct.ano ='"+ano+"' AND ct.serie ='"+serie+"'";
        CoordenadorTurma cordenadorTurma = (CoordenadorTurma) executeQuery(sql);

        return cordenadorTurma;
    }
    
}
