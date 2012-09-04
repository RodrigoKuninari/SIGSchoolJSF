/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.apsoo.sigschool.ui.controller;

import br.ufms.facom.apsoo.sigschool.model.dao.ProfessorDAO;
import br.ufms.facom.apsoo.sigschool.model.dao.impl.ProfessorDAOImpl;
import br.ufms.facom.apsoo.sigschool.model.entity.Professor;
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
public class ProfessorMgrBean extends FormatarPDF implements Serializable
{

    private Professor professor;
    private ProfessorDAO professorDao;
    private String dataNascimento;

    @PostConstruct
    public void init()
    {
        professor = new Professor();
        professorDao = new ProfessorDAOImpl();
        dataNascimento = null;
    }

    public Professor getProfessor() throws Exception
    {
        try
        {
            DateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
            dataNascimento = dataFormatada.format(professor.getDataNasc());
        }
        catch (Exception ex)
        {
            System.out.println("Erro");
        }
        return professor;
    }

    public void setProfessor(Professor professor)
    {
        this.professor = professor;
    }

    public ProfessorDAO getProfessorDao()
    {
        return professorDao;
    }

    public void setProfessorDao(ProfessorDAO professorDao)
    {
        this.professorDao = professorDao;
    }

    public String getDataNascimento()
    {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento)
    {
        this.dataNascimento = dataNascimento;
    }

    public List<Professor> listarProfessores()
    {
        return professorDao.list();
    }

    public String novoProfessor()
    {
        professor = new Professor();
        dataNascimento = null;
        return "professorform";
    }

    public String salvarProfessor() throws ParseException
    {
        DateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
        try
        {
            Date date = dataFormatada.parse(dataNascimento);
            professor.setDataNasc(date);
        }
        catch (ParseException ex)
        {
            System.out.println("Erro conversão da data");
        }

        if (professor.getId() == null)
        {
            Professor p = new Professor();
            p = professorDao.buscarProfessorPeloCPF(professor.getCpf());
            if(p != null)
            {
                FacesUtil.mensErro("Professor já Cadastrado!");
                return "professorform";
            }
            professorDao.create(professor);
        }
        else
        {
            professorDao.update(professor);
        }
        return "professores";
    }
}
