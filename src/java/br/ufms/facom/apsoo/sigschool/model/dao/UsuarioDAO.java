/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.apsoo.sigschool.model.dao;

import br.ufms.facom.apsoo.sigschool.model.entity.Usuario;


/**
 *
 * @author Rodrigo Kuninari
 */
public interface UsuarioDAO extends GenericDAO<Usuario, Integer> {

    public Usuario buscarUsuarioPeloNomeLogin(String usuarioNomeLogin);

    public boolean verificaSeUsuarioExiste(String usuarioNomeLogin);
}
