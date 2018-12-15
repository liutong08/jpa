package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the stu database table.
 * 
 */
@Entity
@NamedQuery(name="Stu.findAll", query="SELECT s FROM Stu s")
public class Stu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int sid;

	private String name;

	//bi-directional many-to-one association to Sc
	@OneToMany(mappedBy="stu")
	private List<Sc> scs;

	public Stu() {
	}

	public int getSid() {
		return this.sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Sc> getScs() {
		return this.scs;
	}

	public void setScs(List<Sc> scs) {
		this.scs = scs;
	}

	public Sc addSc(Sc sc) {
		getScs().add(sc);
		sc.setStu(this);

		return sc;
	}

	public Sc removeSc(Sc sc) {
		getScs().remove(sc);
		sc.setStu(null);

		return sc;
	}

}