/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.apsoo.sigschool.ui.controller;

import br.ufms.facom.apsoo.sigschool.model.dao.HistoricoNotasDAO;
import br.ufms.facom.apsoo.sigschool.model.dao.impl.HistoricoNotasDAOImpl;
import br.ufms.facom.apsoo.sigschool.model.entity.HistoricoNotas;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Rodrigo Kuninari
 */
@ManagedBean
@SessionScoped
public class HistoricoNotasMgrBean extends FormatarPDF implements Serializable
{

    private HistoricoNotas historicoNotas;

    private HistoricoNotasDAO historicoNotasDao;

    @PostConstruct
    public void init()
    {
        historicoNotas = new HistoricoNotas();
        historicoNotasDao = new HistoricoNotasDAOImpl();
    }

    public HistoricoNotas getHistoricoNotas()
    {
        return historicoNotas;
    }

    public void setHistoricoNotas(HistoricoNotas historicoNotas)
    {
        this.historicoNotas = historicoNotas;
    }

    public HistoricoNotasDAO getHistoricoNotasDao()
    {
        return historicoNotasDao;
    }

    public void setHistoricoNotasDao(HistoricoNotasDAO historicoNotasDao)
    {
        this.historicoNotasDao = historicoNotasDao;
    }

    public List<HistoricoNotas> listarHistoricoNotas()
    {
        return historicoNotasDao.list();
    }

    public String novoHistoricoNotas()
    {
        historicoNotas = new HistoricoNotas();
        return "historiconotaform";
    }

    public String salvarHistoricoNotas()
    {
        historicoNotasDao.create(historicoNotas);
        return "historiconotas";
    }

}
