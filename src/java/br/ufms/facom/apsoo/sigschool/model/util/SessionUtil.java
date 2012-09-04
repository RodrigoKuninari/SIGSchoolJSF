package br.ufms.facom.apsoo.sigschool.model.util;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Singleton utilizada na manipulacao de dados na sessao.
 *
 * @author Rodrigo Kuninari
 */
public class SessionUtil {

    /**
     * Armazena a sessao corrente.
     */
    private static HttpSession session;

    /**
     * Metodo para recuperar um objeto (atributo) previamente salvo na sessao.
     *
     * @param attributeName Nome do objeto (atributo) a ser recuperado.
     * @return Objeto recuperado.
     */
    public static Object getAttribute(String attributeName) {
        getRequestSession();
        return session.getAttribute(attributeName);
    }

    /**
     * Metodo para salvar um objeto (atributo) na sessao.
     *
     * @param attributeName Nome do objeto (atributo) a ser salvo.
     * @param obj Objeto a ser salvo.
     */
    public static void setAttribute(String attributeName, Object obj) {
        getSession();
        session.setAttribute(attributeName, obj);
    }

    /**
     * Metodo para destruir a sessao corrente.
     */
    public static void destroySession() {
        getSession();
        session.invalidate();
    }

    /**
     * Metodo para retornar a sessao corrente.
     */
    private static void getSession() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        session = (HttpSession) ctx.getExternalContext().getSession(false);
    }

    private static void getRequestSession() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        session = request.getSession();
    }
}
