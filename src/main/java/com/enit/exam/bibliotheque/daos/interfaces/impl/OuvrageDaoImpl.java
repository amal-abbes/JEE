package com.enit.exam.bibliotheque.daos.interfaces.impl;

import com.enit.exam.bibliotheque.daos.interfaces.OuvrageDAO;
import com.enit.exam.bibliotheque.entities.Ouvrage;
import com.enit.exam.bibliotheque.util.JpaUtil;


public class OuvrageDaoImpl implements OuvrageDAO {

    @Override
    public void ajoutOuvrage(Ouvrage ouvrage) {

        try {
        	JpaUtil.getEntityManager().getTransaction().begin();
        	JpaUtil.getEntityManager().persist(ouvrage);
        	JpaUtil.getEntityTransaction().commit();
        } catch(Exception ex){
        	JpaUtil.getEntityTransaction().rollback();      
        	}
    }

    @Override
    public void suppOuvrage(Ouvrage ouvrage) {
        try {
        	
        	JpaUtil.getEntityTransaction().begin();
        	
            if (ouvrage != null) {
                
                if (!JpaUtil.getEntityManager().contains(ouvrage)) {
                    ouvrage = JpaUtil.getEntityManager().merge(ouvrage);
                }

                JpaUtil.getEntityManager().remove(ouvrage);
            }else {
            	System.out.println("L'ouvrage n'existe pas");
            }

            JpaUtil.getEntityTransaction().commit();
        } catch (Exception ex) {
        	System.out.println("Erreur : Il faut rendre l'ouvrage avant de le supprimer");
        	if(JpaUtil.getEntityTransaction().isActive()) {
        		JpaUtil.getEntityTransaction().rollback();
        	}
        }
    }

    @Override
    public Ouvrage rechercheOuvrage(String titre) {

        return JpaUtil.getEntityManager().find(Ouvrage.class, titre);
        
    }

    @Override
    public void updateOuvrage(Ouvrage ouvrage) {
        

        try {
        	
        	JpaUtil.getEntityTransaction().begin();
        	

            Ouvrage existingOuvrage = JpaUtil.getEntityManager().find(Ouvrage.class, ouvrage.getTitre());
            
            if (existingOuvrage != null) {
            	JpaUtil.getEntityManager().merge(ouvrage);
            	JpaUtil.getEntityTransaction().commit();
            }else {
            	System.out.println("L'ouvrage n'existe pas");
            }

            
        }catch(Exception ex){
        	
        	if(JpaUtil.getEntityTransaction().isActive()) {
        		JpaUtil.getEntityTransaction().rollback();      
        	}
        	}
    }
}
