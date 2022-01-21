package net.codejava.Departement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Departement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer id;
	
	@Column(length = 333, nullable = false, unique = true)
	private String nomDept;
	
	private String dirDept;
	private String locDept;
	 
	public Departement() {
		
	}
	
	public Departement(Integer id) {
		this.id = id;
		
	}
	
	public Departement(String nomDept, String dirDept, String locDept) {
		this.nomDept = nomDept;
		this.dirDept = dirDept;
		this.locDept = locDept;
	}
	
	public Departement(Integer id, String nomDept, String dirDept, String locDept) {
		this.id = id;
		this.nomDept = nomDept;
		this.dirDept = dirDept;
		this.locDept = locDept;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomDept() {
		return nomDept;
	}
	public void setNomDept(String nomDept) {
		this.nomDept = nomDept;
	}
	public String getDirDept() {
		return dirDept;
	}
	public void setDirDept(String dirDept) {
		this.dirDept = dirDept;
	}
	public String getLocDept() {
		return locDept;
	}
	public void setLocDept(String locDept) {
		this.locDept = locDept;
	}
	
	
	
}
