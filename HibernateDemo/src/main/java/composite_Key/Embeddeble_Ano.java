package composite_Key;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@Entity
class Accounts{
	private int id;
	private String name;
	@EmbeddedId // it is used to mark a composite kry for a entity class
	private PK pk;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public PK getPk() {
		return pk;
	}
	public void setPk(PK pk) {
		this.pk = pk;
	}
	
}

/*       
 
 */
@Embeddable
class PK implements Serializable{
	public PK(long acountno, int pincode) {
	
		this.acountno = acountno;
		this.pincode = pincode;
	}
	private long acountno;
	private int pincode;
	public long getAcountno() {
		return acountno;
	}
	public void setAcountno(long acountno) {
		this.acountno = acountno;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
}









public class Embeddeble_Ano {
	public static void main(String[] args) {
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("dkmidnight");
		 EntityManager em = emf.createEntityManager();
		 EntityTransaction et  = em.getTransaction();
		  
//		 et.begin();
//		      em.createQuery("delete from Account").executeUpdate();
//		 et.commit();
		 Accounts a1 = new Accounts();
		 a1.setId(2);
		 a1.setName("b");
		 a1.setPk(new PK(12344,46066));
		 Accounts a2 = new Accounts();
		 a2.setId(2);
		 a2.setName("b");
		 a2.setPk(new PK(12345,4666));
		 //
		
		 
		 et.begin();
		 em.persist(a2);
		 em.persist(a1);
		 et.commit();
	}

}
