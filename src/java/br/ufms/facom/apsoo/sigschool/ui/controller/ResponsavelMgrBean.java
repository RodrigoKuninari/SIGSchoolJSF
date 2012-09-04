/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.apsoo.sigschool.ui.controller;

import br.ufms.facom.apsoo.sigschool.model.dao.ResponsavelDAO;
import br.ufms.facom.apsoo.sigschool.model.dao.impl.ResponsavelDAOImpl;
import br.ufms.facom.apsoo.sigschool.model.entity.Responsavel;
import br.ufms.facom.apsoo.sigschool.model.util.FacesUtil;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class ResponsavelMgrBean extends FormatarPDF implements Serializable
{

    private Responsavel responsavel;
    private ResponsavelDAO responsavelDao;
    private String dataNascimento;

    @PostConstruct
    public void init()
    {
        responsavel = new Responsavel();
        responsavelDao = new ResponsavelDAOImpl();
        dataNascimento = null;
    }

    public Responsavel getResponsavel() throws Exception
    {
        try
        {
            DateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
            dataNascimento = dataFormatada.format(responsavel.getDataNasc());
        }
        catch (Exception ex)
        {
            System.out.println("Erro");
        }
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel)
    {
        this.responsavel = responsavel;
    }

    public ResponsavelDAO getResponsavelDao()
    {
        return responsavelDao;
    }

    public void setResponsavelDao(ResponsavelDAO responsavelDao)
    {
        this.responsavelDao = responsavelDao;
    }

    public String getDataNascimento()
    {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento)
    {
        this.dataNascimento = dataNascimento;
    }

    public List<Responsavel> listarResponsaveis()
    {
        return responsavelDao.list();
    }

    public String novoResponsavel()
    {
        responsavel = new Responsavel();
        dataNascimento = null;
        return "responsavelform";
    }

    public String salvarResponsavel() throws ParseException
    {
        DateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
        try
        {
            Date date = dataFormatada.parse(dataNascimento);
            responsavel.setDataNasc(date);
        }
        catch (ParseException ex)
        {
            System.out.println("Erro conversão da data");
        }

        if (responsavel.getId() == null)
        {
            Responsavel r = new Responsavel();
            r = responsavelDao.buscarResponsavelPeloCPF(responsavel.getCpf());
            if(r != null)
            {
                FacesUtil.mensErro("Responsável já Cadastrado!");
                return "responsavelform";
            }
            responsavelDao.create(responsavel);
        }
        else
        {
            responsavelDao.update(responsavel);
        }
        return "responsaveis";
    }
}
