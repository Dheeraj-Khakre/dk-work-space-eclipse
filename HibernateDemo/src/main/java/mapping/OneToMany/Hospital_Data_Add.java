package mapping.OneToMany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Hospital_Data_Add {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dkmidnight");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Hospital h1 = new Hospital();
		h1.setHname("Appollo hospital");
		h1.sethId(101);
		h1.setCeo("Prathap c. reddy");

		Branch b1 = new Branch(121, "marthahali ", "naveen", h1);
		Branch b2 = new Branch(122, "Bhopal", "alok yadav", h1);
		Branch b3 = new Branch(123, "nagpur", "m. v. sharma", h1);
		List<Branch> blist = new ArrayList<Branch>();
		h1.setBranch(blist);
		blist.add(b3);
		blist.add(b2);
		blist.add(b1);
		et.begin();
		em.persist(h1);
		et.commit();
		em.clear();

	}

}
