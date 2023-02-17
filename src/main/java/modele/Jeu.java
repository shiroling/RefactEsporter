package modele;

import java.util.List;

public class Jeu extends BDEntity {
	private String nom;
	private String pathLogo;

	public Jeu(int id) {
		super(id);
	}
	
	public void init() {
		BDinit.init(this);
	}


	public int getId() {
		return super.getId();
	}

	public String getNom() {
		if (this.nom == null) {
			this.init();
		}
		return nom;
	}
	
	public String getPathLogo() {
		return this.pathLogo;
	}

	protected void setNom(String nom) {
		this.nom = nom;
	}

	protected void setPathLogo(String pathLogo) {
		this.pathLogo = pathLogo;
	}

	public static String[] toStrings(List<Jeu> jeux) {
		String[] nomJeux = new String[jeux.size()];
		for(int i = 0; i < jeux.size() ; i++) {
			nomJeux[i] = jeux.get(i).toString();
		}
		return nomJeux;
	}
	
	public static String[] toStrings() {
		List<Jeu> jeux = BDSelect.getListeJeux();
		String[] nomJeux = new String[jeux.size()];
		for(int i = 0; i < jeux.size() ; i++) {
			nomJeux[i] = jeux.get(i).toString();
		}
		return nomJeux;
	}

	@Override
	public String toString() {
		return this.getNom();
	}
	
	public static Jeu getJeuFromName(String name) {
		return new Jeu(BDSelect.getIdJeu(name));
	}

}
