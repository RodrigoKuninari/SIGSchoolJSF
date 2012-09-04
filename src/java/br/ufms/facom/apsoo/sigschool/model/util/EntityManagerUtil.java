package br.ufms.facom.apsoo.sigschool.model.util;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * Singleton que realiza as operacoes basicas para persistencia
 * dos dados no banco. Inicializa uma EntityManager a partir da unidade de persistencia
 * declarada nas constante CONFIG_PERSISTENCE_UNIT_NAME
 *
 * @author Rodrigo Kuninari
 */
public class EntityManagerUtil {

    private static EntityManagerFactory emf;
    private static EntityManager em;

    @PostConstruct
    public static void init() {
        if (!isOpen()) {
            emf = Persistence.createEntityManagerFactory("SIGSchoolPU");
            em = emf.createEntityManager();
        }
    }

    /**
     * Metodo para retornar a EntityManager criada
     *
     * @return EntityManager criada a partir da unidade de persistencia
     */
    public static EntityManager getEntityManager() {
        init();
        return em;
    }

    /**
     * Metodo para iniciar uma transacao no banco. Necessaria para operacoes
     * transacionais.
     */
    public static void beginTransaction() {
        init();
        if (!isTransactionActive()) {
            em.getTransaction().begin();
        }
    }

    /**
     * Metodo para verificar se a transacao esta ativa.
     * @return True caso esteja ativa a transacao. False caso contrario.
     */
    public static boolean isTransactionActive() {
        init();
        return em.getTransaction().isActive();
    }

    /**
     * Metodo para dar commit na transacao.
     */
    public static void commit() {
        init();
        em.getTransaction().commit();
    }

    /**
     * Metodo para inserir um novo objeto no banco.
     * 
     * @param obj Objeto a ser inserido
     */
    public static void insert(Object obj) {
        init();
        beginTransaction();
        em.persist(obj);
        commit();
    }

    /**
     * Metodo para criar uma query a ser executada no banco.
     * 
     * @param query String que representa a query
     * @return Query criada
     */
    public static Query createQuery(String query) {
        init();
        return em.createQuery(query);
    }

    public static Query createNamedQuery(String namedQuery) {
        init();
        return em.createNamedQuery(namedQuery);
    }

    /**
     * Metodo para atualizar um determinado objeto no banco.
     * 
     * @param obj Objeto a ser atualizado
     * @return Objeto atualizado
     */
    public static Object update(Object obj) {
        init();
        beginTransaction();
        Object object = em.merge(obj);
        commit();
        return object;
    }

    /**
     * Metodo para remover um determinado objeto do banco.
     * 
     * @param obj Objeto a ser removido.
     */
    public static void remove(Object obj) {
        init();
        beginTransaction();
        em.remove(obj);
        commit();
    }
    
    @PreDestroy
    public static void close() {
        if (em.isOpen()) {
            em.close();
        }

        if (emf.isOpen()) {
            emf.close();
        }
    }

    private static boolean isOpen() {
        if (emf != null) {
            return emf.isOpen();
        }

        return false;
    }
}
