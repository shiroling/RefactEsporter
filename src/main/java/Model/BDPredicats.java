package Model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import commun.Portee;

public class BDPredicats {

	public static boolean estResultatRenseigne(int idRencontre) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery("Select id_equipe from Jouer where id_Rencontre = " + idRencontre + " and a_gagne = 1");
			boolean check = rs.next();
			st.close();
			if (check) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean existeNomTournoi(String nomTournoi) {
		try {
			PreparedStatement st = ConnexionBase.getConnectionBase().prepareStatement("Select Count(id_tournoi)as count from Tournoi where CONTAINS(NOM, ?, 1) > 0");
			st.setString(1, nomTournoi);
			ResultSet rs = st.executeQuery();
			rs.next();
			boolean b  = rs.getInt("count") > 0;
			st.close();
			return b;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean existeGerant(int IdGerant){
	    try {
	        PreparedStatement st = ConnexionBase.getConnectionBase().prepareStatement("Select count(nom) as count from Gerant where id_gerant = ?");
	        st.setInt(1, IdGerant);
	        
	        ResultSet rs = st.executeQuery();
	        rs.next();
	        boolean b  = rs.getInt(1) > 0;
			st.close();
			return b;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	public static boolean isGestionnaire(String id, String mdp) {
	    Connection connex = ConnexionBase.getConnectionBase();
	    try {
	        CallableStatement st = connex.prepareCall("{? = call IS_GESTIONNAIRE (?, ?)}");
	        st.registerOutParameter(1, Types.INTEGER);
	        st.setString(2, id);
	        st.setString(3, mdp);
	        st.execute();
	        return (st.getInt(1) == 1);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	public static boolean isManager(String nom, String mdp) {
	    try {
	    	PreparedStatement st = ConnexionBase.getConnectionBase().prepareStatement("SELECT id_ecurie FROM Ecurie where nom_manager = ? AND mdp_manager = ?");
	        st.setString(1, nom);
	        st.setString(2, mdp);
	    	ResultSet rs = st.executeQuery();
	    	boolean check = rs.next();
	    	st.close();
	    	return check;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
	public static boolean isArbitre(String nom, String mdp) {
	    try {
	    	PreparedStatement st = ConnexionBase.getConnectionBase().prepareStatement("SELECT ID_ARBITRE FROM ARBITRE where nom = ? AND mdp = ?");
	        st.setString(1, nom);
	        st.setString(2, mdp);
	    	ResultSet rs = st.executeQuery();
	    	boolean check = rs.next();
	    	st.close();
	    	return check;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	public static boolean estTournoiEnCours(int id) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
	    	ResultSet rs = st.executeQuery("SELECT id_tournoi FROM tournoi WHERE tournoi.datedebuttournoi < CURRENT_DATE AND tournoi.datefintournoi > CURRENT_DATE AND id_tournoi = " + id);
	    	boolean check = rs.next();
	    	st.close();
	    	return check;
		} catch (Exception e) {
			e.printStackTrace();
	        return false;
		}
	}
	
	public static boolean estTournoiFini(int id) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
	    	ResultSet rs = st.executeQuery("SELECT id_tournoi FROM tournoi WHERE tournoi.datefintournoi < CURRENT_DATE AND id_tournoi = " + id);
	    	boolean check = rs.next();
	    	st.close();
	    	return check;
		} catch (Exception e) {
			e.printStackTrace();
	        return false;
		}
	}
	
	public static boolean estTournoiAVenir(int id) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
	    	ResultSet rs = st.executeQuery("SELECT id_tournoi FROM tournoi WHERE tournoi.datedebuttournoi > CURRENT_DATE AND id_tournoi = " + id);
	    	boolean check = rs.next();
	    	st.close();
	    	return check;
		} catch (Exception e) {
			e.printStackTrace();
	        return false;
		}
	}
	
	public static boolean sontInscriptionsFinies(int id) {
		try {
			PreparedStatement st = ConnexionBase.getConnectionBase().prepareStatement("SELECT count(id_tournoi)as count FROM tournoi t WHERE t.datefininsriptions < CURRENT_DATE AND id_tournoi = ?");
	    	st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			rs.next();
	    	boolean check = rs.getInt("count") > 0;
			st.close();
	    	return check;
		} catch (Exception e) {
			e.printStackTrace();
	        return false;
		}
	}

	
	public static boolean estTournoiSurJeu(int id, int idJeu) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
	    	ResultSet rs = st.executeQuery("SELECT id_tournoi FROM tournoi WHERE tournoi.id_jeu = " + idJeu + " AND tournoi.id_tournoi = " + id);
	    	boolean check = rs.next();
	    	st.close();
	    	return check;
		} catch (Exception e) {
			e.printStackTrace();
	        return false;
		}
	}

	public static boolean estTournoiDePortee(int id, Portee p) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
	    	ResultSet rs = st.executeQuery("SELECT id_tournoi FROM tournoi WHERE tournoi.portee = '" + p.getName() + "' AND tournoi.id_tournoi = " + id);
	    	boolean check = rs.next();
	    	st.close();
	    	return check;
		} catch (Exception e) {
			e.printStackTrace();
	        return false;
		}
	}

