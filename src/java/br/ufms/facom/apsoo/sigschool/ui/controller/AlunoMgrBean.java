/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.apsoo.sigschool.ui.controller;

import br.ufms.facom.apsoo.sigschool.model.dao.AlunoDAO;
import br.ufms.facom.apsoo.sigschool.model.dao.HistoricoDAO;
import br.ufms.facom.apsoo.sigschool.model.dao.ResponsavelDAO;
import br.ufms.facom.apsoo.sigschool.model.dao.impl.AlunoDAOImpl;
import br.ufms.facom.apsoo.sigschool.model.dao.impl.HistoricoDAOImpl;
import br.ufms.facom.apsoo.sigschool.model.dao.impl.ResponsavelDAOImpl;
import br.ufms.facom.apsoo.sigschool.model.entity.Aluno;
import br.ufms.facom.apsoo.sigschool.model.entity.Historico;
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
public class AlunoMgrBean extends FormatarPDF implements Serializable
{

    private Aluno aluno;
    private AlunoDAO alunoDao;
    private ResponsavelDAO responsavelDao;
    private String dataNascimento;
    private Historico historico;
    private HistoricoDAO historicoDao;

    @PostConstruct
    public void init()
    {
        aluno = new Aluno();
        alunoDao = new AlunoDAOImpl();
        responsavelDao = new ResponsavelDAOImpl();
        historico = new Historico();
        historicoDao = new HistoricoDAOImpl();
        dataNascimento = null;
    }

    public Aluno getAluno()
    {
        try
        {
            DateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
            dataNascimento = dataFormatada.format(aluno.getDataNasc());
        }
        catch (Exception ex)
        {
            System.out.println("Erro");
        }
        return aluno;
    }

    public void setAluno(Aluno aluno)
    {
        this.aluno = aluno;
    }

    public String getDataNascimento()
    {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento)
    {
        this.dataNascimento = dataNascimento;
    }

    public List<Aluno> listarAlunos()
    {
        return alunoDao.list();
    }

    public String novoAluno()
    {
        aluno = new Aluno();
        dataNascimento = null;
        return "alunoform";
    }

    public String salvarAluno()
    {
        DateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
        try
        {
            Date date = dataFormatada.parse(dataNascimento);
            aluno.setDataNasc(date);
        }
        catch (ParseException ex)
        {
            System.out.println("Erro conversão da data");
        }

        if (aluno.getId() == null)
        {
            Aluno a = new Aluno();
            a = alunoDao.buscarAlunoPelaMatricula(aluno.getMatricula());
            if(a != null)
            {
                FacesUtil.mensErro("Aluno já Cadastrado!");
                return "alunoform";
            }
            alunoDao.create(aluno);
            aluno.getResponsavel().adicionarAluno(aluno);
            historico = new Historico();
            historico.setSituacao("Esperando");
            historico.setAluno(aluno);
            historicoDao.create(historico);
        }
        else
        {
            alunoDao.update(aluno);
        }
        return "alunos";
    }

    public List<Responsavel> listarResponsaveisAtivos()
    {
        return responsavelDao.buscarResponsaveisAtivos(true);
    }
}
