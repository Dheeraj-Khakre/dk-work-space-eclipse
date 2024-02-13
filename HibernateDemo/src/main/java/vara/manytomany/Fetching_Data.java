package vara.manytomany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Fetching_Data {
	public static void main(String[] args) {
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("dkmidnight");
		EntityManager em =emf.createEntityManager();
		 Students s1 = (Students)em.find(Students.class, 101);
		 
		   
		// System.out.println(s1.toString());
		 for(Courses c:s1.getCourse()) {
			 System.out.println(c.toString());
			  
			     for(Students s:c.getStd()) {
			    	 System.out.println(s.toString());
			    	 
			     }
			     
		 }
		    
	}

}
