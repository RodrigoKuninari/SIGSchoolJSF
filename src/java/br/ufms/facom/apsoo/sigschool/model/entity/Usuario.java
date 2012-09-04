package br.ufms.facom.apsoo.sigschool.model.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Classe entidade que representa um usuário do 
 * sistema. É composto por um nome de login e uma senha.
 * O atributo nome define a unicidade de um usuário, ou seja, para cada usuário
 * existirá somente um nome de login.
 *
 * Possui uma NamedQuery (Usuario.buscarUsuarioPeloNome) que será utilizada para consultar
 * um usuário a partir de um nome de login.
 *
 * @author Rodrigo Kuninari
 */
@Entity
@Table(name = "tb_usuario")
@NamedQuery(name = "Usuario.buscarUsuarioPeloNomeLogin",
query = "SELECT u FROM Usuario AS u WHERE u.nomeLogin = :usuarioNomeLogin")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    /**
     * Nome de login do usuário
     */
    @Column(length = 20, nullable = false)
    private String nomeLogin;
    /**
     * Senha do usuário
     */
    @Column(length = 64, nullable = false)
    private String senha;

    /*
     *
     * GETTERS e SETTERS
     *
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeLogin() {
        return nomeLogin;
    }

    public void setNomeLogin(String nome) {
        this.nomeLogin = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    /**
     * Método para retornar uma representação dos dados do usuário em modo texto
     * 
     * @return String contendo os dados do usuário
     */
    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nomeLogin=" + nomeLogin + '}';
    }
}
