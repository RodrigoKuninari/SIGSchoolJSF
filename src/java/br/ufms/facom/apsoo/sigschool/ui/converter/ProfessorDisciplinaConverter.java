package br.ufms.facom.apsoo.sigschool.ui.converter;

import br.ufms.facom.apsoo.sigschool.model.dao.ProfessorDisciplinaDAO;
import br.ufms.facom.apsoo.sigschool.model.dao.impl.ProfessorDisciplinaDAOImpl;
import br.ufms.facom.apsoo.sigschool.model.entity.ProfessorDisciplina;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "professorDisciplinaConverter")
public class ProfessorDisciplinaConverter implements Converter {

    private ProfessorDisciplinaDAO professorDisciplinaDAO = new ProfessorDisciplinaDAOImpl();

    @Override
    public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
        if (value != null && !value.equals("")) {
            Long id = Long.parseLong(value);

            return professorDisciplinaDAO.retrieve(id);
        }

        return null;
    }

    @Override
    public String getAsString(FacesContext ctx, UIComponent component, Object value) {
        if (value != null && !"".equals(value)) {
            ProfessorDisciplina professorDisciplina = (ProfessorDisciplina) value;

            return professorDisciplina.getId().toString();
        }

        return (String) value;
    }
}
