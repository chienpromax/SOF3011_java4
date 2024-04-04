package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.User;
import utils.JpaUtils;



public class UserDao {
	public void insertUser(User user) {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(user);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();

		} finally {
			em.close();
		}
	}
	public void create(User user) {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(user);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			em.close();
		}
	}
	public void update(User user) {
		EntityManager em = JpaUtils.getEntityManager();
		
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(user);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			em.close();
		}
	}
	public void delete(String userId) throws Exception {
		EntityManager em = JpaUtils.getEntityManager();
		
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			User user = em.find(User.class, userId);
			if(user!=null) {
				em.remove(user);
			}else {
				throw new Exception("User can not found");
			}
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			em.close();
		}
	}
	public User findById(String userId) {
		EntityManager em = JpaUtils.getEntityManager();
		User user = em.find(User.class, userId);
		return user;
	}
	
	public List<User> findAll() {
		EntityManager em = JpaUtils.getEntityManager();
		
		TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
		
		return query.getResultList();
	}
	public List<User> findAll(int page, int pageSize) {
		EntityManager em = JpaUtils.getEntityManager();
		TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
		query.setFirstResult(page * pageSize);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}
	

	public User checkLogin(String userId, String password) {
		EntityManager em = JpaUtils.getEntityManager();
		String jqpl = "select u from User u where u.userId = :userId and u.password = :password";
		TypedQuery<User> query = em.createQuery(jqpl, User.class);
		query.setParameter("userId", userId);
		query.setParameter("password", password);
		return query.getSingleResult();
	}
	
	public List<User> findByFullname(String fullname) {
		EntityManager em = JpaUtils.getEntityManager();
		String jqpl = "select u from User u where u.fullname like :fullname";
		TypedQuery<User> query = em.createQuery(jqpl, User.class);
		query.setParameter("fullname", "%" + fullname + "%");
		return query.getResultList();
	}
	
	public int count() {
		EntityManager em = JpaUtils.getEntityManager();
		String jqpl = "select count( u) from User u ";
		Query query = em.createQuery(jqpl);
		return ((Long) query.getSingleResult()).intValue();
	}
}

