package edu.poly.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import edu.poly.domain.ShareReport;
import edu.poly.model.Share;

public class ShareDao extends AbstractEntityDao<Share> {

	public ShareDao() {
		super(Share.class);
	}

	public List<ShareReport> getSharesByVideoTitle(String videoUserId) {
	    EntityManager em = jpaUtils.getEntityManager();
	    List<ShareReport> userShares = null;
	    try {
	    	String jpql = "SELECT NEW edu.poly.domain.ShareReport(u.username, s.email, u.email AS receiverEmail, s.shareDate) " +
                    "FROM Share s " +
                    "JOIN s.user u " +
                    "JOIN s.video v " +
                    "WHERE v.videoid = :videoUserId";
	        TypedQuery<ShareReport> query = em.createQuery(jpql, ShareReport.class);
	        query.setParameter("videoUserId", videoUserId);
	        userShares = query.getResultList();
	    } finally {
	        em.close();
	    }
	    return userShares;
	}

	
	

	public List<Share> getAllShares() {
		EntityManager em = jpaUtils.getEntityManager();
		List<Share> shares = null;
		try {
			String jpql = "SELECT s FROM Share s";
			TypedQuery<Share> query = em.createQuery(jpql, Share.class);
			shares = query.getResultList();
		} finally {
			em.close();
		}
		return shares;
	}

}
