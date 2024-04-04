package poly.edu.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

import poly.edu.jpautils.JpaUtil;
import poly.edu.model.Report;
import poly.edu.model.User;
import poly.edu.model.Video;

public class VideoDao {
	public List<Video> findVideoFavoriteByUserID(String id){
		EntityManager em = JpaUtil.getEntityManager();
		String jpql = "Select f.video from Favorite f where f.user.id = :username";
		TypedQuery<Video> query = em.createQuery(jpql, Video.class);
		query.setParameter("username", id);
		return query.getResultList();
	}
	
	public List<Video> findVideoFavoriteByTitle(String title){
		EntityManager em = JpaUtil.getEntityManager();
		String jpql = "Select DISTINCT f.video from Favorite f where f.video.title like :title";
		TypedQuery<Video> query = em.createQuery(jpql, Video.class);
		query.setParameter("title", "%"+title+"%");
		return query.getResultList();
	}
	
	public List<User> findUserLikeVideo(String videoid){
		EntityManager em = JpaUtil.getEntityManager();
		String jpql = "SELECT o.user from Favorite o WHERE o.video.id = :videoid";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		query.setParameter("videoid", videoid);
		return query.getResultList();
	}
	
	public List<Video> findUserLikeOrNotLike(Boolean favorite){
		EntityManager em = JpaUtil.getEntityManager();
		String jpql = "SELECT o FROM Video o WHERE o.favorites IS EMPTY";
		if (favorite) {
			jpql = "SELECT o FROM Video o WHERE o.favorites IS NOT EMPTY";
		}
		TypedQuery<Video> query = em.createQuery(jpql, Video.class);
		return query.getResultList();
	}
	public List<Report> countLikeVideo(){
		String jpql = "SELECT new Report(f.video.title, count(f), max(f.likeDate), min(f.likeDate)) FROM Favorite f GROUP BY f.video.title";
		EntityManager em = JpaUtil.getEntityManager();
		TypedQuery<Report> query = em.createQuery(jpql, Report.class);
		return query.getResultList();
	}
	
	public List<Video> findLikeVideoAndKeyWord(String keyword){
		EntityManager em = JpaUtil.getEntityManager();
		TypedQuery<Video> query = em.createNamedQuery("findLikeVideoByKeyWord", Video.class);
		query.setParameter("keyword","%"+ keyword +"%");
		return query.getResultList();
	}
	
	public List<Video> findFavoritesByUserId(String userId){
		EntityManager em = JpaUtil.getEntityManager();
		TypedQuery<Video> query = em.createNamedQuery("Favorite.findFavoritesByUserId", Video.class);
		query.setParameter("userId", userId);
		return query.getResultList();
	}

	public List<Video> findFavoritesByDateRange(Date minDate, Date maxDate) {
		 EntityManager em = JpaUtil.getEntityManager();
	        TypedQuery<Video> query = em.createNamedQuery("Favorite.findFavoritesByDateRange", Video.class);
	        query.setParameter("minDate", minDate);
	        query.setParameter("maxDate", maxDate);
	        return query.getResultList();
	}
	
	public List<Video> findFavoritesByMonths(List<Integer> months) {
	    EntityManager em = JpaUtil.getEntityManager();
	    String jpql = "SELECT DISTINCT f.video FROM Favorite f WHERE MONTH(f.likeDate) IN :months";
	    TypedQuery<Video> query = em.createQuery(jpql, Video.class);
	    query.setParameter("months", months);
	    return query.getResultList();
	}
	
	public List<Video> random2Video() {
		EntityManager em = JpaUtil.getEntityManager();
		TypedQuery<Video> query = em.createNamedQuery("Report.random2", Video.class);
		return query.getResultList();
	}
	
	
	public List<Report> favoriteByYear(int year) {
		EntityManager em = JpaUtil.getEntityManager();
//			StoredProcedureQuery query = em.createNamedStoredProcedureQuery("Report.FavoriteByYear");
//			query.setParameter("@Year", year);
		String jpql = "SELECT new Report(f.video.title, count(f), max(f.likeDate), min(f.likeDate)) FROM "
				+ "Favorite f WHERE year(f.likeDate) = :year GROUP BY f.video.title";
		TypedQuery<Report> query = em.createQuery(jpql, Report.class);
		query.setParameter("year", year);
		return query.getResultList();
	}
	
}
