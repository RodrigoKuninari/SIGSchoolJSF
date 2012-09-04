package br.ufms.facom.apsoo.sigschool.model.dao.impl;

import br.ufms.facom.apsoo.sigschool.model.types.QueryParameter;
import br.ufms.facom.apsoo.sigschool.model.util.EntityManagerUtil;
import br.ufms.facom.apsoo.sigschool.model.dao.GenericDAO;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 * Classe abstrata parametrizada que implementa a interface Dao.
 *
 * @author Rodrigo Kuninari
 */
public abstract class GenericDAOImpl<T, ID extends Serializable> implements GenericDAO<T, ID>, Serializable {

    /**
     * Metodo para retornar a classe do parametro T
     *
     * @return Classe especificada por T
     */
    public abstract Class<T> getDomainClass();

    public EntityManager getEntityManager() {
        return EntityManagerUtil.getEntityManager();
    }

    @Override
    public void create(T obj) {
        EntityManagerUtil.insert(obj);

    }

    @Override
    public T retrieve(ID id) {
        return (T) getEntityManager().find(getDomainClass(), id);

    }

    @Override
    public List<T> list() {
        String queryS = "SELECT obj FROM " + getDomainClass().getSimpleName() + " obj";
        Query query = EntityManagerUtil.createQuery(queryS);

        try {
            return query.getResultList();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public T delete(T obj) {
        obj = (T) EntityManagerUtil.update(obj);
        EntityManagerUtil.remove(obj);

        return obj;

    }

    @Override
    public T update(T obj) {
        T objReturn = null;

        if (obj != null) {
            objReturn = (T) EntityManagerUtil.update(obj);
        }

        return objReturn;
    }

    @Override
    public Query createQuery(String query) {
        return EntityManagerUtil.createQuery(query);
    }

    @Override
    public Query createNamedQuery(String query) {
        return EntityManagerUtil.createNamedQuery(query);
    }
    
    @Override
    public T executeSingleResultQuery(QueryParameter parameter) {
        String sql = "SELECT o FROM " + getDomainClass().getSimpleName()
                + "AS o WHERE o." + parameter.getName() + " = :" + parameter.getValue();
        Query query = createQuery(sql);
        query.setParameter(parameter.getName(), parameter.getValue());

        try {
            return (T) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public List<T> executeNamedQuery(String namedQuery, QueryParameter parameter) {
        Query query = createNamedQuery(namedQuery);
        query.setParameter(parameter.getName(), parameter.getValue());

        try {
            return (List<T>) query.getResultList();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public T executeNamedQuerySingleResult(String namedQuery, QueryParameter parameter) {
        Query query = createNamedQuery(namedQuery);
        query.setParameter(parameter.getName(), parameter.getValue());

        try {
            return (T) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
    
    @Override
    public T executeQuery(String sql) {
        Query query = createQuery(sql);

        try {
            return (T) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @PreDestroy
    @Override
    public void finalizeAccess() {
        EntityManagerUtil.close();
    }
}
