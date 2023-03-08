package com.inti.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Aeroport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAeroport;
	private String nom;
	
	
	@ManyToOne
	@JoinColumn(name="idVille")
	private Ville ville;
	
	public Aeroport() {
		super();
	}
	public Aeroport(String nom) {
		super();
		this.nom = nom;
	}
	
	
	public Aeroport(String nom, Ville ville) {
		super();
		this.nom = nom;
		this.ville = ville;
	}
	public int getIdAeroport() {
		return idAeroport;
	}
	public void setIdAeroport(int idAeroport) {
		this.idAeroport = idAeroport;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	
	public Ville getVille() {
		return ville;
	}
	public void setVille(Ville ville) {
		this.ville = ville;
	}
	@Override
	public String toString() {
		return "Aeroport [idAeroport=" + idAeroport + ", nom=" + nom + "]";
	}
	
	
}
