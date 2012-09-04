package br.ufms.facom.apsoo.sigschool.ui.controller;

import br.ufms.facom.apsoo.sigschool.model.dao.UsuarioDAO;
import br.ufms.facom.apsoo.sigschool.model.dao.impl.UsuarioDAOImpl;
import br.ufms.facom.apsoo.sigschool.model.entity.Usuario;
import br.ufms.facom.apsoo.sigschool.model.util.Constantes;
import br.ufms.facom.apsoo.sigschool.model.util.FacesUtil;
import br.ufms.facom.apsoo.sigschool.model.util.SessionUtil;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Rodrigo Kuninari
 */
@ManagedBean
@SessionScoped
public class UsuarioMgrBean implements Serializable {

    private Usuario usuarioLogado;
    private UsuarioDAO usuarioDAO;

    @PostConstruct
    public void init() {
        usuarioLogado = (Usuario) SessionUtil.getAttribute(Constantes.LOGGED_USER);
        usuarioDAO = new UsuarioDAOImpl();
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public void salvarUsuario() {
        usuarioDAO.update(usuarioLogado);
        FacesUtil.mensInfo(Constantes.MSG_INFO_USUARIO_SALVO);
    }
}
