package br.ufms.facom.apsoo.sigschool.ui.converter;

import br.ufms.facom.apsoo.sigschool.model.dao.ProfessorDAO;
import br.ufms.facom.apsoo.sigschool.model.dao.impl.ProfessorDAOImpl;
import br.ufms.facom.apsoo.sigschool.model.entity.Professor;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "professorConverter")
public class ProfessorConverter implements Converter {

    private ProfessorDAO professorDAO = new ProfessorDAOImpl();

    @Override
    public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
        if (value != null && !value.equals("")) {
            Long id = Long.parseLong(value);

            return professorDAO.retrieve(id);
        }

        return null;
    }

    @Override
    public String getAsString(FacesContext ctx, UIComponent component, Object value) {
        if (value != null && !"".equals(value)) {
            Professor professor = (Professor) value;

            return professor.getId().toString();
        }

        return (String) value;
    }
}
