package br.ufms.facom.apsoo.sigschool.ui.converter;

import br.ufms.facom.apsoo.sigschool.model.dao.CoordenadorDAO;
import br.ufms.facom.apsoo.sigschool.model.dao.impl.CoordenadorDAOImpl;
import br.ufms.facom.apsoo.sigschool.model.entity.Coordenador;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "coordenadorConverter")
public class CoordenadorConverter implements Converter {

    private CoordenadorDAO coordenadorDAO = new CoordenadorDAOImpl();

    @Override
    public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
        if (value != null && !value.equals("")) {
            Long id = Long.parseLong(value);

            return coordenadorDAO.retrieve(id);
        }

        return null;
    }

    @Override
    public String getAsString(FacesContext ctx, UIComponent component, Object value) {
        if (value != null && !"".equals(value)) {
            Coordenador coordenador = (Coordenador) value;

            return coordenador.getId().toString();
        }

        return (String) value;
    }
}
