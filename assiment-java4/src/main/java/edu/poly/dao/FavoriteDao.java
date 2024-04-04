package edu.poly.dao;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import edu.poly.domain.FavoriteUserReport;
import edu.poly.model.Favorite;

public class FavoriteDao extends AbstractEntityDao<Favorite>{

	public FavoriteDao() {
		super(Favorite.class);
		
	}
	
	public List<FavoriteUserReport> reportFavoriteUserByVideo(String videoid){
	    String jpql = "SELECT new edu.poly.domain.FavoriteUserReport(f.user.username, f.user.fullname, "
	            + "f.user.email, f.likeDate) FROM Favorite f WHERE f.video.videoid = :videoid";
//		String jpql = "SELECT new edu.poly.domain.FavoriteUserReport(u.username, u.fullname, "
//	            + "u.email, f.likeDate) FROM Favorite f "
//	            + "JOIN User u ON f.username = u.username "
//	            + "JOIN Video v ON f.videoid = v.videoid "
//	            + "WHERE v.videoid = :videoid";

	    EntityManager em = jpaUtils.getEntityManager();
	    
	    List<FavoriteUserReport> list = null;
	    try {
	        TypedQuery<FavoriteUserReport> query = em.createQuery(jpql, FavoriteUserReport.class);
	        query.setParameter("videoid", videoid);
	        list = query.getResultList(); 
	    } finally {
	        em.close();
	    }
	    return list;
	}
}
