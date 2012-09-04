package br.ufms.facom.apsoo.sigschool.ui.converter;


import br.ufms.facom.apsoo.sigschool.model.dao.HistoricoDAO;
import br.ufms.facom.apsoo.sigschool.model.dao.impl.HistoricoDAOImpl;
import br.ufms.facom.apsoo.sigschool.model.entity.Historico;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import org.apache.commons.lang3.StringUtils;

@FacesConverter(value = "historicoConverter")
public class HistoricoConverter implements Converter
{

    private HistoricoDAO historicoDAO = new HistoricoDAOImpl();

    @Override
    public Object getAsObject(FacesContext ctx, UIComponent component, String value)
    {
        try
        {
            return StringUtils.isBlank(value) ? null : this.historicoDAO.buscarPorId(Long.valueOf(value));
        }
        catch (NumberFormatException e)
        {
            throw new ConverterException(value + " is not a number");
        }
    }

    @Override
    public String getAsString(FacesContext ctx, UIComponent component, Object value)
    {
       return value == null ? null : String.valueOf(((Historico) value).getId());
    }

}
