package com.enit.exam.bibliotheque.daos.interfaces.impl;



import com.enit.exam.bibliotheque.daos.interfaces.VideoDAO;
import com.enit.exam.bibliotheque.entities.Video;
import com.enit.exam.bibliotheque.util.JpaUtil;

public class VideoDaoImpl implements VideoDAO {

    @Override
    public void ajoutVideo(Video video) {

        try {
        	JpaUtil.getEntityManager().getTransaction().begin();
        	JpaUtil.getEntityManager().persist(video);
        	JpaUtil.getEntityTransaction().commit();
        } catch(Exception ex){
        	JpaUtil.getEntityTransaction().rollback();      
        	}
    }
    /*Hérite les même méthodes que l'ouvrage(ajouter,update,supprimer,rechercher)*/
}
