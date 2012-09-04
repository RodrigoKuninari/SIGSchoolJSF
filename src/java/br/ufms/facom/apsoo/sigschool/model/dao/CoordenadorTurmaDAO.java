/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.apsoo.sigschool.model.dao;

import br.ufms.facom.apsoo.sigschool.model.entity.CoordenadorTurma;

/**
 *
 * @author Rodrigo Kuninari
 */
public interface CoordenadorTurmaDAO extends GenericDAO<CoordenadorTurma, Long>
{
    public CoordenadorTurma buscarCoordenadorTurma(Long coordenador, String ano, String serie);
}
