package net.codejava.employe;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import net.codejava.Departement.Departement;

@Entity
public class Employe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 128, nullable = false, unique = false)
	private String nomEmp;
	
	@Column(length = 128, nullable = false, unique = false)
	private String prenomEmp;
	
	
	
	private String emailEmp;
	private float salEmp;
	
	@ManyToOne
	@JoinColumn(name = "departement_id")
	private Departement departement;

	
	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomEmp() {
		return nomEmp;
	}

	public void setNomEmp(String nomEmp) {
		this.nomEmp = nomEmp;
	}

	public String getPrenomEmp() {
		return prenomEmp;
	}

	public void setPrenomEmp(String prenomEmp) {
		this.prenomEmp = prenomEmp;
	}

	public String getEmailEmp() {
		return emailEmp;
	}

	public void setEmailEmp(String emailEmp) {
		this.emailEmp = emailEmp;
	}

	public float getSalEmp() {
		return salEmp;
	}

	public void setSalEmp(float salEmp) {
		this.salEmp = salEmp;
	}

	public Employe(Integer id, String nomEmp, String prenomEmp, String emailEmp, float salEmp,
			Departement departement) {
		this.id = id;
		this.nomEmp = nomEmp;
		this.prenomEmp = prenomEmp;
		this.emailEmp = emailEmp;
		this.salEmp = salEmp;
		this.departement = departement;
	}

	public Employe() {
	
	}
	
	public Employe(String nomEmp, String prenomEmp, String emailEmp, float salEmp,
			Departement departement) {
		this.nomEmp = nomEmp;
		this.prenomEmp = prenomEmp;
		this.emailEmp = emailEmp;
		this.salEmp = salEmp;
		this.departement = departement;
	}



	
	
}
