/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.apsoo.sigschool.model.dao;

import br.ufms.facom.apsoo.sigschool.model.entity.Coordenador;
import java.util.List;

/**
 *
 * @author Rodrigo Kuninari
 */
public interface CoordenadorDAO extends GenericDAO<Coordenador, Long>
{
    public Coordenador buscarCoordenadorPeloCPF(String cpf);
    
    public List<Coordenador> buscarCoordenadoresAtivos(boolean ativo);
}
