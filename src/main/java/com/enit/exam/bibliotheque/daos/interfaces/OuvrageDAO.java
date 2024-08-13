package com.enit.exam.bibliotheque.daos.interfaces;
import com.enit.exam.bibliotheque.entities.Ouvrage;
public interface OuvrageDAO {
	public void ajoutOuvrage(Ouvrage ouvrage);
	public void suppOuvrage(Ouvrage ouvrage);
	public Ouvrage rechercheOuvrage(String titre);
	public void updateOuvrage(Ouvrage ouvrage);
}


