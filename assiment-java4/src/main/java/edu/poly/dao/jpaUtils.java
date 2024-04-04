package edu.poly.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class jpaUtils {
	public static EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("assiment-java4").createEntityManager();
	}
}
