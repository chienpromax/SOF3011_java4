package edu.poly.dao;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public abstract class AbstractEntityDao<T> {
    private Class<T> entityClass;

    public AbstractEntityDao(Class<T> cls) {
        this.entityClass = cls;
    }

    public void insert(T entity) {
        EntityManager em = jpaUtils.getEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(entity);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        } finally {
            em.close();
        }
    }
    public void update(T entity) {
        EntityManager em = jpaUtils.getEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(entity);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        } finally {
            em.close();
        }
    }
    public void delete(Object id) {
        EntityManager em = jpaUtils.getEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            T entity = em.find(entityClass, id);
            em.remove(entity);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        } finally {
            em.close();
        }
    }
    public T findById(Object id) {
        EntityManager em = jpaUtils.getEntityManager();
        T entity = em.find(entityClass, id);
        return entity;
    }
    
	public List<T> findAll() {
		EntityManager em = jpaUtils.getEntityManager();
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			cq.select(cq.from(entityClass));
			return em.createQuery(cq).getResultList();
		} finally {
			em.close();
		}
	}
//    public List<T> findAll(boolean all, int firstResult, int maxResult) {
//        EntityManager em = jpaUtils.getEntityManager();
//        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
//        cq.select(cq.from(entityClass));
//        Query q = em.createQuery(cq);
//        if (!all) {
//        	q.setFirstResult(firstResult);
//        	q.setMaxResult(maxResult);
//		}
//        return q.getResultList();
//    }
    public List<T> findAll(boolean all, int firstResult, int maxResult) {
        EntityManager em = jpaUtils.getEntityManager();
        try {
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<T> cq = cb.createQuery(entityClass);
			Root<T> root = cq.from(entityClass);
			cq.select(root);
			
			TypedQuery<T> q = em.createQuery(cq); // Change the type of q to TypedQuery<T>
			
			if (!all) {
			    q.setFirstResult(firstResult);
			    q.setMaxResults(maxResult);
			}
			return q.getResultList();
		} finally{
			em.close();
		}
    }
//    public Long count() {
//        EntityManager em = jpaUtils.getEntityManager();
//        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
//        
//        Root<T> rt = cq.from(entityClass);
//        cq.select(em.getCriteriaBuilder().count(rt));
//        Query q = em.createQuery(cq);
//        return (long) q.getSingleResult();
//    }
    public Long count() {
        EntityManager em = jpaUtils.getEntityManager();
        try {
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Long> cq = cb.createQuery(Long.class); // Chỉ định Long là kiểu kết quả
			Root<T> rt = cq.from(entityClass);
			cq.select(cb.count(rt));
			TypedQuery<Long> q = em.createQuery(cq);
			long count = q.getSingleResult();
			em.close();
			return count;
		} finally {
			em.close();
		}
    }
    
}
