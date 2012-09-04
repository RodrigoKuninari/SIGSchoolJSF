/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.apsoo.sigschool.model.dao;

import br.ufms.facom.apsoo.sigschool.model.entity.Historico;
import java.util.List;

/**
 *
 * @author Rodrigo Kuninari
 */
public interface HistoricoDAO extends GenericDAO<Historico, Long>
{
    public Historico buscarHistoricoPelaSituacao(String situacao);
    
    public List<Historico> buscarHistoricosPelaSituacao(String situacao);
    
    public Historico buscarPorId(Long id);
}
