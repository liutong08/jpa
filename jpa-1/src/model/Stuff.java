package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the stuff database table.
 * 
 */
@Entity
@NamedQuery(name="Stuff.findAll", query="SELECT s FROM Stuff s")
public class Stuff implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String dept;

	private String name;

	public Stuff() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDept() {
		return this.dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}