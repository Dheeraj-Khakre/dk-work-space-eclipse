package vara.manytomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Courses {
	@Id
	private int cId;

	@Override
	public String toString() {
		return "Courses [cId=" + cId + ", cname=" + cname + ", teacher_Name=" + teacher_Name + "]";
	}

	public Courses() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Courses(int cId, String cname, String teacher_Name, List<Students> std) {
		super();
		this.cId = cId;
		this.cname = cname;
		this.teacher_Name = teacher_Name;
		this.std = std;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getTeacher_Name() {
		return teacher_Name;
	}

	public void setTeacher_Name(String teacher_Name) {
		this.teacher_Name = teacher_Name;
	}

	public List<Students> getStd() {
		return std;
	}

	public void setStd(List<Students> std) {
		this.std = std;
	}

	private String cname;
	private String teacher_Name;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "std_cour"//, 
//	joinColumns =  @JoinColumn(name = "S-id"), 
//	inverseJoinColumns =@JoinColumn(name = "c_id")

	)
	private List<Students> std;

}
