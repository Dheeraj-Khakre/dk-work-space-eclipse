package vara.manytomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Students {
	@Id
	private int id;
	private String name;
	private String duration;
	@ManyToMany(cascade = CascadeType.ALL , mappedBy = "std")

	private List<Courses> course;

	@Override
	public String toString() {
		return "Students [id=" + id + ", name=" + name + ", duration=" + duration + "]";
	}

	public Students() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Students(int id, String name, String duration, List<Courses> course) {
		super();
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.course = course;
	}

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

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public List<Courses> getCourse() {
		return course;
	}

	public void setCourse(List<Courses> course) {
		this.course = course;
	}

}
