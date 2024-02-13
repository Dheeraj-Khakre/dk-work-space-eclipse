package mapping.OneToMany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Fetching_Hospital_Data {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dkmidnight");
		EntityManager em = emf.createEntityManager();

		Hospital h = (Hospital) em.find(Hospital.class, 101);
		System.out.println(h.toString());
		for (Branch b : h.getBranch()) {
			System.out.println(b.toString());
		}
	}
}
