package edu.poly.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import edu.poly.domain.FavoriteReport;
import edu.poly.domain.FavoriteUserReport;
import edu.poly.model.Favorite;
import edu.poly.model.User;
import edu.poly.model.Video;

public class FavoriteDao extends AbstractEntityDao<Favorite> {

	public FavoriteDao() {
		super(Favorite.class);
	}

	public List<FavoriteUserReport> reportUsersByVideo(String videoId) {
		String jpql = "SELECT NEW edu.poly.domain.FavoriteUserReport(f.user.username, f.user.fullname, f.user.email, f.likeDate) "
				+ "FROM Favorite f " + "WHERE f.video.videoid = :videoid";

		EntityManager em = jpaUtils.getEntityManager();
		List<FavoriteUserReport> list = null;
		try {
			TypedQuery<FavoriteUserReport> query = em.createQuery(jpql, FavoriteUserReport.class);
			query.setParameter("videoid", videoId);
			list = query.getResultList();
		} finally {
			em.close();
		}
		return list;
	}

	public List<FavoriteReport> reportFavoritesByVideos() {
		String jpql = "select new edu.poly.domain.FavoriteReport(f.video.title, count(f), min(f.likeDate), max(f.likeDate)) "
				+ " from Favorite f group by f.video.title ";
		EntityManager em = jpaUtils.getEntityManager();
		List<FavoriteReport> list = null;
		try {
			TypedQuery<FavoriteReport> query = em.createQuery(jpql, FavoriteReport.class);
			list = query.getResultList();
		} finally {
			em.close();
		}
		return list;
	}

	public Favorite findOneByUserIdAndVideoId(String username, String videoId) {
		EntityManager em = jpaUtils.getEntityManager();
		try {
			String sql = "SELECT f FROM Favorite f WHERE f.user.username = :username and f.video.videoId = :videoId";
			TypedQuery<Favorite> query = em.createQuery(sql, Favorite.class);
			query.setParameter("username", username);
			query.setParameter("videoId", videoId);
			Favorite favorite = query.getSingleResult();
			return favorite;
		} catch (Exception e) {
			return null;
		}
	}

	EntityManager em = jpaUtils.getEntityManager();

	public List<Favorite> findAllVideoIdByUserId(int id) {
		em.clear();
		try {
			List<Favorite> list = em.find(User.class, id).getFavorites();
			return list;
		} catch (Exception e) {
			return null;
		}

	}

	public List<Video> findAllByUserId(String id) {
		em.clear();
		try {
			String sql = "SELECT f.video FROM Favorite f WHERE f.user.username = :id";
			TypedQuery<Video> query = em.createQuery(sql, Video.class);
			query.setParameter("id", id);
			List<Video> list = query.getResultList();
			return list;
		} catch (Exception e) {
			return null;
		}
	}

	public List<Favorite> findAllByUserId1(String id) {
		em.clear();
		try {
			String sql = "SELECT f.video FROM Favorite f WHERE f.user.username = :id";
			TypedQuery<Favorite> query = em.createQuery(sql, Favorite.class);
			query.setParameter("id", id);
			List<Favorite> list = query.getResultList();
			return list;
		} catch (Exception e) {
			return null;
		}
	}

	public void deleteFavorite(String username, String videoId) {
		EntityManager em = jpaUtils.getEntityManager();
		EntityTransaction transaction = null;

		try {
			transaction = em.getTransaction();
			transaction.begin();

			String jpql = "DELETE FROM Favorite f WHERE f.user.username = :username AND f.video.videoid = :videoId";
			Query query = em.createQuery(jpql);
			query.setParameter("username", username);
			query.setParameter("videoId", videoId);

			int deletedCount = query.executeUpdate();
			transaction.commit();

			System.out.println("Deleted " + deletedCount + " favorite(s) for user " + username + " and video " + videoId);
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}
}
