package modele;

import java.sql.Date;
import java.util.List;

public class Poule extends BDEntity {
    private Boolean isFinale;
    private int idTournoi;

    

    public Poule(int id) {
		super(id);
		this.isFinale = null;
		this.idTournoi = -1;
	}
    
    public void init() {
		BDinit.init(this);
	}

    public int getId() {
		return super.getId();
	}
	
	public Boolean isFinale() {
		if(this.isFinale == null) {
			this.init();
		}
		return isFinale;
	}

	public int getIdTournoi() {
		if(idTournoi == -1) {
			this.init();
		}
		return idTournoi;
	}
	
	public Tournoi getTournoi() {
		return new Tournoi(this.idTournoi);
	}

	protected void setIsFinale(Boolean isFinale) {
		this.isFinale = isFinale;
	}

	protected void setIdTournoi(int idTournoi) {
		this.idTournoi = idTournoi;
	}
	
	public List<Equipe> getEquipes() {
		return BDSelect.getListeEquipesFromPoule(this.getId());
	}

	@Override
	public String toString() {
		// TODO non Auto-generated method stub
		return this.getId() + "";
	}
	
	public static Date fixerDateRencontre(boolean isFinale, int idTournoi) {
		Tournoi t = new Tournoi(idTournoi);
		Date debut = t.getDateDebut();
		Date fin = t.getDateFin();
		
		int diff = (int) (debut.getTime() / 86400000 - fin.getTime() / 86400000);
		if(diff < 2) {
			return debut;
		}
		
		if(isFinale) {
			return fin;
		}
		return debut;
		}

	public void genererRencontres() {		
		BDInsert.genererRencontre(this.getId());
	}
	
	public List<Rencontre> getRencontres() {
		return BDSelect.getListeRencontreFromPoule(this.getId());
	}

	public boolean estFinie() {
		return BDPredicats.estPouleFinie(this.getId());
	}

	public void populateRencontres() {
		BDInsert.populateRencontres(this.getId());
		
	}

	public Equipe getPremier() {
		return BDSelect.getPremierPoule(this.getId());
	}

	public boolean isPleine() {
		return this.getEquipes().size() > 3;
	}
}
