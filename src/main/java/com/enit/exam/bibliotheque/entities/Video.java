package com.enit.exam.bibliotheque.entities;
import javax.persistence.Entity;

@Entity
public class Video extends Ouvrage {
	private String editeur;
	private double duree;
	public String getEditeur() {
		return editeur;
	}
	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}
	public double getDuree() {
		return duree;
	}
	public void setDuree(double duree) {
		this.duree = duree;
	}
	public Video(){
		super();
	}
	public Video(String titre,String dateDeCreation,String editeur,double duree){
		super(titre,dateDeCreation,true);
		this.editeur = editeur;
		this.duree=duree;
	}
	@Override
    public String toString() {
        return "Video{" +
                "titre='" + getTitre() + '\'' +
                ", dateDeCreation='" + getDateDeCreation() + '\'' +
                ", disponible=" + isDisponible() +
                ", editeur='" + editeur + '\'' +
                ", duree=" + duree +
                '}';
    }
}
