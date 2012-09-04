/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.apsoo.sigschool.ui.controller;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;

/**
 *
 * @author Rodrigo Kuninari
 */
public abstract class FormatarPDF
{
    public void preProcessPDF(Object document)
    {
        Document pdf = (Document) document;
        pdf.setPageSize(PageSize.A4.rotate());
        pdf.open();
    }
}
