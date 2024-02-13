package composite_Key;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UserDriver {
	public static void main(String[] args) {
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("dkmidnight");
		 EntityManager em = emf.createEntityManager();
		 EntityTransaction et  = em.getTransaction();
		 Useres u1 = new Useres();
		 u1.setId(1);
		 u1.setName("dinga");
		 u1.setEmail("dinga@gmail.com");
		 u1.setPsw("1234");
		 
		 Useres u2 = new Useres();
		 u2.setId(1);
		 u2.setName("dinga");
		 u2.setEmail("dinga@gmail.com");
		 u2.setPsw("12345");
		 et.begin();
		 em.persist(u2);
		 em.persist(u1);
		 et.commit();
	}

}
