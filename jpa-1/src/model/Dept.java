package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the dept database table.
 * 
 */
@Entity
@NamedQuery(name="Dept.findAll", query="SELECT d FROM Dept d")
public class Dept implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="d_id")
	private int dId;

	@Column(name="d_name")
	private String dName;

	public Dept() {
	}

	public int getDId() {
		return this.dId;
	}

	public void setDId(int dId) {
		this.dId = dId;
	}

	public String getDName() {
		return this.dName;
	}

	public void setDName(String dName) {
		this.dName = dName;
	}

}