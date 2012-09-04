package br.ufms.facom.apsoo.sigschool.ui.controller;

import br.ufms.facom.apsoo.sigschool.model.dao.UsuarioDAO;
import br.ufms.facom.apsoo.sigschool.model.dao.impl.UsuarioDAOImpl;
import br.ufms.facom.apsoo.sigschool.model.entity.Usuario;
import br.ufms.facom.apsoo.sigschool.model.util.Constantes;
import br.ufms.facom.apsoo.sigschool.model.util.FacesUtil;
import br.ufms.facom.apsoo.sigschool.model.util.SessionUtil;
import br.ufms.facom.apsoo.sigschool.model.util.StringUtil;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Bean gerenciavel utilizado no controle do login de usuarios na aplicacao.
 * Este controle envolve principalmente:
 *                          verificao do login e senha;
 *                          login e logout;
 *                          verificar se o usuario esta autenticado e logado;
 *
 * @author Rodrigo Kuninari
 */
@ManagedBean
@RequestScoped
public class LoginMgrBean {

    /**
     * Armazena o usuario corrente
     */
    private Usuario usuario;
    /**
     * Armazena o usuario corrente apos a autenticacao, ou seja, o usuario
     * logado na sessao.
     */
    private Usuario usuarioAutenticado;
    /**
     * Variavel utilizada nos metodos que irao inserir ou consultar alguma
     * informacao relativa aos usuarios.
     */
    private UsuarioDAO usuarioDAO;

    @PostConstruct
    public void init() {
        usuario = new Usuario();
        usuarioDAO = new UsuarioDAOImpl();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario userToauthenticate) {
        this.usuario = userToauthenticate;
    }

    /**
     * Metodo para verificar o login do usuario.
     * Consulta um determinado a partir do nome de login.
     *
     * @return Usuario encontrado. Null caso o usuario nao seja encontrado.
     */
    private Usuario verificarLogin(Usuario usuario) {

        return (usuarioDAO.buscarUsuarioPeloNomeLogin(usuario.getNomeLogin()));
    }

    /**
     * Metodo para verificar a senha do usuario.
     *
     * @return True caso a senha esteja correta.
     */
    private boolean verificarSenha() {
        String senhaCriptografada = StringUtil.encrypt(usuario.getSenha());

        if ((usuarioAutenticado.getSenha().compareTo(senhaCriptografada) == 0)) {
            return true;
        }

        return false;
    }

    /**
     * Metodo para autenticar o usuario. Verifica o login e a senha deste.
     *
     * @return String contendo o endereco de redirecionamento caso o usuario foi
     *          corretamente autenticado. <br>
     *          Null caso houver um erro na autenticacao.
     */
    public String login() {
        usuarioAutenticado = verificarLogin(usuario);

        if (usuarioAutenticado == null) {
            FacesUtil.mensErro(Constantes.MSG_ERRO_INVALID_USER);
            return null;
        }

        if (!verificarSenha()) {
            usuarioAutenticado = null;
            FacesUtil.mensErro(Constantes.MSG_ERRO_INVALID_PASSWORD);
            return null;
        }

        SessionUtil.setAttribute(Constantes.LOGGED_USER, usuarioAutenticado);

        return Constantes.PAGE_WELCOME;
    }

    /**
     * Metodo para executar o logout da sessao.
     *
     * @return String contendo o endereco de redirecionamento para a pagina
     *          inicial (index.xhtml).
     */
    public String logout() {
        usuario = new Usuario();
        usuarioAutenticado = null;
        SessionUtil.destroySession();

        return Constantes.PAGE_INDEX;
    }
}
