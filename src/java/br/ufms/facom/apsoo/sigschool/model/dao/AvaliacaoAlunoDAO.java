/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.apsoo.sigschool.model.dao;

import br.ufms.facom.apsoo.sigschool.model.entity.AvaliacaoAluno;
import java.util.List;

/**
 *
 * @author Rodrigo Kuninari
 */
public interface AvaliacaoAlunoDAO extends GenericDAO<AvaliacaoAluno, Long>
{
    public List<AvaliacaoAluno> buscarAvaliacaoAlunosAtivos(boolean ativo);
}
