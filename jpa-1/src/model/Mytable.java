package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mytable database table.
 * 
 */
@Entity
@NamedQuery(name="Mytable.findAll", query="SELECT m FROM Mytable m")
public class Mytable implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	private String name;

	public Mytable() {
	}

	@GeneratedValue
	@Id
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}