/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.apsoo.sigschool.model.dao.impl;

import br.ufms.facom.apsoo.sigschool.model.dao.TurmaDAO;
import br.ufms.facom.apsoo.sigschool.model.entity.Turma;

/**
 *
 * @author Rodrigo Kuninari
 */
public class TurmaDAOImpl extends GenericDAOImpl<Turma, Long> implements TurmaDAO {

    @Override
    public Class<Turma> getDomainClass() {
        return Turma.class;
    }

}
