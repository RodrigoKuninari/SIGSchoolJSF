/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.apsoo.sigschool.model.util;

import javax.faces.model.SelectItem;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Rodrigo Kuninari
 */
@ManagedBean
@SessionScoped
public class TableBean implements Serializable
{
    private SelectItem[] manufacturerOptions;

    public TableBean()
    {
        manufacturerOptions = createFilterOptions();
    }

    private SelectItem[] createFilterOptions()
    {
        SelectItem[] options = new SelectItem[3];

        options[0] = new SelectItem("", "");
        options[1] = new SelectItem("True", "Sim");
        options[2] = new SelectItem("False", "Não");

        return options;
    }

    public SelectItem[] getManufacturerOptions()
    {
        return manufacturerOptions;
    }
}
