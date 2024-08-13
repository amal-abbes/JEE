package com.enit.exam.bibliotheque.daos.interfaces.impl;



import com.enit.exam.bibliotheque.daos.interfaces.AbonneDAO;
import com.enit.exam.bibliotheque.entities.Abonne;
import com.enit.exam.bibliotheque.entities.Ouvrage;
import com.enit.exam.bibliotheque.exceptions.BiblioException;
import com.enit.exam.bibliotheque.util.JpaUtil;

public class AbonneDaoImpl implements AbonneDAO {



	@Override
	public void ajoutAbonne(Abonne abonne) {
	    try {
	        JpaUtil.getEntityTransaction().begin();
	        JpaUtil.getEntityManager().persist(abonne);
	        JpaUtil.getEntityTransaction().commit();
	    } catch (Exception ex) {
	        JpaUtil.getEntityTransaction().rollback();
	    }
	}

    @Override
    public void suppAbonne(Abonne abonne) {
        try {
        	
        	JpaUtil.getEntityTransaction().begin();
        	
            if (abonne != null) {
                
                if (!JpaUtil.getEntityManager().contains(abonne)) {
                    abonne = JpaUtil.getEntityManager().merge(abonne);
                }

                JpaUtil.getEntityManager().remove(abonne);
                
            }
            else {
            	System.out.println("L'abonné n'existe pas");
            }

            JpaUtil.getEntityTransaction().commit();
        } catch (Exception ex) {
        	
        	if(JpaUtil.getEntityTransaction().isActive()) {
        		JpaUtil.getEntityTransaction().rollback();
        	}
        }
    }


    @Override
    public Abonne rechercheAbonne(int identite) {
    	return JpaUtil.getEntityManager().find(Abonne.class, identite);
        
    }

    @Override
    public void updateAbonne(Abonne abonne) {

        try {
        	
        	JpaUtil.getEntityTransaction().begin();
        	

            Abonne existingAbonne = JpaUtil.getEntityManager().find(Abonne.class, abonne.getNumeroIdentite());

            if (existingAbonne != null) {
            	JpaUtil.getEntityManager().merge(abonne);
            	JpaUtil.getEntityTransaction().commit();
            	
            }
            else {
            	System.out.println("L'abonné n'existe pas");
            }
            
        }catch(Exception ex){
        	if(JpaUtil.getEntityTransaction().isActive()) {
        		JpaUtil.getEntityTransaction().rollback();     
        		}
        	}
    }

    @Override
    public void emprunter(String titre, int identite) throws BiblioException {
    	try {
    		JpaUtil.getEntityTransaction().begin();

            Abonne abonne = JpaUtil.getEntityManager().find(Abonne.class, identite);

            if (abonne == null) {
                throw new BiblioException("L'abonné n'existe pas");
            }

            Ouvrage ouvrage = JpaUtil.getEntityManager().find(Ouvrage.class, titre);

            if (ouvrage == null) {
                throw new BiblioException("L'Ouvrage n'existe pas");
            }

            if (ouvrage.isDisponible()) {
                if (abonne.getOuvragePris() == null) {
                    abonne.setOuvragePris(ouvrage);
                    ouvrage.setDisponible(false);

                    JpaUtil.getEntityManager().merge(abonne);
                    JpaUtil.getEntityManager().merge(ouvrage);

                    JpaUtil.getEntityTransaction().commit();
                } else {
                	
                    throw new BiblioException("Emprunt impossible : l'abonné:"+abonne+"possède déjà un ouvrage");
                }
            } else {
                throw new BiblioException("L'ouvrage n'est pas disponible");
            }
        

            throw new BiblioException(ouvrage+":"+"Ouvrage emprunté avec succès");
    	}finally {
    		if(JpaUtil.getEntityTransaction().isActive()) {
    			JpaUtil.getEntityTransaction().rollback();
    		}
    		
    	}
    }
        
    


    @Override
    public void rendre(int identite) throws BiblioException {
    	try {
    		JpaUtil.getEntityTransaction().begin();
    		

            Abonne abonne = JpaUtil.getEntityManager().find(Abonne.class, identite);

            if (abonne == null) {
            	
                throw new BiblioException("L'abonné n'existe pas");
            }

            Ouvrage ouvrage = abonne.getOuvragePris();

            if (ouvrage == null) {
            	
                throw new BiblioException("L'abonné n'a aucun ouvrage à rendre");
            }

            abonne.setOuvragePris(null);
            ouvrage.setDisponible(true);

            JpaUtil.getEntityManager().merge(abonne);
            JpaUtil.getEntityManager().merge(ouvrage);

            JpaUtil.getEntityTransaction().commit();
            
    	
            throw new BiblioException(ouvrage+":"+"Ouvrage rendu avec succées");
        }finally {
        	if(JpaUtil.getEntityTransaction().isActive()) {
    			JpaUtil.getEntityTransaction().rollback();
    		}
          }
    	}
}
