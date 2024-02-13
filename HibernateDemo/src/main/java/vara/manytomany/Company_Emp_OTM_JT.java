package vara.manytomany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Persistence;

@Entity
class Company{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;
	private String cName;
	private String ceo;
	@OneToMany
	@JoinTable(name = "companyDatails",joinColumns = @JoinColumn(name="companyId"),inverseJoinColumns = @JoinColumn(name="employeess"))
	private List<EMP> emps;
}

@Entity
class EMP{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int epmid;
	private  String empName;
	private String job;
	
	
}















public class Company_Emp_OTM_JT {
	 public static void main(String[] args) {
		  EntityManagerFactory emf =Persistence.createEntityManagerFactory("dkmidnight");
	}

}
