package edu.poly.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import edu.poly.model.User;

public class UserDao extends AbstractEntityDao<User>{
	public UserDao() {
		super(User.class);
	}
	
	public void changePassword(String username, String oldPassword, String newPassword) throws Exception {
	    EntityManager em = jpaUtils.getEntityManager();
	    
	    EntityTransaction trans = em.getTransaction();
	    String jpql = "SELECT u FROM User u WHERE u.username = :username";
	    try {
	        trans.begin();
	        TypedQuery<User> query = em.createQuery(jpql, User.class);
	        query.setParameter("username", username);
	        User user = query.getSingleResult();
	        if (user == null || !user.getPassword().equals(oldPassword)) {
	            throw new Exception("Username or password failed");
	        }
	        user.setPassword(newPassword); // Remember to hash newPassword before setting it
	        em.merge(user);
	        trans.commit();
	    } catch (Exception e) {
	        trans.rollback();
	        throw e;
	    } finally {
	        em.close();
	    }
	}
	
	public User findByUsernameEmail(String username, String email) {
		EntityManager em = jpaUtils.getEntityManager();
		String jpql = "select u from User u where u.id = :username and u.email = :email";
		try {
			TypedQuery<User> query = em.createQuery(jpql, User.class);
			query.setParameter("username", username);
			query.setParameter("email", email);

			return query.getSingleResult();
		} finally {
			em.close();
		}
	}
}
