/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.apsoo.sigschool.ui.controller;

import br.ufms.facom.apsoo.sigschool.model.dao.*;
import br.ufms.facom.apsoo.sigschool.model.dao.impl.*;
import br.ufms.facom.apsoo.sigschool.model.entity.*;
import java.io.Serializable;
import java.util.*;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author Rodrigo Kuninari
 */
@ManagedBean
@SessionScoped
public class TurmaMgrBean extends FormatarPDF implements Serializable
{

    private Turma turma;

    private TurmaDAO turmaDao;

    private CoordenadorTurmaDAO coordenadorTurmaDao;

    private HistoricoDAO historicoDao;

    private Set<Historico> listHistorico = Collections.synchronizedSet(new HashSet<Historico>());

    private CoordenadorTurma coordenadorTurma;

    private ProfessorDisciplinaDAO professorDisciplinaDao;

    private HistoricoNotasDAO historicoNotasDao;

    @PostConstruct
    public void init()
    {
        turma = new Turma();
        turmaDao = new TurmaDAOImpl();
        coordenadorTurmaDao = new CoordenadorTurmaDAOImpl();
        historicoDao = new HistoricoDAOImpl();
        professorDisciplinaDao = new ProfessorDisciplinaDAOImpl();
        historicoNotasDao = new HistoricoNotasDAOImpl();
    }

    public Turma getTurma()
    {
        return turma;
    }

    public void setTurma(Turma turma)
    {
        this.turma = turma;
    }

    public TurmaDAO getTurmaDao()
    {
        return turmaDao;
    }

    public void setTurmaDao(TurmaDAO turmaDao)
    {
        this.turmaDao = turmaDao;
    }

    public List<Turma> listarTurmas()
    {
        return turmaDao.list();
    }

    public String novaTurma()
    {
        turma = new Turma();
        return "turmaform";
    }

    public String salvarTurma()
    {
        for (Historico h : getSelectedRoles())
        {
            turma = new Turma();
            turma.setHistorico(h);
            turma.setCoordenadorTurma(coordenadorTurma);
            turma.getHistorico().setSituacao("Cursando");
            turmaDao.create(turma);
            turma.getCoordenadorTurma().adicionarTurma(turma);
            turma.getHistorico().adicionarTurma(turma);
            List<ProfessorDisciplina> professorDisciplinas = new ArrayList<ProfessorDisciplina>();
            professorDisciplinas = professorDisciplinaDao.buscarProfessorDisciplinaPorCoordenadorTurma(coordenadorTurma);
            for (ProfessorDisciplina pd : professorDisciplinas)
            {
                HistoricoNotas historicoNotas = new HistoricoNotas(0, pd, turma.getHistorico());
                historicoNotasDao.create(historicoNotas);
                pd.adicionarHistoricoNotas(historicoNotas);
            }
        }
        return "turmas";
    }

    public List<CoordenadorTurma> listarCoordenadorTurmas()
    {
        return coordenadorTurmaDao.list();
    }

    public Historico[] getSelectedRoles()
    {
        return (Historico[]) this.listHistorico.toArray(new Historico[0]);
    }

    public void setSelectedRoles(Historico[] historicos)
    {
        this.listHistorico.clear();
        this.listHistorico.addAll(Arrays.asList(historicos));
    }

    public Set<Historico> getListHistorico()
    {
        List<Historico> list = historicoDao.buscarHistoricosPelaSituacao("Esperando");

        listHistorico = new TreeSet<Historico>(list);

        return listHistorico;
    }

    public CoordenadorTurma getCoordenadorTurma()
    {
        return coordenadorTurma;
    }

    public void setCoordenadorTurma(CoordenadorTurma coordenadorTurma)
    {
        this.coordenadorTurma = coordenadorTurma;
    }

    public List<SelectItem> getAllHistorico()
    {
        List<Historico> list = historicoDao.buscarHistoricosPelaSituacao("Esperando");
        List<SelectItem> itens = new ArrayList<SelectItem>();
        for (Historico h : list)
        {
            SelectItem item = new SelectItem(h, h.getAluno().getNome());
            itens.add(item);
        }
        return itens;
    }

}
