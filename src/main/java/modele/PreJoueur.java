package modele;

import java.sql.Date;

public class PreJoueur {
	private String nom;
    private String prenom;
    private Date naissance;
    private String pseudo;
    private int idEquipe;
    
	public PreJoueur(String nom, String prenom, Date naissance, String pseudo) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.naissance = naissance;
		this.pseudo = pseudo;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public Date getNaissance() {
		return naissance;
	}

	public String getPseudo() {
		return pseudo;
	}

	public int getIdEquipe() {
		return idEquipe;
	}
	
	public void insert() {
		BDInsert.insererJoueur(this.getNom(), this.getPrenom(), this.getNaissance(), this.getPseudo(), this.getIdEquipe());
	}

}
