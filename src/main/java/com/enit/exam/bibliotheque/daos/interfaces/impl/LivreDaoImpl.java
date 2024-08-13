package com.enit.exam.bibliotheque.daos.interfaces.impl;




import com.enit.exam.bibliotheque.daos.interfaces.LivreDAO;
import com.enit.exam.bibliotheque.entities.Livre;
import com.enit.exam.bibliotheque.util.JpaUtil;

public class LivreDaoImpl implements LivreDAO {

    @Override
    public void ajoutLivre(Livre livre) {

        try {
        	JpaUtil.getEntityTransaction().begin();
        	JpaUtil.getEntityManager().persist(livre);
        	JpaUtil.getEntityTransaction().commit();
        }catch (Exception ex) {
	        JpaUtil.getEntityTransaction().rollback();
	    }
    }
    /*Hérite les même méthodes que l'ouvrage(ajouter,update,supprimer,rechercher)*/
}
