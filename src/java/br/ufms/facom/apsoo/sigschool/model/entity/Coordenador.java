/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.apsoo.sigschool.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Rodrigo Kuninari
 */
@Entity
@Table(name = "tb_coordenador")
@NamedQueries({
@NamedQuery(name = "Coordenador.buscarCoordenadorPeloCPF", query = "SELECT c FROM Coordenador AS c WHERE c.cpf = :cpf ORDER BY c.nome"),
@NamedQuery(name = "Coordenador.buscarCoordenadoresAtivos", query = "SELECT c FROM Coordenador AS c WHERE c.ativo = :ativo ORDER BY c.nome")})
public class Coordenador extends Funcionario implements Serializable
{

    @OneToMany(mappedBy = "coordenador")
    private List<CoordenadorTurma> coordenadorTurmas = new ArrayList<CoordenadorTurma>();

    public Coordenador()
    {
    }

    public Coordenador(String nome, Date dataNasc, String sexo, String telRes, String telCel, String email, String endereco, boolean ativo, String cpf, String rg, String matricula, String curriculum)
    {
        super(nome, dataNasc, sexo, telRes, telCel, email, endereco, ativo, cpf, rg, matricula, curriculum);
    }

    public List<CoordenadorTurma> getCoordenadorTurmas()
    {
        return coordenadorTurmas;
    }

    public void setCoordenadorTurmas(List<CoordenadorTurma> coordenadorTurmas)
    {
        this.coordenadorTurmas = coordenadorTurmas;
    }
    
    public void adicionarCoordenadorTurma(CoordenadorTurma coordenadorTurma)
    {
        coordenadorTurmas.add(coordenadorTurma);
    }
}