package Model;

import java.sql.Date;
import java.util.List;

public class Rencontre extends BDEntity {
	private int idArbitre;
	private int idPoule;
	private Date date;

	//add this bc it uses often and need lots of prosses
	private int idTournoi;
	
	public Rencontre(int id) {
		super(id);
		this.idArbitre = -1;
		this.idPoule = -1;
		this.idTournoi = -1;
	}
	
	public void init() {
		BDinit.init(this);
	}
	
	public Date getDate() {
		if(date == null) {
			this.init();
		}
		return date;
	}	

	protected void setDate(Date date) {
		this.date = date;
	}

	public int getId() {
		return super.getId();
	}

	public int getIdArbitre() {
		if(idArbitre == -1) {
			this.init();
		}
		return idArbitre;
	}

	public int getIdPoule() {
		if(idPoule == -1) {
			this.init();
		}
		return idPoule;
	}

	protected void setIdArbitre(int idArbitre) {
		this.idArbitre = idArbitre;
	}

	protected void setIdPoule(int idPoule) {
		this.idPoule = idPoule;
	}

	public List<Equipe> getEquipes() {
		return BDSelect.getEquipesFromRencontre(this.getId());
	}
	
	public boolean isFull() {
		return this.getEquipes().size() > 1; 
	}

	public Equipe getVainqueur() throws NullPointerException {
		if(!estResultatRenseigne()) {
			throw new NullPointerException("Le résultat de la rencontre n'as pas été renseigné");
		}
		return BDSelect.getVainqueurRencontre(getId());
	}

	public Equipe getPerdant() {
		if(estResultatRenseigne()) {
			throw new IllegalArgumentException("Le résultat de la rencontre n'as pas été renseigné");
		}
		return BDSelect.getPerdantRencontre(super.getId());
	}
	
	public boolean estResultatRenseigne() {
		return BDPredicats.estResultatRenseigne(getId());
	}
	
	public Poule getPoule() {
		return new Poule(this.getIdPoule());
	}
	
	public boolean isArbitre(int idArbitre) {
		return idArbitre == this.idArbitre;
	}

	public static String[] toStrings(List<Rencontre> l) {
		if(l.size() == 0) {
			return new String[] {"-- Aucun tournois dans la BD --"};
		}
		String[] result = new String[l.size()];
		for (int i = 0; i < l.size(); i++) {
			result[i] = l.get(i).toString();
		}
		return result;
	}

	@Override
	public String toString() {
		return this.getEquipes().get(0) + " vs " + this.getEquipes().get(1);
	}

	public int getIdTournoi() {
		if(this.idTournoi == -1) {
			this.setIdTournoi((new Poule(this.getIdPoule())).getIdTournoi());
		}
		return idTournoi;
	}

	public void setIdTournoi(int idTournoi) {
		this.idTournoi = idTournoi;
	}
	
	public Tournoi getTournoi() {
		return new Tournoi(this.getIdTournoi());
	}

	public void designerVainceur(int idEquipeVaincueur) {
		BDInsert.designerVainceurRencontre(this.getId(), idEquipeVaincueur);
		if(this.getPoule().estFinie()) {
			Equipe e = this.getPoule().getPremier();			
			BDInsert.insererComposer(e.getId(), this.getTournoi().getPouleFinale().getId());
		}
	}

}
