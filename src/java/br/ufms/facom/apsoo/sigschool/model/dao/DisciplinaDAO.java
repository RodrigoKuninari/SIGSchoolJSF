/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.apsoo.sigschool.model.dao;

import br.ufms.facom.apsoo.sigschool.model.entity.Disciplina;
import java.util.List;

/**
 *
 * @author Rodrigo Kuninari
 */
public interface DisciplinaDAO extends GenericDAO<Disciplina, Long>
{
    public Disciplina buscarDisciplinaPeloNome(String nome);
    
    public List<Disciplina> buscarDisciplinasAtivas(boolean ativa);
}
