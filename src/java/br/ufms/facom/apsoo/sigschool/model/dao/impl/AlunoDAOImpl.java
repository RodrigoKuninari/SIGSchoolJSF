/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.apsoo.sigschool.model.dao.impl;

import br.ufms.facom.apsoo.sigschool.model.dao.AlunoDAO;
import br.ufms.facom.apsoo.sigschool.model.entity.Aluno;
import br.ufms.facom.apsoo.sigschool.model.types.QueryParameter;

/**
 *
 * @author Rodrigo Kuninari
 */
public class AlunoDAOImpl extends GenericDAOImpl<Aluno, Long> implements AlunoDAO {

    @Override
    public Class<Aluno> getDomainClass() {
        return Aluno.class;
    }

    @Override
    public Aluno buscarAlunoPeloNome(String nome) {
        String namedQuery = "Aluno.buscarAlunoPeloNome";
        QueryParameter parameter = new QueryParameter("nome", nome);
        Aluno alunoFisico = (Aluno) executeNamedQuerySingleResult(namedQuery, parameter);

        return alunoFisico;
    }
    
    @Override
    public Aluno buscarAlunoPelaMatricula(String matricula) {
        String namedQuery = "Aluno.buscarAlunoPelaMatricula";
        QueryParameter parameter = new QueryParameter("matricula", matricula);
        Aluno alunoFisico = (Aluno) executeNamedQuerySingleResult(namedQuery, parameter);

        return alunoFisico;
    }
}
