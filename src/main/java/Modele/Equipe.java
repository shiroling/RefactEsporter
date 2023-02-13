package Modele;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Equipe extends BDEntity implements Comparable<Equipe> {
	private String nom;
	private int idJeu;
	private int idEcurie;
	private int points;
	
	public Equipe(int id) {
		super(id);
		this.nom = null;
		this.idJeu = -1;
		this.idEcurie = -1;
		this.points = -1;
	}

	public void init() {
		BDinit.init(this);
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	public void setIdJeu(int idJeu) {
		this.idJeu = idJeu;
	}


	public void setIdEcurie(int idEcurie) {
		this.idEcurie = idEcurie;
	}
	
	public void setPoints(int pts) {
		this.points = pts;
	}
	
	public int getPoints() {
		if(this.points == -1) {
			this.setPoints(BDSelect.getPointsEquipe(this.getId()));
		}
		return points;
	}

	public int getId() {
		return super.getId();
	}

	public String getNom() {
		if(this.nom == null) {
			this.init();
		}
		return nom;
	}

	public int getIdJeu() {
		if(this.idJeu == -1) {
			this.init();
		}
		return idJeu;
	}

	public int getIdEcurie() {
		if(this.idEcurie == -1) {
			this.init();
		}
		return idEcurie;
	}
	
	public List<Joueur> getListJoueur() {
		return BDSelect.getListeJoueursFromEquipe(getId());
	}
	
	public List<Rencontre> getRencontresJouees() {
		return BDSelect.getListeRencontreFromEquipe(getId());
	}

	public List<Equipe> getAll() {
		return Equipe.getToutesLesEquipes();
	}
	
	public static List<Equipe> getToutesLesEquipes() {
		Connection connex = ConnexionBase.getConnectionBase();
		try {
			Statement st = connex.createStatement();
			ResultSet rs = st.executeQuery("SELECT id_Equipe from Equipe");
			List<Equipe> equipes = new ArrayList<>();
			while(rs.next()) {
				equipes.add(new Equipe(rs.getInt(1)));
			}
			rs.close();
			st.close();
			return equipes;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public Jeu getJeu() {
		return new Jeu(this.getIdJeu());
	}
	
	public Ecurie getEcurie() {
		return new Ecurie(this.getIdEcurie());
	}

	public static String[] getStringEquipes() {
		List<Equipe> equipes = Equipe.getToutesLesEquipes();
		String[] nomEquipes = new String[equipes.size()];
		for(int i = 0; i < equipes.size() ; i++) {
			nomEquipes[i] = equipes.get(i).toString();
		}
		return nomEquipes;
	}

	@Override
	public String toString() {
		return this.getNom();
	}

	@Override
	public int compareTo(Equipe o) throws IllegalArgumentException {
		if(!(o instanceof Equipe)) {
			throw new IllegalArgumentException("l'objet en entrée n'est pas une instance d'équipe");
		}
		Equipe e = (Equipe) o;

		if(this.getId() == e.getId()) {
			return 0;
		}
		
		float diffPoints = this.getPoints() - e.getPoints();
		if(diffPoints != 0) {
			if (diffPoints < 0) {
				return -1;
			} else {
				return 1;
			}
		}
		
		float diffAge = this.getAgeMoyen() - e.getAgeMoyen();
		if(diffAge != 0) {
			if (diffAge < 0) {
				return -1;
			} else {
				return 1;
			}
		}
		
		return this.getNom().compareTo(e.getNom());
	}

	private float getAgeMoyen() {
		return BDSelect.getAgeMoyenEquipe(this.getId());
	}

	public static Equipe getEquipeFromNom(String nom) {
		return new Equipe(BDSelect.getIdEquipeFromNom(nom));
	}

	public static void inserer(String nom, int idJeu, int idEcurie) {
		BDInsert.insererEquipe(nom, idJeu, idEcurie);
	}
}
