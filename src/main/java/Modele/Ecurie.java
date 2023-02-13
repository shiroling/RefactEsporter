package Modele;

import java.util.List;

public class Ecurie extends BDEntity {
	private String nom;
	private String nomManager;

	public Ecurie(int id) {
		super(id);
	}
	
	public void init() {
		BDinit.init(this);
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

	public String getNomManager() {
		if(this.nomManager == null) {
			this.init();
		}
		return nomManager;
	}

	protected void setNom(String nom) {
		this.nom = nom;
	}

	protected void setMdpManager(String mdpManager) {
	}

	protected void setNomManager(String nomManager) {
		this.nomManager = nomManager;
	}

	public static String[] toStrings(List<Ecurie> l) {
		if(l.size() == 0) {
			return new String[] {"-- Aucun tournois dans la BD --"};
		}
		String[] result = new String[l.size()];
		for (int i = 0; i < l.size(); i++) {
			result[i] = l.get(i).toString();
		}
		return result;
	}
	
	public List<Equipe> getListeEquipe(){
		return BDSelect.getListeEquipesFromEcurie(getId());
	}

	@Override
	public String toString() {
		return ""+ this.getNom() +" ("+this.getNomManager()+ ")";
	}
	
	public static Ecurie getEcurieFromNom(String nomEcurie) {
		return new Ecurie(BDSelect.getIdEcurieFromNom(nomEcurie));
	}

}
