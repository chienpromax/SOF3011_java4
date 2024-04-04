package utils;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class JpaUtils {
	public static EntityManager getEntityManager() {
		 return Persistence.createEntityManagerFactory("Lab7.1").createEntityManager();
	}
}