	public static boolean estTournoiMulti(Tournoi t) {
		try {
			PreparedStatement st = ConnexionBase.getConnectionBase().prepareStatement("SELECT count(*) as count FROM tournoi t WHERE t.ID_TOURNOI = ? AND t.nom LIKE ? ");
	    	st.setInt(1, t.getId());
	    	st.setString(2, t.getNom().split("-")[0]+"%-%");
			ResultSet rs = st.executeQuery();
	    	rs.next();
	    	boolean check = rs.getInt("count") > 0;
	    	st.close();
	    	return check;
		} catch (Exception e) {
			e.printStackTrace();
	        return false;
		}
	}

	public static boolean estMatchSurJeu(Rencontre r, int idJeu) {
		try {
			PreparedStatement st = ConnexionBase.getConnectionBase().prepareStatement("SELECT * FROM tournoi t, poule p WHERE ? = p.id_poule AND p.id_tournoi = t.id_tournoi AND t.id_jeu = ?");
	    	st.setInt(1, r.getIdPoule());
	    	st.setInt(2, idJeu);
	    	
			ResultSet rs = st.executeQuery();
	    	
	    	boolean b = rs.next();
	    	st.close();
	    	return b;
		} catch (Exception e) {
			e.printStackTrace();
	        return false;
		}
	}

	public static boolean estMatchTournoi(Rencontre r, int idTournoi) {
		try {
			PreparedStatement st = ConnexionBase.getConnectionBase().prepareStatement("SELECT * FROM tournoi t, poule p WHERE p.id_poule = ? AND p.id_tournoi = ? ");
	    	st.setInt(1, r.getIdPoule());
	    	st.setInt(2, idTournoi);
	    	
	    	ResultSet rs = st.executeQuery();
	    	
	    	boolean check = rs.next();
	    	
	    	st.close();
	    	return check;
		} catch (Exception e) {
			e.printStackTrace();
	        return false;
		}
	}
	
	public static boolean estMatchAvecEquipe(Rencontre r, int idEquipe) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
	    	ResultSet rs = st.executeQuery("SELECT id_equipe FROM jouer WHERE id_equipe = " + idEquipe + " AND id_rencontre = " + r.getId());
	    	boolean check = rs.next();
	    	st.close();
	    	return check;
		} catch (Exception e) {
			e.printStackTrace();
	        return false;
		}
	}

	public static boolean estMatchPoule(Rencontre r , int idPoule) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
	    	ResultSet rs = st.executeQuery("SELECT id_poule FROM rencontre WHERE id_rencontre = " + r.getId() + " AND id_poule = " + idPoule);
	    	boolean check = rs.next();
	    	st.close();
	    	return check;
		} catch (Exception e) {
			e.printStackTrace();
	        return false;
		}
	}
	
	public static boolean estEquipeSurJeu(Equipe equipe, Integer idJeu) {
		try {
			PreparedStatement st = ConnexionBase.getConnectionBase().prepareStatement("SELECT COUNT(*) as count FROM EQUIPE e WHERE e.ID_EQUIPE = ? AND e.ID_JEU = ?");
			st.setInt(1, equipe.getId());
			st.setInt(2, idJeu);
			ResultSet rs = st.executeQuery();
			
			rs.next();
	    	boolean check = rs.getInt("count") > 0;
			st.close();
	    	return check;
		} catch (Exception e) {			
			e.printStackTrace();
			return false;

		}
	}

	public static boolean estRencontreFinie(Rencontre r) {
		try {
			PreparedStatement st = ConnexionBase.getConnectionBase().prepareStatement("SELECT * FROM rencontre r WHERE r.DATE_RENCONTRE < CURRENT_DATE AND id_rencontre = ?");
	    	st.setInt(1, r.getId());
			ResultSet rs = st.executeQuery();
	    	boolean check = rs.next();
	    	st.close();
	    	return check;
		} catch (Exception e) {
			e.printStackTrace();
	        return false;
		}
	}

	public static boolean isIscriteTournoi(Equipe equipe, Tournoi tournoi) {
		try {
			PreparedStatement st = ConnexionBase.getConnectionBase().prepareStatement("SELECT i.id_equipe FROM Inscrit i WHERE i.id_equipe = ? and i.id_tournoi = ?");
	    	st.setInt(1, equipe.getId());
	    	st.setInt(2, tournoi.getId());
			ResultSet rs = st.executeQuery();
	    	boolean check = rs.next();
	    	st.close();
	    	return check;
		} catch (Exception e) {
			e.printStackTrace();
	        return false;
		}
	}
	
	public static boolean estPouleFinie(int idPoule) {
		CallableStatement stmt;
		try {
			stmt = ConnexionBase.getConnectionBase().prepareCall("{? =  call EST_POULE_FINIE(?) }");
			stmt.registerOutParameter(1, Types.INTEGER); // enregistrement du paramètre de sortie
			stmt.setInt(2, idPoule); // enregistrement du premier paramètre d'entrée

			stmt.execute(); // appel de la fonction

			int result = stmt.getInt(1); // récupération du résultat	
			stmt.close();
			if(result == 0) {
				return false;
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	
}
