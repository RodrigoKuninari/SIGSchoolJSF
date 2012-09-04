/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.apsoo.sigschool.ui.controller;

import br.ufms.facom.apsoo.sigschool.model.dao.AvaliacaoAlunoDAO;
import br.ufms.facom.apsoo.sigschool.model.dao.AvaliacaoDAO;
import br.ufms.facom.apsoo.sigschool.model.dao.HistoricoNotasDAO;
import br.ufms.facom.apsoo.sigschool.model.dao.ProfessorDisciplinaDAO;
import br.ufms.facom.apsoo.sigschool.model.dao.impl.AvaliacaoAlunoDAOImpl;
import br.ufms.facom.apsoo.sigschool.model.dao.impl.AvaliacaoDAOImpl;
import br.ufms.facom.apsoo.sigschool.model.dao.impl.HistoricoNotasDAOImpl;
import br.ufms.facom.apsoo.sigschool.model.dao.impl.ProfessorDisciplinaDAOImpl;
import br.ufms.facom.apsoo.sigschool.model.entity.Avaliacao;
import br.ufms.facom.apsoo.sigschool.model.entity.AvaliacaoAluno;
import br.ufms.facom.apsoo.sigschool.model.entity.HistoricoNotas;
import br.ufms.facom.apsoo.sigschool.model.entity.ProfessorDisciplina;
import java.io.Serializable;
import java.util.ArrayList;
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
public class AvaliacaoProfessorMgrBean extends FormatarPDF implements Serializable
{

    private Avaliacao avaliacao;
    private AvaliacaoDAO avaliacaoDao;
    private ProfessorDisciplinaDAO professorDisciplinaDao;
    private HistoricoNotasDAO historicoNotasDao;
    private AvaliacaoAlunoDAO avaliacaoAlunoDao;

    @PostConstruct
    public void init()
    {
        avaliacao = new Avaliacao();
        avaliacaoDao = new AvaliacaoDAOImpl();
        professorDisciplinaDao = new ProfessorDisciplinaDAOImpl();
        historicoNotasDao = new HistoricoNotasDAOImpl();
        avaliacaoAlunoDao = new AvaliacaoAlunoDAOImpl();
    }

    public ProfessorDisciplinaDAO getProfessorDisciplinaDao()
    {
        return professorDisciplinaDao;
    }

    public void setProfessorDisciplinaDao(ProfessorDisciplinaDAO professorDisciplinaDao)
    {
        this.professorDisciplinaDao = professorDisciplinaDao;
    }

    public Avaliacao getAvaliacao()
    {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao)
    {
        this.avaliacao = avaliacao;
    }

    public AvaliacaoDAO getAvaliacaoDao()
    {
        return avaliacaoDao;
    }

    public void setAvaliacaoDao(AvaliacaoDAO avaliacaoDao)
    {
        this.avaliacaoDao = avaliacaoDao;
    }

    public List<Avaliacao> listarAvaliacoes()
    {
        return avaliacaoDao.list();
    }

    public String novaAvaliacao()
    {
        avaliacao = new Avaliacao();
        return "avaliacaoformprofessor";
    }

    public String salvarAvaliacao()
    {
        if (avaliacao.getId() == null)
        {
            avaliacaoDao.create(avaliacao);
            avaliacao.getProfessorDisciplina().adicionarAvaliacao(avaliacao);
            List<HistoricoNotas> historicoNotas = new ArrayList<HistoricoNotas>();
            historicoNotas = historicoNotasDao.buscarHistoricoNotasPeloProfessorDisciplina(avaliacao.getProfessorDisciplina());
            for(HistoricoNotas hd : historicoNotas)
            {
                AvaliacaoAluno avaliacaoAluno = new AvaliacaoAluno(0, hd, avaliacao);
                avaliacaoAlunoDao.create(avaliacaoAluno);
                avaliacaoAluno.getHistoricoNotas().adicionarAvaliacaoAluno(avaliacaoAluno);
                avaliacaoAluno.getAvaliacao().adicionarAvaliacaoAluno(avaliacaoAluno);
            }
            
        }
        else
        {
            avaliacaoDao.update(avaliacao);
        }
        return "avaliacoesprofessor";
    }

    public List<ProfessorDisciplina> listarProfessorDisciplinas()
    {
        return professorDisciplinaDao.list();
    }
}
