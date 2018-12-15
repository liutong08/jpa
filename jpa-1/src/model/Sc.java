package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sc database table.
 * 
 */
@Entity
@NamedQuery(name="Sc.findAll", query="SELECT s FROM Sc s")
public class Sc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int scid;

	private String score;

	//bi-directional many-to-one association to Stu
	@ManyToOne
	@JoinColumn(name="sid")
	private Stu stu;

	public Sc() {
	}

	public int getScid() {
		return this.scid;
	}

	public void setScid(int scid) {
		this.scid = scid;
	}

	public String getScore() {
		return this.score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public Stu getStu() {
		return this.stu;
	}

	public void setStu(Stu stu) {
		this.stu = stu;
	}

}