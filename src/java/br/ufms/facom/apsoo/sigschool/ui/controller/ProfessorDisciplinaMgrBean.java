/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.apsoo.sigschool.ui.controller;

import br.ufms.facom.apsoo.sigschool.model.dao.CoordenadorTurmaDAO;
import br.ufms.facom.apsoo.sigschool.model.dao.DisciplinaDAO;
import br.ufms.facom.apsoo.sigschool.model.dao.ProfessorDAO;
import br.ufms.facom.apsoo.sigschool.model.dao.ProfessorDisciplinaDAO;
import br.ufms.facom.apsoo.sigschool.model.dao.impl.CoordenadorTurmaDAOImpl;
import br.ufms.facom.apsoo.sigschool.model.dao.impl.DisciplinaDAOImpl;
import br.ufms.facom.apsoo.sigschool.model.dao.impl.ProfessorDAOImpl;
import br.ufms.facom.apsoo.sigschool.model.dao.impl.ProfessorDisciplinaDAOImpl;
import br.ufms.facom.apsoo.sigschool.model.entity.CoordenadorTurma;
import br.ufms.facom.apsoo.sigschool.model.entity.Disciplina;
import br.ufms.facom.apsoo.sigschool.model.entity.Professor;
import br.ufms.facom.apsoo.sigschool.model.entity.ProfessorDisciplina;
import br.ufms.facom.apsoo.sigschool.model.util.FacesUtil;
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
public class ProfessorDisciplinaMgrBean extends FormatarPDF implements Serializable
{

    private ProfessorDisciplina professorDisciplina;
    private ProfessorDisciplinaDAO professorDisciplinaDao;
    private ProfessorDAO professorDAO;
    private CoordenadorTurmaDAO coordenadorTurmaDao;
    private DisciplinaDAO disciplinaDao;

    @PostConstruct
    public void init()
    {
        professorDisciplina = new ProfessorDisciplina();
        professorDisciplinaDao = new ProfessorDisciplinaDAOImpl();
        professorDAO = new ProfessorDAOImpl();
        coordenadorTurmaDao = new CoordenadorTurmaDAOImpl();
        disciplinaDao = new DisciplinaDAOImpl();
    }

    public ProfessorDAO getProfessorDAO()
    {
        return professorDAO;
    }

    public void setProfessorDAO(ProfessorDAO professorDAO)
    {
        this.professorDAO = professorDAO;
    }

    public ProfessorDisciplina getProfessorDisciplina()
    {
        return professorDisciplina;
    }

    public void setProfessorDisciplina(ProfessorDisciplina professorDisciplina)
    {
        this.professorDisciplina = professorDisciplina;
    }

    public ProfessorDisciplinaDAO getProfessorDisciplinaDao()
    {
        return professorDisciplinaDao;
    }

    public void setProfessorDisciplinaDao(ProfessorDisciplinaDAO professorDisciplinaDao)
    {
        this.professorDisciplinaDao = professorDisciplinaDao;
    }

    public List<ProfessorDisciplina> listarProfessorDisciplinas()
    {
        return professorDisciplinaDao.list();
    }

    public String novoProfessorDisciplina()
    {
        professorDisciplina = new ProfessorDisciplina();
        return "professordisciplinaform";
    }

    public String salvarProfessorDisciplina()
    {
        if (professorDisciplina.getId() == null)
        {
            ProfessorDisciplina pd = new ProfessorDisciplina();
            pd = professorDisciplinaDao.buscarProfessorDisciplina(professorDisciplina.getCoordenadorTurma().getId(), professorDisciplina.getProfessor().getId(), professorDisciplina.getDisciplina().getId());
            if(pd != null)
            {
                FacesUtil.mensErro("Professor com Disciplina já Definida!");
                return "professordisciplinaform";
            }
            professorDisciplinaDao.create(professorDisciplina);
            professorDisciplina.getProfessor().adicionarProfessorDisciplina(professorDisciplina);
            professorDisciplina.getCoordenadorTurma().adicionarProfessorDisciplina(professorDisciplina);
            professorDisciplina.getDisciplina().adicionarProfessorDisciplina(professorDisciplina);
        }
        else
        {
            professorDisciplinaDao.update(professorDisciplina);
        }
        return "professordisciplinas";
    }

    public List<Professor> listarProfessoresAtivos()
    {
        return professorDAO.buscarProfessoresAtivos(true);
    }
    
    public List<CoordenadorTurma> listarCoordenadorTurmas()
    {
        return coordenadorTurmaDao.list();
    }
    
    public List<Disciplina> listarDisciplinasAtivas()
    {
        return disciplinaDao.buscarDisciplinasAtivas(true);
    }
    
    public List<ProfessorDisciplina> listarProfessorDisciplinaPorCoordenadorTurma(CoordenadorTurma coordenadorTurma)
    {
        return professorDisciplinaDao.buscarProfessorDisciplinaPorCoordenadorTurma(coordenadorTurma);
    }

}
