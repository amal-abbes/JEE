package com.enit.exam.bibliotheque.entities;
import javax.persistence.Entity;


@Entity
public class Livre extends Ouvrage {
	private String auteur;
	
	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public Livre() {
		super();
	}
	public Livre(String titre, String dateDeCreation,boolean disponible,String auteur) {
		super(titre,dateDeCreation,disponible);
		this.auteur = auteur;
	}
	public Livre(String titre, String dateDeCreation,String auteur) {
		super(titre,dateDeCreation,true);
		this.auteur = auteur;
	}
	@Override
    public String toString() {
        return "Livre{" +
                "titre='" + getTitre() + '\'' +
                ", dateDeCreation='" + getDateDeCreation() + '\'' +
                ", disponible=" + isDisponible() +
                ", auteur='" + auteur + '\'' +
                '}';
    }
	
}