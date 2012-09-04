/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.apsoo.sigschool.ui.controller;

import br.ufms.facom.apsoo.sigschool.model.dao.AvaliacaoDAO;
import br.ufms.facom.apsoo.sigschool.model.dao.ProfessorDisciplinaDAO;
import br.ufms.facom.apsoo.sigschool.model.dao.impl.AvaliacaoDAOImpl;
import br.ufms.facom.apsoo.sigschool.model.dao.impl.ProfessorDisciplinaDAOImpl;
import br.ufms.facom.apsoo.sigschool.model.entity.Avaliacao;
import br.ufms.facom.apsoo.sigschool.model.entity.ProfessorDisciplina;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.DateSelectEvent;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.ScheduleEntrySelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

/**
 *
 * @author Rodrigo Kuninari
 */
@ManagedBean
@SessionScoped
public class AvaliacaoMgrBean extends FormatarPDF implements Serializable
{

    private Avaliacao avaliacao;
    private AvaliacaoDAO avaliacaoDao;
    private ProfessorDisciplinaDAO professorDisciplinaDao;
    private ScheduleModel eventModel;
    private ScheduleEvent event = new DefaultScheduleEvent();
    private ScheduleModel lazyEventModel;
    private String theme;

    @PostConstruct
    public void init()
    {
        avaliacao = new Avaliacao();
        avaliacaoDao = new AvaliacaoDAOImpl();
        professorDisciplinaDao = new ProfessorDisciplinaDAOImpl();
        montarCalendario();
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

    public ScheduleModel getEventModel()
    {
        montarCalendario();
        return eventModel;
    }

    public void setEventModel(ScheduleModel eventModel)
    {
        this.eventModel = eventModel;
    }

    public ScheduleEvent getEvent()
    {
        return event;
    }

    public void setEvent(ScheduleEvent event)
    {
        this.event = event;
    }

    public ScheduleModel getLazyEventModel()
    {
        return lazyEventModel;
    }

    public void setLazyEventModel(ScheduleModel lazyEventModel)
    {
        this.lazyEventModel = lazyEventModel;
    }

    public String getTheme()
    {
        return theme;
    }

    public void setTheme(String theme)
    {
        this.theme = theme;
    }

    public List<Avaliacao> listarAvaliacoes()
    {
        return avaliacaoDao.list();
    }

    public String novaAvaliacao()
    {
        avaliacao = new Avaliacao();
        return "avaliacaoform";
    }

    public String salvarAvaliacao()
    {
        if (avaliacao.getId() == null)
        {
            avaliacaoDao.create(avaliacao);
        }
        else
        {
            avaliacaoDao.update(avaliacao);
        }
        return "avaliacoes";
    }

    public List<ProfessorDisciplina> listarProfessorDisciplinas()
    {
        return professorDisciplinaDao.list();
    }

    public List<Avaliacao> listarAvaliacoesAprovadas()
    {
        return avaliacaoDao.buscarAvaliacoesAprovadas(true);
    }

    public void onEventSelect(ScheduleEntrySelectEvent selectEvent)
    {
        event = selectEvent.getScheduleEvent();
    }

    public void onDateSelect(DateSelectEvent selectEvent)
    {
        event = new DefaultScheduleEvent(Math.random() + "", selectEvent.getDate(), selectEvent.getDate());
    }

    public void onEventMove(ScheduleEntryMoveEvent event)
    {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());

        addMessage(message);
    }

    public void onEventResize(ScheduleEntryResizeEvent event)
    {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());

        addMessage(message);
    }

    private void addMessage(FacesMessage message)
    {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void montarCalendario()
    {
        eventModel = new DefaultScheduleModel();
        List<Avaliacao> avaliacoes = listarAvaliacoesAprovadas();
        for (Avaliacao a : avaliacoes)
        {
            String evento = a.getProfessorDisciplina().getProfessor().getNome() + " - "
                            + a.getProfessorDisciplina().getDisciplina().getNome() + "\n"
                            + a.getNome() + " - " + a.getDescricao();
            eventModel.addEvent(new DefaultScheduleEvent(evento, a.getData(), a.getData(), true));
        }
    }
}
