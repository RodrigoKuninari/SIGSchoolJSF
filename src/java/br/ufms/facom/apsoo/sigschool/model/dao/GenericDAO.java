package br.ufms.facom.apsoo.sigschool.model.dao;

import br.ufms.facom.apsoo.sigschool.model.types.QueryParameter;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;

/**
 * DAO - Data Access Object <br>
 * Interface que descreve a assinatura da operacoes basicas que cada entidade
 * do banco ira realizar. Operacoes do CRUD e mais uma de listagem.
 * 
 * @author Rodrigo Kuninari
 */
public interface GenericDAO<T, ID extends Serializable> {

    /**
     * Metodo para inserir um novo objeto do tipo T no banco.
     * 
     * @param obj Objeto a ser inserido no banco.
     */
    public void create(T obj);

    /**
     * Metodo para consultar um objeto especificado pela id.
     *
     * @param id Identificacao do objeto.
     * @return Objeto consultado.
     */
    public T retrieve(ID id);

    /**
     * Metodo para atualizar um objeto no banco.
     *
     * @param obj
     * @return Objeto atualizado.
     */
    public T update(T obj);

    public T delete(T obj);

    /* public T delete(T obj); */
    /**
     * Metodo para listar todos os objetos do tipo T contidos no banco.
     *
     * @return Lista contendo objetos do tipo T.
     */
    public List<T> list();

    public Query createQuery(String query);

    public Query createNamedQuery(String query);

    public T executeSingleResultQuery(QueryParameter parameter);

    public List<T> executeNamedQuery(String namedQuery, QueryParameter parameter);

    public T executeNamedQuerySingleResult(String namedQuery, QueryParameter parameter);
    
    public T executeQuery(String sql);

    public void finalizeAccess();
}
