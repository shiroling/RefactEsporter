	package modele;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class BDSelect {

	public BDSelect(Connection connex) {
		super();
	}

	// Partie acquisition Listes Simples
	public static List<Poule> getListePoules() {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery("Select id_Poule from Poule");

			List<Poule> l = new ArrayList<>();
			while (rs.next()) {
				l.add(new Poule(rs.getInt(1)));
			}
			st.close();
			return l;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static List<Joueur> getListeJoueurs() {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery("Select id_Joueur from Joueur");

			List<Joueur> joueurs = new ArrayList<>();
			while (rs.next()) {
				joueurs.add(new Joueur(rs.getInt(1)));
			}
			st.close();
			return joueurs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static List<Equipe> getListeEquipes() {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery("SELECT id_equipe from equipe");
			List<Equipe> equipes = new ArrayList<>();
			while (rs.next()) {
				equipes.add(new Equipe(rs.getInt("id_equipe")));
			}
			rs.close();
			st.close();
			return equipes;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static List<Jeu> getListeJeux() {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery("SELECT id_Jeu from Jeu");
			List<Jeu> jeux = new ArrayList<>();
			while (rs.next()) {
				jeux.add(new Jeu(rs.getInt(1)));
			}
			st.close();
			return jeux;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static List<Tournoi> getListeTournois() {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery("Select id_tournoi from tournoi");

			List<Tournoi> t = new ArrayList<>();
			while (rs.next()) {
				t.add(new Tournoi(rs.getInt(1)));
			}
			st.close();
			return t;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static List<Rencontre> getListeRencontres() {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery("Select id_rencontre from rencontre");

			List<Rencontre> t = new ArrayList<>();
			while (rs.next()) {
				t.add(new Rencontre(rs.getInt(1)));
			}
			st.close();
			return t;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static List<Ecurie> getListeEcurie() {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery("Select id_ecurie from ecurie");

			List<Ecurie> t = new ArrayList<>();
			while (rs.next()) {
				t.add(new Ecurie(rs.getInt(1)));
			}
			st.close();
			return t;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	
	//Partie acquisition listes avec filtres	
	public static List<Rencontre> getListeRencontreFromPoule(int idPoule) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery("Select id_rencontre from rencontre WHERE id_Poule = " + idPoule);

			List<Rencontre> t = new ArrayList<>();
			while (rs.next()) {
				t.add(new Rencontre(rs.getInt(1)));
			}
			st.close();
			return t;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List<Rencontre> getListeRencontreFromEquipe(int idEquipe) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery("Select id_rencontre from rencontre, composer WHERE composer.id_equipe = " + idEquipe + "AND composer.id_poule = rencontre.id_poule");

			List<Rencontre> t = new ArrayList<>();
			while (rs.next()) {
				t.add(new Rencontre(rs.getInt(1)));
			}
			st.close();
			return t;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static List<Rencontre> getRencontresAVenir() {
		Connection connex = ConnexionBase.getConnectionBase();
		try {
			Statement st = connex.createStatement();
			ResultSet rs = st.executeQuery("SELECT id_Rencontre FROM Rencontre where Date_Rencontre > getDate()");
			List<Rencontre> rencontres = new ArrayList<>();
			while (rs.next()) {
				rencontres.add(new Rencontre(rs.getInt(1)));
			}
			rs.close();
			st.close();
			return rencontres;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static List<Rencontre> getRencontresPassees() {
		Connection connex = ConnexionBase.getConnectionBase();
		try {
			Statement st = connex.createStatement();
			ResultSet rs = st.executeQuery("SELECT id_Rencontre FROM Rencontre where Date_Rencontre < getDate()");
			List<Rencontre> rencontres = new ArrayList<>();
			while (rs.next()) {
				rencontres.add(new Rencontre(rs.getInt(1)));
			}
			rs.close();
			st.close();
			return rencontres;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static List<Joueur> getListeJoueursFromEquipe(int id) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery("Select id_Joueur from Joueur WHERE ID_EQUIPE = " + id);

			List<Joueur> joueurs = new ArrayList<>();
			while (rs.next()) {
				joueurs.add(new Joueur(rs.getInt(1)));
			}
			st.close();
			return joueurs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List<Equipe> getListeEquipesFromEcurie(int id) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery("SELECT id_equipe from Equipe WHERE id_Ecurie = " + id);
			List<Equipe> equipes = new ArrayList<>();
			while (rs.next()) {
				equipes.add(new Equipe(rs.getInt(1)));
			}
			rs.close();
			st.close();
			return equipes;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static List<Equipe> getListeEquipesFromTournoi(int id) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery("SELECT id_equipe from inscrit WHERE id_tournoi = " + id);
			List<Equipe> equipes = new ArrayList<>();
			while (rs.next()) {
				equipes.add(new Equipe(rs.getInt("id_equipe")));
			}
			st.close();
			return equipes;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static List<Equipe> getListeEquipesFromPoule(int id) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery("SELECT id_equipe from Composer WHERE id_poule = " + id);
			List<Equipe> equipes = new ArrayList<>();
			while (rs.next()) {
				equipes.add(new Equipe(rs.getInt(1)));
			}

			st.close();
			return equipes;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static List<Equipe> getEquipesFromRencontre(int idRencontre) {
		Connection connex = ConnexionBase.getConnectionBase();
		try {
			Statement st = connex.createStatement();
			ResultSet rs = st.executeQuery("Select id_equipe from Jouer where id_Rencontre = " + idRencontre);

			List<Equipe> equipes = new ArrayList<>();
			while (rs.next()) {
				equipes.add(new Equipe(rs.getInt(1)));
			}
			rs.close();
			st.close();
			return equipes;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static List<Tournoi> getTournoisEnCours() {
		Connection connex = ConnexionBase.getConnectionBase();
		try {
			Statement st = connex.createStatement();
			ResultSet rs = st.executeQuery(
					"SELECT id_tournoi FROM Tournoi where DateDebutTournoi <= CURRENT_DATE and DateFinTournoi >= CURRENT_DATE");
			List<Tournoi> tournois = new ArrayList<>();
			while (rs.next()) {
				tournois.add(new Tournoi(rs.getInt(1)));
			}
			st.close();
			return tournois;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static List<Tournoi> getTournoisFinis() {
		Connection connex = ConnexionBase.getConnectionBase();
		try {
			Statement st = connex.createStatement();
			ResultSet rs = st.executeQuery("SELECT id_tournoi FROM Tournoi where DateFinTournoi < CURRENT_DATE");
			List<Tournoi> tournois = new ArrayList<>();
			while (rs.next()) {
				tournois.add(new Tournoi(rs.getInt(1)));
			}
			rs.close();
			st.close();
			return tournois;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static List<Tournoi> getTournoisAVenir() {
		Connection connex = ConnexionBase.getConnectionBase();
		try {
			Statement st = connex.createStatement();
			ResultSet rs = st.executeQuery("SELECT id_tournoi FROM Tournoi where DateDebutTournoi > CURRENT_DATE");
			List<Tournoi> tournois = new ArrayList<>();
			while (rs.next()) {
				tournois.add(new Tournoi(rs.getInt("id_tournoi")));
			}
			rs.close();
			st.close();
			return tournois;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static List<Tournoi> getTournoisIscriptionsNonFinies() {
		Connection connex = ConnexionBase.getConnectionBase();
		try {
			Statement st = connex.createStatement();
			ResultSet rs = st.executeQuery("SELECT id_tournoi FROM Tournoi where DateDebutTournoi > CURRENT_DATE");
			List<Tournoi> tournois = new ArrayList<>();
			while (rs.next()) {
				tournois.add(new Tournoi(rs.getInt("id_tournoi")));
			}
			rs.close();
			st.close();
			return tournois;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static int getNombreInscritTournois(int idTournoi) {
		Connection connex = ConnexionBase.getConnectionBase();
		try {
			Statement st = connex.createStatement();
			ResultSet rs = st.executeQuery("SELECT count(id_equipe) FROM inscrit WHERE id_tournoi = " + idTournoi);
			rs.next();
			int nbInscrits = rs.getInt(1);
			rs.close();
			st.close();
			return nbInscrits;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public static List<Poule> getPoulesTournoi(int idTournoi) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery("SELECT id_poule FROM poule where id_tournoi = " + idTournoi);
			List<Poule> poules = new ArrayList<>();
			while (rs.next()) {
				poules.add(new Poule(rs.getInt("id_poule")));
			}
			st.close();
			return poules;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
  
	// Acquisitions données toutes seules
	public String getNomArbitre(int idArbitre) {
    	try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery("Select nom from Arbitre where id_arbitre = " + idArbitre);
			rs.next();
			String var = rs.getString(1);
			rs.close();
			st.close();
			return var;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }    

	public static Equipe getVainqueurRencontre(int idRencontre) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery(
					"Select id_equipe from Jouer where id_Rencontre = " + idRencontre + " and a_gagne = 1");
			rs.next();
			int var = rs.getInt(1);
			rs.close();
			st.close();
			return new Equipe(var);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Poule getFinaleFromTournoi(int idTournoi) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery(
					"SELECT id_poule FROM poule WHERE id_tournoi = " + idTournoi + "  AND finale = 1");
			rs.next();
			int var = rs.getInt(1);
			rs.close();
			st.close();
			return new Poule(var);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Equipe getPerdantRencontre(int idRencontre) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery(
					"Select id_equipe from Jouer where id_Rencontre = " + idRencontre + " and a_gagne = O");
			rs.next();
			int var = rs.getInt(1);
			rs.close();
			st.close();
			return new Equipe(var);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Date getDateInscriptionEquipe(int idTournoi, int idEquipe) {
		Connection connex = ConnexionBase.getConnectionBase();
		try {
			PreparedStatement st = connex.prepareStatement("Select dateInscription from inscrit where id_tournoi = ? and id_tournoi = ?");
			st.setInt(1, idTournoi);
			st.setInt(2, idEquipe);
			
			
			
			ResultSet rs = st.executeQuery();
			rs.next();
			Date result = rs.getDate(1);
			st.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	
	
	// Acquisitions calculées
	public static int getPointsEquipe(int idEquipe) {
		try {
			CallableStatement st = ConnexionBase.getConnectionBase().prepareCall("{? =  call GET_PTS_EQUIPE(?) }");
			st.registerOutParameter(1, Types.INTEGER); // enregistrement du paramètre de sortie
			st.setInt(2, idEquipe); // enregistrement du premier paramètre d'entrée

			st.execute(); // appel de la fonction

			int result = st.getInt(1); // récupération du résultat	
			st.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public static float getAgeMoyenEquipe(int idEquipe) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery("Select avg(CURRENT_DATE - DATE_DE_NAISSANCE)/365.25 FROM Joueur WHERE ID_EQUIPE = " + idEquipe);
			st.close();
			return rs.getFloat(1);
		} catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public static int getIdJeu(String string) {
		try {
			PreparedStatement st = ConnexionBase.getConnectionBase().prepareStatement("Select id_jeu from Jeu where nom_jeu = ?");
			st.setString(1, string);
			ResultSet rs = st.executeQuery();
			rs.next();
			int var = rs.getInt("id_jeu");
			st.close();
			return var;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public static int getIdJoueurFromPseudo(String pseudo) {
		try {
			PreparedStatement st = ConnexionBase.getConnectionBase().prepareStatement("Select id_joueur from Joueur where PSEUDO = ?");
			st.setString(1, pseudo);
			ResultSet rs = st.executeQuery();
			rs.next();
			int var = rs.getInt("id_joueur");
			st.close();
			return var;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public static int getIdEquipeFromNom(String nom) {
		try {
			PreparedStatement st = ConnexionBase.getConnectionBase().prepareStatement("Select id_equipe from Equipe where NOM_EQUIPE = ?");
			st.setString(1, nom);
			ResultSet rs = st.executeQuery();
			rs.next();
			int var = rs.getInt("id_equipe");
			st.close();
			return var;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public static int getIdGestionnaireFromLogs(String nom, String mdp) {
	    try {
			PreparedStatement st = ConnexionBase.getConnectionBase().prepareStatement("SELECT ID_GERANT FROM Gerant where nom = ? AND mdp = ?");
			st.setString(1, nom);
			st.setString(2, mdp);
			ResultSet rs = st.executeQuery();
	    	if(rs.next()) {

				int var = rs.getInt("ID_GERANT");
				st.close();
				return var;
			}else {
				return -1;
			}
		} catch (Exception e) {
	        e.printStackTrace();
	        return -1;
	    }
	}
	
	public static int getIdArbitreFromLogs(String nom, String mdp) {
	    try {
			PreparedStatement st = ConnexionBase.getConnectionBase().prepareStatement("SELECT ID_ARBITRE FROM ARBITRE where nom = ? AND mdp = ?");
			st.setString(1, nom);
			st.setString(2, mdp);
			ResultSet rs = st.executeQuery();
	    	if(rs.next()) {

				int var = rs.getInt("ID_ARBITRE");
				st.close();
				return var;
			}else {
				return -1;
			}
		} catch (Exception e) {
	        e.printStackTrace();
	        return -1;
	    }
	}
	
	public static int getIdManagerFromLogs(String nom, String mdp) {
	    try {
			PreparedStatement st = ConnexionBase.getConnectionBase().prepareStatement("SELECT ID_ECURIE FROM Ecurie where NOM_MANAGER = ? AND MDP_MANAGER = ?");
			st.setString(1, nom);
			st.setString(2, mdp);
			ResultSet rs = st.executeQuery();
	    	if (rs.next()) {

				int var = rs.getInt("ID_ECURIE");
				st.close();
				return var;
			}else {
				return -1;
			}
		} catch (Exception e) {
	        e.printStackTrace();
	        return -1;
	    }
	}

	public static int getIdEcurieFromNom(String nomEcurie) {
	    try {
			PreparedStatement st = ConnexionBase.getConnectionBase().prepareStatement("SELECT ID_ecurie FROM Ecurie where Nom_Ecurie = ?");
			st.setString(1, nomEcurie);
			ResultSet rs = st.executeQuery();
	        rs.next();
	        int var = rs.getInt("ID_ecurie");
			st.close();
			return var;	        
	    } catch (Exception e) {
	        e.printStackTrace();
	        return -1;
	    }
	}

	public static int getIdTournoiFromNom(String nom) {
	    try {
			PreparedStatement st = ConnexionBase.getConnectionBase().prepareStatement("SELECT Id_Tournoi FROM Tournoi where nom = ?");
			st.setString(1, nom);
			ResultSet rs = st.executeQuery();
	        rs.next();
	        int var = rs.getInt("Id_Tournoi");
			st.close();
			return var;	        
	    } catch (Exception e) {
	        e.printStackTrace();
	        return -1;
	    }
	}

	public static int getRandomArbitre() {
		try {
			PreparedStatement st = ConnexionBase.getConnectionBase().prepareStatement("SELECT id_arbitre FROM (SELECT id_arbitre FROM arbitre ORDER BY dbms_random.value) WHERE rownum = 1");
			ResultSet rs = st.executeQuery();
	        rs.next();
	        int var = rs.getInt("Id_arbitre");
			st.close();
			return var;	        
	    } catch (Exception e) {
	        e.printStackTrace();
	        return -1;
	    }
	}
	
	public static boolean equipeDejaPresente(String nom) {
		try {
			PreparedStatement st = ConnexionBase.getConnectionBase().prepareStatement("select id_equipe from equipe where equipe.nom_equipe = ?");
			st.setString(1, nom);
			ResultSet rs = st.executeQuery();
	        boolean var = rs.next();
			st.close();
			rs.close();
			return var;	        
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	public static Equipe getPremierPoule(int idPoule) {
		CallableStatement stmt;
		try {
			stmt = ConnexionBase.getConnectionBase().prepareCall("{? =  call GET_PREMIER_POULE(?) }");
			stmt.registerOutParameter(1, Types.INTEGER); // enregistrement du paramètre de sortie
			stmt.setInt(2, idPoule); // enregistrement du premier paramètre d'entrée

			stmt.execute(); // appel de la fonction

			int result = stmt.getInt(1); // récupération du résultat	
			stmt.close();
			
			return new Equipe(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static List<Equipe> getClassementTournoi(int idTournoi) {
		try {
			PreparedStatement st = ConnexionBase.getConnectionBase().prepareStatement("select j.id_equipe id, sum(j.a_gagne) nbWin from jouer j, rencontre r, poule p, TOURNOI t, EQUIPE e	where j.id_rencontre = r.id_rencontre and r.id_poule = p.id_poule AND p.ID_TOURNOI = t.ID_TOURNOI AND j.ID_EQUIPE = e.ID_EQUIPE	and t.ID_TOURNOI = ? group by j.id_equipe ORDER BY nbWin DESC, GET_MOY_AGE(e.ID_EQUIPE)");
			st.setInt(1, idTournoi);

			ResultSet rs = st.executeQuery();

			List<Equipe> lc = new ArrayList<>();
			while (rs.next()) {
				lc.add(new Equipe(rs.getInt(1)));	
			}
			st.close();
			return lc;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<Equipe> getClassementGeneral() {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery("SELECT id_equipe, points from classement_general");

			List<Equipe> lc = new ArrayList<>();
			Equipe e = null; 
			while (rs.next()) {
				e = new Equipe(rs.getInt(1));
				e.setPoints(rs.getInt(2));
				lc.add(e);
			}
			st.close();
			return lc;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
