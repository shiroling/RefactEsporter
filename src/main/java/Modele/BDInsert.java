package Modele;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import Application.Modele.Portee;

public class BDInsert {

	protected static void insererTournoi(String nomTounoi, Portee porteeTournoi, Date dateFinInscription, Date dateDebutTournoi, Date dateFinTournoi, int idJeu, int idGerant) {
		Connection connex = ConnexionBase.getConnectionBase();
		try {
			PreparedStatement st = connex.prepareStatement("Insert into Tournoi values (Seq_Tournoi.nextVal, ?, ?, ?, ?, ?, ?, ?)");
			st.setString(1, nomTounoi);
			st.setString(2, porteeTournoi.getName());
			st.setDate(3, dateFinInscription);
			st.setDate(4, dateDebutTournoi);
			st.setDate(5, dateFinTournoi);
			st.setInt(6, idJeu);
			st.setInt(7, idGerant);
			st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected static void insererPoule(int idTournoi, List<Equipe> listeEquipes) {
		Connection connex = ConnexionBase.getConnectionBase();
		try {
			PreparedStatement st = connex.prepareStatement("Insert into Poule values (Seq_Poule.nextVal, 0, ?)");
			st.setInt(1, idTournoi);
			st.executeUpdate();
		} catch (Exception ee) {
			ee.printStackTrace();
		}
		for(Equipe e : listeEquipes) {
			try {
				PreparedStatement st = connex.prepareStatement("Insert into Composer values (Seq_Poule.currval, ?)");
				st.setInt(1, e.getId());
				st.executeUpdate();
			} catch (Exception eee) {
				eee.printStackTrace();
			}
		}
	}
	
	public static void insererComposer(int idEquipe, int idPoule) {
		Connection connex = ConnexionBase.getConnectionBase();
		try {
			PreparedStatement st = connex.prepareStatement("Insert into Composer values (?, ?)");
			st.setInt(1, idEquipe);
			st.setInt(2, idPoule);
			st.executeUpdate();
			
			Poule p = new Poule(idPoule);
			if (p.isPleine()) {
				p.genererRencontres();
				p.populateRencontres();
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		}
	}
	
	protected static void insererPouleRencontresFinale(int idTournoi) {
		Connection connex = ConnexionBase.getConnectionBase();
		try {
			PreparedStatement stPoule = connex.prepareStatement("Insert into Poule values (Seq_Poule.nextVal, 1, ?)");
			stPoule.setInt(1, idTournoi);
			stPoule.executeUpdate();

			for(int i = 0; i<6; i++) {
				PreparedStatement stRencontre = connex.prepareStatement("Insert into Rencontre values (Seq_Rencontre.nextVal, ?, seq_poule.currval, ?)");
				stRencontre.setInt(1, BDSelect.getRandomArbitre());
				stRencontre.setDate(2, Poule.fixerDateRencontre(true, idTournoi));
				stRencontre.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected static void insererRencontre(int idPoule, Date dateRencontre, List<Equipe> listeEquipes) {
		Connection connex = ConnexionBase.getConnectionBase();
		try {
			PreparedStatement st = connex.prepareStatement("Insert into Rencontre values (Seq_Rencontre.nextVal, ?, ?, ?)");
			st.setInt(1, BDSelect.getRandomArbitre());
			st.setInt(2, idPoule);
			st.setDate(3, dateRencontre);
			st.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		for(Equipe e : listeEquipes) {
			try {
				PreparedStatement st = connex.prepareStatement("Insert into Jouer values (?, Seq_rencontre.currval, null)");
				st.setInt(1, e.getId());
				st.executeUpdate();

			} catch (Exception ee) {
				ee.printStackTrace();
			}
		}
	}
	
	public static void insererInscrit(Equipe e, Tournoi t) {
		Connection connex = ConnexionBase.getConnectionBase();
		try {
			PreparedStatement st = connex.prepareStatement("INSERT into inscrit VALUES(?, ?, CURRENT_DATE)");
			st.setInt(1, e.getId());
			st.setInt(2, t.getId());
			st.executeUpdate();
		} catch (Exception ee) {
			ee.printStackTrace();
		}
	}
	
	protected static void insererJouer(int idEquipe, int idRencontre) {
		Connection connex = ConnexionBase.getConnectionBase();
		try {
			PreparedStatement st = connex.prepareStatement("Insert into Jouer values (?, ?, null)");
			st.setInt(1, idEquipe);
			st.setInt(2, idRencontre);
			st.executeUpdate();
		} catch (Exception ee) {
			ee.printStackTrace();
		}
	}

	public static void insererEquipe(String nom, int idJeu, int idEcurie) {
		Connection connex = ConnexionBase.getConnectionBase();
		try {
			PreparedStatement st = connex.prepareStatement("Insert into Equipe values (seq_equipe.nextval, ?, ?, ?)");
			st.setString(1, nom);
			st.setInt(2, idJeu);
			st.setInt(3, idEcurie);
			st.executeUpdate();
			st.close();

		} catch (Exception ee) {
			ee.printStackTrace();
		}
	}

	public static void genererRencontre(int idPoule) {
		CallableStatement stmt;
		try {
			stmt = ConnexionBase.getConnectionBase().prepareCall("{ call GEN_RENCONTRE_4_POULE(?) }");
			stmt.setInt(1, idPoule); // enregistrement du premier paramètre d'entrée

			stmt.execute(); // appel de la procédure
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void genererPoules(int idTournoi) {
		CallableStatement stmt;
		try {
			stmt = ConnexionBase.getConnectionBase().prepareCall("{ call GEN_POULES_4_TOURNOI(?) }");
			stmt.setInt(1, idTournoi); // enregistrement du premier paramètre d'entrée

			stmt.execute(); // appel de la procédure
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void designerVainceurRencontre(int idRencontre, int idEquipeVaincueur) {
		CallableStatement stmt;
		try {
			stmt = ConnexionBase.getConnectionBase().prepareCall("{ call SELECT_VAINCEUR_RENCONTRE(?, ?) }");
			stmt.setInt(1, idEquipeVaincueur); 
			stmt.setInt(2, idRencontre); 

			stmt.execute(); // appel de la procédure	
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void peuplerPoules(int idTournoi) {
		CallableStatement stmt;
		try {
			stmt = ConnexionBase.getConnectionBase().prepareCall("{ call POPULATE_POULE_4_TOURNOI(?) }");
			stmt.setInt(1, idTournoi); // enregistrement du premier paramètre d'entrée

			stmt.execute(); // appel de la procédure
			stmt.close();

		} catch (SQLException e) {
			if(!e.getMessage().contains("CTQ4266A.SYS_C001313482")) {
				e.printStackTrace();
			}
			
		}
	}

	public static void populateRencontres(int idPoule) {
		CallableStatement stmt;
		try {
			stmt = ConnexionBase.getConnectionBase().prepareCall("{ call POPULATE_RENCONTRE_4_POULE(?) }");
			stmt.setInt(1, idPoule); // enregistrement du premier paramètre d'entrée

			stmt.execute(); // appel de la procédure
			stmt.close();

		} catch (SQLException e) {
			if(!e.getMessage().contains("CTQ4266A.SYS_C001313482")) {
				e.printStackTrace();
			}
			
		}
	}
	
	public static void insererJoueur(String nom, String prenom, Date naissance, String pseudo, int idEquipe) {
		Connection connex = ConnexionBase.getConnectionBase();
		try {
			PreparedStatement st = connex.prepareStatement("Insert into Joueur values (seq_joueur.nextval, ?, ?, ?, ?, ?)");
			st.setString(1, nom);
			st.setString(2, prenom);
			st.setDate(3, naissance);
			st.setString(4, pseudo);
			st.setInt(5, idEquipe);
			st.executeUpdate();
			st.close();

		} catch (Exception ee) {
			ee.printStackTrace();
		}
		
	}
}

	
