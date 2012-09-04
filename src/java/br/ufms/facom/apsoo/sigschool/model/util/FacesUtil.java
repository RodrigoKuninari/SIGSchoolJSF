package br.ufms.facom.apsoo.sigschool.model.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Singleton utilizada na exibicaoo de mensagens de alerta ou erro nos Facelets.
 *
 * @author Rodrigo Kuninari
 */
public class FacesUtil {

    public static void mensInfo(String message) {
        mensagem(message, FacesMessage.SEVERITY_INFO);
    }

    public static void mensErro(String message) {
        mensagem(message, FacesMessage.SEVERITY_ERROR);
    }

    public static void mensagem(String message,
            FacesMessage.Severity severity) {

        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, message, null));
    }
}
