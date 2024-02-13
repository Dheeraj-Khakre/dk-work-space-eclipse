package vara.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Persistence;

@Entity
class Movies {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mid;
	private String mName;
	private String collection;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn
	private List<Hero> heroes;

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getCollection() {
		return collection;
	}

	public void setCollection(String collection) {
		this.collection = collection;
	}

	public List<Hero> getHeroes() {
		return heroes;
	}

	public void setHeroes(List<Hero> heroes) {
		this.heroes = heroes;
	}

}

@Entity
class Hero {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hid;
	private String hName;

	@ManyToMany(mappedBy = "heroes", cascade = CascadeType.ALL)
	private List<Movies> movies;

	public int getHid() {
		return hid;
	}

	public void setHid(int hid) {
		this.hid = hid;
	}

	public String gethName() {
		return hName;
	}

	public void sethName(String hName) {
		this.hName = hName;
	}

	public List<Movies> getMovies() {
		return movies;
	}

	public void setMovies(List<Movies> movies) {
		this.movies = movies;
	}

}

public class Movies_Heroes {
	
	
	public static void main(String[] args) {
		   EntityManagerFactory emf =Persistence.createEntityManagerFactory("dkmidnight");
		   EntityManager em = emf.createEntityManager();
		   EntityTransaction et = em.getTransaction();
		   System.out.println(emf);
		   
		   /// movies .....
		   Movies m1 = new Movies();
		   m1.setmName(" the avangers ");
		   m1.setCollection("Marvels Collection of Super Heros ");
		   Movies m2 = new Movies();
		   m2.setmName(" IronMan  ");
		   m2.setCollection("Marvels Collection first IronMan moveis 2008 ");
		   
		   Movies m3 = new Movies();
		   m3.setmName(" Captain Amarica the first Avanger ");
		   m3.setCollection("Marvels Collection of Super Heros 2011  ");
		   
		   Movies m4 = new Movies();
		   m4.setmName(" the Thor  ");
		   m4.setCollection("god  of thunder  ");
		   
		   List<Movies> m=new  ArrayList<Movies>();
		   m.add(m1);
		   m.add(m2);
		   
		   
		  /// Heros  ..  
		   Hero h1= new Hero();
		   h1.sethName("Roburt donny jounier ");
		   h1.setMovies(m);
		   
		   m.remove(1);
		   m.add(m4);
		   Hero h2= new Hero();
		   h2.sethName("Crish hamshworth  ");
		   h2.setMovies(m);
		   
		   m.remove(1);
		   m.add(m3);
		   Hero h3= new Hero();
		   h3.sethName("Crish evans");
		   h3.setMovies(m);
		   
		   Hero h4= new Hero();
		   h4.sethName("murk ruffalo ");
		   List<Hero> hlist  = new ArrayList<Hero>();
		   hlist.add(h1);
		   hlist.add(h2);
		   hlist.add(h3);
		   hlist.add(h4);
		   m1.setHeroes(hlist);
		   List<Hero> iron  = new ArrayList<Hero>();
		   iron.add(h1);
		   m2.setHeroes(iron);
		   List<Hero> thor  = new ArrayList<Hero>();
		   thor.add(h2);
		   m4.setHeroes(thor);
		   List<Hero> ca  = new ArrayList<Hero>();
		   ca.add(h3);
		   m3.setHeroes(ca);
		   
		   et.begin();
		   
		    em.persist(m1);
		    em.persist(m2);
		    em.persist(m3);
		    em.persist(m4);
		   
		   
		   
		   et.commit();
		   em.close();
		   
		   
		   
		   
	}

}
