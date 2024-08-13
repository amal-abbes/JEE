package com.enit.exam.bibliotheque.entities;



import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="ABONNE")
public class Abonne {
	private static int totalAbonne = 0;
	@Id
	@Column(name="IDENTITE")
	private int numeroIdentite ;
	
	@Column(name="NUMABONNE")
	private int  numeroAbonnement;
	
	@Column(name="NOM")
	private String nom;
	@JoinColumn(name="OUV_EMPR")
	private Ouvrage ouvragePris;
	public int getNumeroIdentite() {
		return numeroIdentite;
	}
	public void setNumeroIdentite(int numeroIdentite) {
		this.numeroIdentite = numeroIdentite;
	}
	public String getNom() {
		return nom;
	}
	
    
    
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getNumeroAbonnement() {
		return numeroAbonnement;
	}
	public void setNumeroAbonnement(int numeroAbonnement) {
		this.numeroAbonnement = numeroAbonnement;
	}
	public Ouvrage getOuvragePris() {
		return ouvragePris;
	}
	public void setOuvragePris(Ouvrage ouvragePris) {
		this.ouvragePris = ouvragePris;
	}
	public Abonne() {
		super();
	}
	public Abonne (int numeroIdentite, int numeroAbonnement,String nom,Ouvrage ouvragePris) {
		super();
		this.numeroIdentite = numeroIdentite;
		this.numeroAbonnement=totalAbonne;
		this.nom = nom;
		this.ouvragePris=ouvragePris;
		totalAbonne++;
	}
	public Abonne(String nom,int numeroIdentite) {
		this.nom = nom;
		this.numeroIdentite = numeroIdentite;
		this.numeroAbonnement=totalAbonne;
		totalAbonne++;
	}
	@Override
	public String toString() {
	    return "Abonne{" +
	            "numeroIdentite=" + numeroIdentite +
	            ", numeroAbonnement=" + numeroAbonnement +
	            ", nom='" + nom + '\'' +
	            ", ouvragePris=" + (ouvragePris != null ? ouvragePris.getTitre() : "null") +
	            '}';
	}
}
