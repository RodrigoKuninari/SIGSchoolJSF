package br.ufms.facom.apsoo.sigschool.ui.converter;

import br.ufms.facom.apsoo.sigschool.model.dao.DisciplinaDAO;
import br.ufms.facom.apsoo.sigschool.model.dao.impl.DisciplinaDAOImpl;
import br.ufms.facom.apsoo.sigschool.model.entity.Disciplina;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "disciplinaConverter")
public class DisciplinaConverter implements Converter {

    private DisciplinaDAO disciplinaDAO = new DisciplinaDAOImpl();

    @Override
    public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
        if (value != null && !value.equals("")) {
            Long id = Long.parseLong(value);

            return disciplinaDAO.retrieve(id);
        }

        return null;
    }

    @Override
    public String getAsString(FacesContext ctx, UIComponent component, Object value) {
        if (value != null && !"".equals(value)) {
            Disciplina disciplina = (Disciplina) value;

            return disciplina.getId().toString();
        }

        return (String) value;
    }
}
