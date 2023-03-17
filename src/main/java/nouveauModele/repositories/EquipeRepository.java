package nouveauModele.repositories;

import nouveauModele.ConnexionBase;
import nouveauModele.HibernateUtil;
import nouveauModele.dataRepresentation.Equipe;
import nouveauModele.dataRepresentation.Joueur;
import nouveauModele.dataRepresentation.Rencontre;
import nouveauModele.dataRepresentation.Tournoi;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.CallableStatement;
import java.sql.Types;
import java.util.List;

public class EquipeRepository {
    private static EquipeRepository instance;

    public static EquipeRepository getInstance() {
        if(instance == null) {
            instance = new EquipeRepository();
        }
        return instance;
    }

    public Equipe findById(int idEquipe) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Equipe equipe = null;
        try {
            tx = session.beginTransaction();
            equipe = (Equipe) session.get(Equipe.class, idEquipe);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return equipe;
    }

    public List<Joueur> getJoueurs(Equipe equipe) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Joueur> joueurs = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM Joueur j WHERE j.equipe.idEquipe = :idEquipe");
            query.setParameter("idEquipe", equipe.getIdEquipe());
            joueurs = query.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return joueurs;
    }

    public List<Joueur> getJoueursFromNomEquipe(String nomEquipe) {
        return this.getJoueurs(this.findByNom(nomEquipe));
    }

    public Equipe findByNom(String nomEquipe) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Equipe> equipes = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM Equipe e WHERE e.nomEquipe = :nom");
            query.setParameter("nom", nomEquipe);
            equipes = query.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        if (equipes.size() > 1 ) {
            throw new RuntimeException("Doublon de nom pour ecurie alors que le nom est unique");
        } else if (equipes.size() == 0)  {
            return null;
        }
        return equipes.get(0);
    }

    // ici on assume que la liste déquipe est valide puisqu'elle est fournie par le formulaire equipe qui les contolentRe
    public void enregistrerEquipe(Equipe equipeAEnregistrer, List<Joueur> joueursAEnregistrer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(equipeAEnregistrer);
            for (Joueur j: joueursAEnregistrer) {
                j.setEquipe(equipeAEnregistrer);
                session.save(j);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public int getNbFinalesGagnes(Equipe equipe) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Rencontre> rencontres = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("SELECT r FROM Rencontre r, Jouer j, Poule p WHERE r.idRencontre = j.id.rencontre.idRencontre AND j.id.equipe.idEquipe = :idEquipe AND j.aGagne = 1 AND r.poule.idPoule = p.idPoule AND p.finale = 1");
            query.setParameter("idEquipe", equipe.getIdEquipe());
            rencontres = query.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return rencontres.size();
    }

    public List<Tournoi> getTournoisJouees(Equipe equipe) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Tournoi> tournoisJouees = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("SELECT t FROM Tournoi t, Inscrit i WHERE t.id = i.id.tournoi.id AND i.id.equipe.idEquipe = :idEquipe");
            query.setParameter("idEquipe", equipe.getIdEquipe());
            tournoisJouees = query.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return tournoisJouees;
    }



    public int getPoints(Equipe equipe) {
        try {
            CallableStatement st = ConnexionBase.getConnectionBase().prepareCall("{? =  call GET_PTS_EQUIPE(?) }");
            st.registerOutParameter(1, Types.INTEGER); // enregistrement du paramètre de sortie
            st.setInt(2, equipe.getIdEquipe()); // enregistrement du premier paramètre d'entrée

            st.execute(); // appel de la fonction

            int result = st.getInt(1); // récupération du résultat
            st.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public List<Equipe> getEquipes() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Equipe> equipes = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM Equipe e");
            equipes = query.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return equipes;
    }
}
