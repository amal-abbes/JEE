package com.enit.exam.bibliotheque.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Ouvrage")
@DiscriminatorColumn(name = "TYPE_OUV")
public class Ouvrage {
	@Id
	@Column(name="TITRE")
	private String titre;
	@Column(name="DATECREATION")
	private String dateDeCreation;
	@Column(name="EXISTE")
	boolean disponible;
	public Ouvrage() {
		super();
	}
	

	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDateDeCreation() {
		return dateDeCreation;
	}
	public void setDateDeCreation(String dateDeCreation) {
		this.dateDeCreation = dateDeCreation;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	public Ouvrage (String titre, String dateDeCreation,boolean disponible) {
		super();
		this.titre = titre;
		this.dateDeCreation=dateDeCreation;
		this.disponible = disponible;
	}
	public Ouvrage(String titre,String dateDeCreation) {
		this.titre = titre;
		this.dateDeCreation = dateDeCreation;
		this.disponible = true;
	}
	@Override
	public String toString() {
	    return "Ouvrage{" +
	            "titre=" + titre +
	            ", dateDeCreation=" + dateDeCreation +
	            ", disponible='" + disponible + '\'' +
	            '}';
	}
	
	
}
