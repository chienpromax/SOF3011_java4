package poly.edu.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class jpaUnitl {
	private static EntityManager entityManager;
	public static EntityManager getEntityManager() {
		if (entityManager == null || !entityManager.isOpen()) {
			EntityManagerFactory factory  = Persistence.createEntityManagerFactory("Lab5");
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}
}
