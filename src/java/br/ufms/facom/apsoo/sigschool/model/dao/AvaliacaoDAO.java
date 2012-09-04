/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.apsoo.sigschool.model.dao;

import br.ufms.facom.apsoo.sigschool.model.entity.Avaliacao;
import java.util.List;

/**
 *
 * @author Rodrigo Kuninari
 */
public interface AvaliacaoDAO extends GenericDAO<Avaliacao, Long>
{
    public List<Avaliacao> buscarAvaliacoesAprovadas(boolean aprovada);
}
