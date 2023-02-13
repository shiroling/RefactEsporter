package Model;

import java.util.Date;
import java.util.List;

public class Joueur extends BDEntity {
    private String nom;
    private String prenom;
    private Date naissance;
    private String pseudo;
    private int idEquipe;
    
    public Joueur(int id) {
		super(id);
		this.idEquipe = -1;
	}

	public void init() {
		BDinit.init(this);
	}

    public int getId() {
		return super.getId();
	}
  
	public Date getNaissance() {
		if(this.naissance == null) {
			this.init();
		}
		return naissance;
	}
	
	public int getIdEquipe() {
		if(this.idEquipe == -1) {
			this.init();
		}
		return idEquipe;
	}
	
	public String getNom() {
		if(this.nom == null) {
			this.init();
		}
		return nom;
    }

    public String getPrenom() {
    	if(this.prenom == null) {
			this.init();
		}
		return prenom;
    }

    public Date getDateNaissance() {
    	if(this.naissance == null) {
			this.init();
		}
		return naissance;
    }
	
    public String getPseudo() {
    	if (this.pseudo == null) {
    		this.init();			
		}
    	return pseudo;
    }
    
	protected void setNaissance(Date naissance) {
		this.naissance = naissance;
	}
	
	protected void setIdEquipe(int idEquipe) {
		this.idEquipe = idEquipe;
	}

	protected void setNom(String nom) {
		this.nom = nom;
	}
	
	protected void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	protected void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	public Equipe getEquipe() {
		return new Equipe(this.getIdEquipe());
	}

	public static String[] toStrings(List<Joueur> l) {
		String[] result = new String[l.size()];
		for (int i = 0; i < l.size(); i++) {
			result[i] = l.get(i).toString();
		}
		return result;
	}
	
    @Override 
    public String toString() {
    	return "[" + this.getPseudo() +"] " + this.getNom() + " " + this.getPrenom() + " --- " + this.getDateNaissance().toString(); 
    }
    
	public static Joueur getJoueurFromPseudo(String pseudo) {
		return new Joueur(BDSelect.getIdJoueurFromPseudo(pseudo));
	}

}
