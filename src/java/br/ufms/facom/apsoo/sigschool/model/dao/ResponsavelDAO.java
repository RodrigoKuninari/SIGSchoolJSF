/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.apsoo.sigschool.model.dao;

import br.ufms.facom.apsoo.sigschool.model.entity.Responsavel;
import java.util.List;

/**
 *
 * @author Rodrigo Kuninari
 */
public interface ResponsavelDAO extends GenericDAO<Responsavel, Long>
{
    public Responsavel buscarResponsavelPeloCPF(String cpf);
    
    public List<Responsavel> buscarResponsaveisAtivos(boolean ativo);
}
