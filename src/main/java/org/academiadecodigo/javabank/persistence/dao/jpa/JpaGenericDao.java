package org.academiadecodigo.javabank.persistence.dao.jpa;

import org.academiadecodigo.javabank.model.AbstractModel;
import org.academiadecodigo.javabank.persistence.dao.DAO;
import org.academiadecodigo.javabank.persistence.managers.SessionManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.RollbackException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class JpaGenericDao<T extends AbstractModel> implements DAO<T> {

    private SessionManager<EntityManager> sessionManager;
    private Class<T> modelType;

    public JpaGenericDao(SessionManager sessionManager, Class<T> modelType){
        this.sessionManager = sessionManager;
        this.modelType = modelType;
    }

    @Override
    public List<T> findAll() {

        EntityManager em = sessionManager.getCurrentSession();

        CriteriaQuery<T> criteriaQuery = em.getCriteriaBuilder().createQuery(modelType);
        criteriaQuery.from(modelType);

        return em.createQuery(criteriaQuery).getResultList();

    }

    @Override
    public T findById(Integer id) {

        EntityManager em = sessionManager.getCurrentSession();

        return em.find(modelType, id);

    }

    @Override
    public T saveOrUpdate(T modelObject) {

        EntityManager em = sessionManager.getCurrentSession();
        T savedObject = em.merge(modelObject);

        return savedObject;

    }

    @Override
    public void delete(Integer id) {

        EntityManager em = sessionManager.getCurrentSession();
        em.remove(em.find(modelType, id));

    }
}
