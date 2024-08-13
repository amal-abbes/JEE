package com.enit.exam.bibliotheque.daos.interfaces;

import com.enit.exam.bibliotheque.entities.Abonne;
import com.enit.exam.bibliotheque.exceptions.BiblioException;


public interface AbonneDAO {
	public void ajoutAbonne(Abonne abonne);
	public void suppAbonne(Abonne abonne);
	public Abonne rechercheAbonne(int identite);
	public void updateAbonne(Abonne abonne);
	public void emprunter(String titre,int identite) throws BiblioException;
	public void rendre(int identite) throws BiblioException;
}
