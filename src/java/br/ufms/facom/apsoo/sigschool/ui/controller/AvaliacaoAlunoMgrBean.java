/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.apsoo.sigschool.ui.controller;

import br.ufms.facom.apsoo.sigschool.model.dao.AvaliacaoAlunoDAO;
import br.ufms.facom.apsoo.sigschool.model.dao.impl.AvaliacaoAlunoDAOImpl;
import br.ufms.facom.apsoo.sigschool.model.entity.AvaliacaoAluno;
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
public class AvaliacaoAlunoMgrBean extends FormatarPDF implements Serializable
{

    private AvaliacaoAluno avaliacaoAluno;
    private AvaliacaoAlunoDAO avaliacaoAlunoDao;

    @PostConstruct
    public void init()
    {
        avaliacaoAluno = new AvaliacaoAluno();
        avaliacaoAlunoDao = new AvaliacaoAlunoDAOImpl();
    }

    public AvaliacaoAluno getAvaliacaoAluno()
    {
        return avaliacaoAluno;
    }

    public void setAvaliacaoAluno(AvaliacaoAluno avaliacaoAluno)
    {
        this.avaliacaoAluno = avaliacaoAluno;
    }

    public AvaliacaoAlunoDAO getAvaliacaoAlunoDao()
    {
        return avaliacaoAlunoDao;
    }

    public void setAvaliacaoAlunoDao(AvaliacaoAlunoDAO avaliacaoAlunoDao)
    {
        this.avaliacaoAlunoDao = avaliacaoAlunoDao;
    }

    public List<AvaliacaoAluno> listarAvaliacaoAlunos()
    {
        return avaliacaoAlunoDao.list();
    }

    public String novaAvaliacaoAluno()
    {
        avaliacaoAluno = new AvaliacaoAluno();
        return "avaliacaoalunoform";
    }

    public String salvarAvaliacaoAluno()
    {
        avaliacaoAlunoDao.update(avaliacaoAluno);
        return "avaliacaoalunos";
    }

    public List<AvaliacaoAluno> buscarAvaliacoesAlunosAtivos(boolean ativo)
    {
        return avaliacaoAlunoDao.buscarAvaliacaoAlunosAtivos(ativo);
    }
}
