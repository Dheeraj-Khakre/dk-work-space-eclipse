package mapping.OneToMany;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Branch {
	@Id
	private int bID;
	private String bName;
	private String managerName;

	@Override
	public String toString() {
		return "Branch [bID=" + bID + ", bName=" + bName + ", managerName=" + managerName + "]";
	}

	@ManyToOne(cascade = CascadeType.ALL)
	private Hospital hospital;

	public Branch() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Branch(int bID, String bName, String managerName, Hospital hospital) {
		super();
		this.bID = bID;
		this.bName = bName;
		this.managerName = managerName;
		this.hospital = hospital;
	}

	public int getbID() {
		return bID;
	}

	public void setbID(int bID) {
		this.bID = bID;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

}
