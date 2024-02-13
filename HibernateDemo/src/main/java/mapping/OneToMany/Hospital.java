package mapping.OneToMany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Hospital {
	@Id
	private int hId;
	private String Hname;
	private String Ceo;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "hospital")
	private List<Branch> branch;

	@Override
	public String toString() {
		return "Hospital [hId=" + hId + ", Hname=" + Hname + ", Ceo=" + Ceo + "]";
	}

	public Hospital() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hospital(int hId, String hname, String ceo, List<Branch> branch) {
		super();
		this.hId = hId;
		Hname = hname;
		Ceo = ceo;
		this.branch = branch;
	}

	public int gethId() {
		return hId;
	}

	public void sethId(int hId) {
		this.hId = hId;
	}

	public String getHname() {
		return Hname;
	}

	public void setHname(String hname) {
		Hname = hname;
	}

	public String getCeo() {
		return Ceo;
	}

	public void setCeo(String ceo) {
		Ceo = ceo;
	}

	public List<Branch> getBranch() {
		return branch;
	}

	public void setBranch(List<Branch> branch) {
		this.branch = branch;
	}

}
