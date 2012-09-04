package br.ufms.facom.apsoo.sigschool.ui.converter;

import br.ufms.facom.apsoo.sigschool.model.dao.ResponsavelDAO;
import br.ufms.facom.apsoo.sigschool.model.dao.impl.ResponsavelDAOImpl;
import br.ufms.facom.apsoo.sigschool.model.entity.Responsavel;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "responsavelConverter")
public class ResponsavelConverter implements Converter {

    private ResponsavelDAO responsavelDAO = new ResponsavelDAOImpl();

    @Override
    public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
        if (value != null && !value.equals("")) {
            Long id = Long.parseLong(value);

            return responsavelDAO.retrieve(id);
        }

        return null;
    }

    @Override
    public String getAsString(FacesContext ctx, UIComponent component, Object value) {
        if (value != null && !"".equals(value)) {
            Responsavel responsavel = (Responsavel) value;

            return responsavel.getId().toString();
        }

        return (String) value;
    }
}
