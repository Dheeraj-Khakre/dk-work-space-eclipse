package vara.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;



public class Adding_Data {
	public static void main(String[] args) {
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("dkmidnight");
		EntityManager em =emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
         
		
		System.out.println(emf);
		
		///student 1 ....
		Students s1 =new Students();
		s1.setId(101);
		s1.setName("anil khakre");
		s1.setDuration(" 5 moths 1/01/2024 to 30/04/2024");
		
		
		//student 2....
		Students s2 =new Students();
		s2.setId(102);
		s2.setName("vivak khakre");
		s2.setDuration(" 7 moths 1/01/2024 to 30/06/2024");

		
		/// student 3...
		Students s3=new Students();
		s3.setId(103);
		s3.setName("tuk_Tuk  khakre");
		s3.setDuration(" 8 moths 1/01/2024 to 30/07/2024");
		List<Students>  slist = new ArrayList<Students>();
		slist.add(s1);
		slist.add(s2);
		slist.add(s3);
		
		
		//course
		Courses c1 = new Courses(201, "java", "Raveesh sir ", slist);
		Courses c2= new Courses(202, "SQL", "Ankita poul", slist);
		Courses c3= new Courses(203, "J2EE ", "varaPrasad sir", slist);
		
		//  course list 
		List<Courses> clist = new ArrayList<Courses>();
		clist.add(c1);
		clist.add(c2);
		clist.add(c3);
		
		s1.setCourse(clist);
		s2.setCourse(clist);
		s3.setCourse(clist);
		
		et.begin();
		em.persist(s1);
		em.persist(s2);
		em.persist(s3);
		et.commit();
		em.close();
		emf.close();
		
	}

}
