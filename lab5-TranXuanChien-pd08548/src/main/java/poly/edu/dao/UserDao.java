package poly.edu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import javax.persistence.Query;

import poly.edu.jpa.jpaUnitl;
import poly.edu.model.User;

public class UserDao {
	public User insert(User u) {
		EntityManager em = jpaUnitl.getEntityManager();
		EntityTransaction tra = em.getTransaction();
		try {
			tra.begin(); // bắt đầu 1 thao tác với sql
			em.persist(u); // thêm 1 user
			tra.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}

	public User edit(User u) {
		EntityManager em = jpaUnitl.getEntityManager();
		EntityTransaction tra = em.getTransaction();
		try {
			tra.begin();
			u = em.merge(u); // Sử dụng merge để cập nhật thông tin user
			tra.commit(); // Hoàn thành giao dịch nếu không có lỗi
		} catch (Exception e) {
			e.printStackTrace();
			if (tra != null && tra.isActive()) {
				tra.rollback(); // Rollback giao dịch nếu có lỗi
			}
		} finally {
			em.close(); // Đóng EntityManager sau khi sử dụng
		}
		return u;
	}

	public void delete(String userId) {
		EntityManager em = jpaUnitl.getEntityManager();
		EntityTransaction tra = em.getTransaction();
		try {
			tra.begin();
			User user = em.find(User.class, userId);
			if (user != null) {
				em.remove(user);
				tra.commit();
			} else {
				System.out.println("User with ID " + userId + " not found.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (tra != null && tra.isActive()) {
				tra.rollback();
			}
		} finally {
			em.close();
		}
	}

	public List<User> findAll() {
		List<User> users = null;
		EntityManager em = jpaUnitl.getEntityManager();
		EntityTransaction tra = em.getTransaction();
		try {
			tra.begin();
			// Tạo một truy vấn để lấy tất cả các người dùng từ cơ sở dữ liệu
			TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
			// Thực hiện truy vấn và nhận danh sách người dùng
			users = query.getResultList();
			tra.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tra != null && tra.isActive()) {
				tra.rollback();
			}
		} finally {
			em.close();
		}
		return users;
	}

	public List<User> findByRole(boolean isAdmin) {
		EntityManager em = jpaUnitl.getEntityManager();
		try {
			String queryString = "SELECT u FROM User u WHERE u.admin = :isAdmin";
			Query query = em.createQuery(queryString);
			query.setParameter("isAdmin", isAdmin);
			return query.getResultList();
		} finally {
			em.close();
		}
	}

	public List<User> findByKeyWord(String keyWord) {
		List<User> users = null;
		EntityManager em = jpaUnitl.getEntityManager();
		EntityTransaction tra = em.getTransaction();
		try {
			tra.begin();
			TypedQuery<User> query = em.createQuery("SELECT u FROM User u where u.fullname LIKE :keyWord", User.class);
	        query.setParameter("keyWord", "%" + keyWord + "%");
			users = query.getResultList();
			tra.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tra != null && tra.isActive()) {
				tra.rollback();
			}
		} finally {
			em.close();
		}
		return users;
	}
	
	public List<User> findOne(String id, String Pass) {
	    List<User> users = null;
	    EntityManager em = jpaUnitl.getEntityManager();
	    EntityTransaction tra = em.getTransaction();
	    try {
	        tra.begin();
	        TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.id LIKE :id AND u.password LIKE :Pass", User.class);
	        query.setParameter("id", "%" + id + "%");
	        query.setParameter("Pass", "%" + Pass + "%");
	        users = query.getResultList();
	        tra.commit();
	    } catch (Exception e) {
	        e.printStackTrace();
	        if (tra != null && tra.isActive()) {
	            tra.rollback();
	        }
	    } finally {
	        em.close();
	    }
	    return users;
	}
	
	public User findById(String id) {
		EntityManager em = jpaUnitl.getEntityManager();
		User user = em.find(User.class, id);
		return user;
	}

	
	public List<User> findPage(int pageNumber, int pageSize) {
        List<User> users = null;
        EntityManager em = jpaUnitl.getEntityManager();
        EntityTransaction tra = em.getTransaction();
        try {
            tra.begin();
            int startPosition = (pageNumber - 1) * pageSize;
            TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class)
                                           .setFirstResult(startPosition)
                                           .setMaxResults(pageSize);
            users = query.getResultList();
            tra.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tra != null && tra.isActive()) {
                tra.rollback();
            }
        } finally {
            em.close();
        }
        return users;
    }
}
