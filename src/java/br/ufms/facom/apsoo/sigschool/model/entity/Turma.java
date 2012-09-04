/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.apsoo.sigschool.model.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Rodrigo Kuninari
 */
@Entity
@Table(name = "tb_turma")
public class Turma implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false)
    private Long id;

    @JoinColumn(name = "historico")
    @ManyToOne
    private Historico historico;

    @JoinColumn(name = "coordenador_turma")
    @ManyToOne
    private CoordenadorTurma coordenadorTurma;

    public Turma()
    {
    }

    public Turma(Historico historico, CoordenadorTurma coordenadorTurma)
    {
        this.historico = historico;
        this.coordenadorTurma = coordenadorTurma;
    }

    public CoordenadorTurma getCoordenadorTurma()
    {
        return coordenadorTurma;
    }

    public void setCoordenadorTurma(CoordenadorTurma coordenadorTurma)
    {
        this.coordenadorTurma = coordenadorTurma;
    }

    public Historico getHistorico()
    {
        return historico;
    }

    public void setHistorico(Historico historico)
    {
        this.historico = historico;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

}
