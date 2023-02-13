package Modele;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import Application.Portee;

public class BDinit {
	public static void init(Ecurie e) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery("Select Nom_Ecurie, Nom_Manager, mdp_Manager from Ecurie where Id_Ecurie = " + e.getId());
			if(rs.next()) {
				e.setNom(rs.getString("Nom_Ecurie"));
				e.setNomManager(rs.getString("Nom_Manager"));
				e.setMdpManager(rs.getString("mdp_Manager"));
			}
			st.close();
		} catch (Exception err) {
			err.printStackTrace();
		}
	}

	public static void init(Equipe e) {
		try {
			PreparedStatement st = ConnexionBase.getConnectionBase().prepareStatement("Select nom_Equipe as eee, Id_Jeu, Id_Ecurie from Equipe where Id_Equipe = ?");
			st.setInt(1, e.getId());
			ResultSet rs = st.executeQuery();
			rs.next();
			e.setNom(rs.getString("eee"));
			e.setIdJeu(rs.getInt("Id_Jeu"));
			e.setIdEcurie(rs.getInt("Id_Ecurie"));
	
			st.close();
		} catch (Exception err) {
			err.printStackTrace();
		}
	}

	public static void init(Joueur j) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery(
					"Select nom, prenom, date_de_naissance, pseudo, id_equipe from Joueur where id_joueur = "
							+ j.getId());
			rs.next();
			j.setNom(rs.getString(1));
			j.setPrenom(rs.getString(2));
			j.setNaissance(rs.getDate(3));
			j.setPseudo(rs.getString(4));
			j.setIdEquipe(rs.getInt(5));
	
			st.close();
		} catch (Exception err) {
			err.printStackTrace();
		}
	}

	public static void init(Jeu j) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery("Select nom_jeu, path_logo from Jeu where Id_Jeu = " + j.getId());
			rs.next();
			j.setNom(rs.getString(1));
			j.setPathLogo(rs.getString(2));
			st.close();
		} catch (Exception err) {
			err.printStackTrace();
		}
	}

	public static void init(Poule p) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery("Select finale, id_tournoi from poule where Id_poule = " + p.getId());
			rs.next();
			if (rs.getInt("finale") > 0) {
				p.setIsFinale(true);
			} else {
				p.setIsFinale(false);
			}
	
			p.setIdTournoi(rs.getInt("id_tournoi"));
	
			st.close();
		} catch (Exception err) {
			err.printStackTrace();
		}
	}

	public static void init(Tournoi t) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery(
					"Select NOM, portee, DATEFININSRIPTIONS, DATEDEBUTTOURNOI, DATEFINTOURNOI, ID_JEU, ID_GERANT from tournoi where Id_tournoi = "
							+ t.getId());
			rs.next();
			t.setNom(rs.getString("NOM"));
			t.setDateFinInscriptions(rs.getDate("DATEFININSRIPTIONS"));
			t.setDateDebut(rs.getDate("DATEDEBUTTOURNOI"));
			t.setDateFin(rs.getDate("DATEFINTOURNOI"));
			t.setIdJeu(rs.getInt("ID_JEU"));
			t.setIdGerant(rs.getInt("ID_GERANT"));
	
			String s = rs.getString("portee");
			switch (s) {
			case "Local": {
				t.setPortee(Portee.LOCAL);
				break;
			}
			case "International": {
				t.setPortee(Portee.INTERNATIONAL);
				break;
			}
			case "National": {
				t.setPortee(Portee.NATIONAL);
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + s);
			}
	
			st.close();
		} catch (Exception err) {
			err.printStackTrace();
		}
	}

	public static void init(Rencontre r) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			
			ResultSet rs = st.executeQuery("Select id_arbitre, id_poule, date_rencontre from rencontre where id_rencontre = " + r.getId());
			if(rs.next()) {
				r.setIdArbitre(rs.getInt("id_arbitre"));
				r.setIdPoule(rs.getInt("id_poule"));
				r.setDate(rs.getDate("date_rencontre"));
				st.close();
			};
		} catch (Exception err) {
			err.printStackTrace();
		}
	}


}
