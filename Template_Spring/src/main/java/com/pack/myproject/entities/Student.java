package com.pack.myproject.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Student {
	 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	 private  Long ID;
	@NotEmpty
	 private String nom;
	@NotEmpty
	 private  String prenom;
	@NotEmpty
	 private String cne;
 public Student() {
		super();
	}
public Student( String nom, String prenom, String cne) {
		super();
		 
		this.nom = nom;
		this.prenom = prenom;
		this.cne = cne;
	}
@Override
	public String toString() { 
		return "Student [ID=" + ID + ", nom=" + nom + ", prenom=" + prenom
				+ ", cne=" + cne + "]";
	}
public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getCne() {
		return cne;
	}
	public void setCne(String cne) {
		this.cne = cne;
	}

 
}
