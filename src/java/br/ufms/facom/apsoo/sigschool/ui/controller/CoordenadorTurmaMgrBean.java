/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.apsoo.sigschool.ui.controller;

import br.ufms.facom.apsoo.sigschool.model.dao.CoordenadorDAO;
import br.ufms.facom.apsoo.sigschool.model.dao.CoordenadorTurmaDAO;
import br.ufms.facom.apsoo.sigschool.model.dao.impl.CoordenadorDAOImpl;
import br.ufms.facom.apsoo.sigschool.model.dao.impl.CoordenadorTurmaDAOImpl;
import br.ufms.facom.apsoo.sigschool.model.entity.Coordenador;
import br.ufms.facom.apsoo.sigschool.model.entity.CoordenadorTurma;
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
public class CoordenadorTurmaMgrBean extends FormatarPDF implements Serializable
{

    private CoordenadorTurma coordenadorTurma;
    private CoordenadorTurmaDAO coordenadorTurmaDao;
    private CoordenadorDAO coordenadorDao;

    @PostConstruct
    public void init()
    {
        coordenadorTurma = new CoordenadorTurma();
        coordenadorTurmaDao = new CoordenadorTurmaDAOImpl();
        coordenadorDao = new CoordenadorDAOImpl();
    }

    public CoordenadorTurma getCoordenadorTurma()
    {
        return coordenadorTurma;
    }

    public void setCoordenadorTurma(CoordenadorTurma coordenadorTurma)
    {
        this.coordenadorTurma = coordenadorTurma;
    }

    public CoordenadorTurmaDAO getCoordenadorTurmaDao()
    {
        return coordenadorTurmaDao;
    }

    public void setCoordenadorTurmaDao(CoordenadorTurmaDAO coordenadorTurmaDao)
    {
        this.coordenadorTurmaDao = coordenadorTurmaDao;
    }

    public List<CoordenadorTurma> listarCoordenadorTurmas()
    {
        return coordenadorTurmaDao.list();
    }

    public String novoCoordenadorTurma()
    {
        coordenadorTurma = new CoordenadorTurma();
        return "coordenadorturmaform";
    }

    public String salvarCoordenadorTurma()
    {
        if (coordenadorTurma.getId() == null)
        {
            CoordenadorTurma ct = new CoordenadorTurma();
            ct = coordenadorTurmaDao.buscarCoordenadorTurma(coordenadorTurma.getCoordenador().getId(), coordenadorTurma.getAno(), coordenadorTurma.getSerie());
            if(ct != null)
            {
                FacesUtil.mensErro("Turma com Coordenador já Definida!");
                return "coordenadorturmaform";
            }
            coordenadorTurmaDao.create(coordenadorTurma);
            coordenadorTurma.getCoordenador().adicionarCoordenadorTurma(coordenadorTurma);
        }
        else
        {
            coordenadorTurmaDao.update(coordenadorTurma);
        }
        return "coordenadorturmas";
    }
    
    public List<Coordenador> listarCoordenadoresAtivos()
    {
        return coordenadorDao.buscarCoordenadoresAtivos(true);
    }
}
