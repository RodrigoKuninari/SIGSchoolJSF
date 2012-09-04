package br.ufms.facom.apsoo.sigschool.ui.converter;

import br.ufms.facom.apsoo.sigschool.model.dao.CoordenadorTurmaDAO;
import br.ufms.facom.apsoo.sigschool.model.dao.impl.CoordenadorTurmaDAOImpl;
import br.ufms.facom.apsoo.sigschool.model.entity.CoordenadorTurma;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "coordenadorTurmaConverter")
public class CoordenadorTurmaConverter implements Converter {

    private CoordenadorTurmaDAO coordenadorTurmaDAO = new CoordenadorTurmaDAOImpl();

    @Override
    public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
        if (value != null && !value.equals("")) {
            Long id = Long.parseLong(value);

            return coordenadorTurmaDAO.retrieve(id);
        }

        return null;
    }

    @Override
    public String getAsString(FacesContext ctx, UIComponent component, Object value) {
        if (value != null && !"".equals(value)) {
            CoordenadorTurma coordenadorTurma = (CoordenadorTurma) value;

            return coordenadorTurma.getId().toString();
        }

        return (String) value;
    }
}
