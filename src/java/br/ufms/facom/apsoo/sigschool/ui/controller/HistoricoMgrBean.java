/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.apsoo.sigschool.ui.controller;

import br.ufms.facom.apsoo.sigschool.model.dao.DisciplinaDAO;
import br.ufms.facom.apsoo.sigschool.model.dao.impl.DisciplinaDAOImpl;
import br.ufms.facom.apsoo.sigschool.model.entity.Disciplina;
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
public class HistoricoMgrBean extends FormatarPDF implements Serializable
{

    private Disciplina disciplina;
    private DisciplinaDAO disciplinaDao;

    @PostConstruct
    public void init()
    {
        disciplina = new Disciplina();
        disciplinaDao = new DisciplinaDAOImpl();
    }

    public Disciplina getDisciplina()
    {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina)
    {
        this.disciplina = disciplina;
    }

    public List<Disciplina> listarDisciplinas()
    {
        return disciplinaDao.list();
    }

    public String novaDisciplina()
    {
        disciplina = new Disciplina();
        return "disciplinaform";
    }

    public String salvarDisciplina()
    {
        if (disciplina.getId() == null)
        {
            disciplinaDao.create(disciplina);
        }
        else
        {
            disciplinaDao.update(disciplina);
        }
        return "disciplinas";
    }
    
    public List<Disciplina> listarDisciplinasAtivas()
    {
        return disciplinaDao.buscarDisciplinasAtivas(true);
    }
}
