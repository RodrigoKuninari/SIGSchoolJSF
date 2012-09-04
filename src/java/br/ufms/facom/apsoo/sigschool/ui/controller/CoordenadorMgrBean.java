/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.apsoo.sigschool.ui.controller;

import br.ufms.facom.apsoo.sigschool.model.dao.CoordenadorDAO;
import br.ufms.facom.apsoo.sigschool.model.dao.impl.CoordenadorDAOImpl;
import br.ufms.facom.apsoo.sigschool.model.entity.Coordenador;
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
public class CoordenadorMgrBean extends FormatarPDF implements Serializable
{

    private Coordenador coordenador;
    private CoordenadorDAO coordenadorDao;
    private String dataNascimento;

    @PostConstruct
    public void init()
    {
        coordenador = new Coordenador();
        coordenadorDao = new CoordenadorDAOImpl();
        dataNascimento = null;
    }

    public Coordenador getCoordenador() throws Exception
    {
        try
        {
            DateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
            dataNascimento = dataFormatada.format(coordenador.getDataNasc());
        }
        catch (Exception ex)
        {
            System.out.println("Erro");
        }
        return coordenador;
    }

    public void setCoordenador(Coordenador coordenador)
    {
        this.coordenador = coordenador;
    }

    public CoordenadorDAO getCoordenadorDao()
    {
        return coordenadorDao;
    }

    public void setCoordenadorDao(CoordenadorDAO coordenadorDao)
    {
        this.coordenadorDao = coordenadorDao;
    }

    public String getDataNascimento()
    {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento)
    {
        this.dataNascimento = dataNascimento;
    }

    public List<Coordenador> listarCoordenadores()
    {
        return coordenadorDao.list();
    }

    public String novoCoordenador()
    {
        coordenador = new Coordenador();
        dataNascimento = null;
        return "coordenadorform";
    }

    public String salvarCoordenador() throws ParseException
    {
        DateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
        try
        {
            Date date = dataFormatada.parse(dataNascimento);
            coordenador.setDataNasc(date);
        }
        catch (ParseException ex)
        {
            System.out.println("Erro conversão da data");
        }

        if (coordenador.getId() == null)
        {
            Coordenador c = new Coordenador();
            c = coordenadorDao.buscarCoordenadorPeloCPF(coordenador.getCpf());
            if (c != null)
            {
                FacesUtil.mensErro("Coordenador já Cadastrado!");
                return "coordenadorform";
            }
            coordenadorDao.create(coordenador);
        }
        else
        {
            coordenadorDao.update(coordenador);
        }
        return "coordenadores";
    }
}
