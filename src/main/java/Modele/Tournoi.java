package Modele;

import java.sql.Date;
import java.util.List;

import Application.Portee;

public class Tournoi extends BDEntity {
	private String nom;
	private Portee portee;
	private Date dateFinInscriptions;
	private Date dateDebut;
	private Date dateFin;
	private int idJeu;
	private int idGerant;
	
	public Tournoi(int id) {
		super(id);
		this.nom = null;
		this.portee = null;
		this.dateFinInscriptions = null;
		this.dateDebut = null;
		this.dateFin = null;
		this.idJeu = -1;
		this.idGerant = -1;
	}
	
	public void init() {
		BDinit.init(this);
	}
	
	@Override
	public int getId() {
		return super.getId();
	}
	
	public String getNom() {
		if(nom == null) {
			this.init();
		}
		return nom;
	}
	
	public Portee getPortee() {
		if(this.portee == null) {
			this.init();
		}
		return portee;
	}

	public Date getDateFinInscriptions() {
		if(this.dateFinInscriptions == null) {
			this.init();
		}
		return dateFinInscriptions;
	}

	public Date getDateDebut() {
		if(this.dateDebut == null) {
			this.init();
		}
		return dateDebut;
	}
	
	public Date getDateFin() {
		if(this.dateFin == null) {
			this.init();
		}
		return dateFin;
	}

	public int getIdJeu() {
		if(this.idJeu == -1) {
			this.init();
		}
		return idJeu;
	}

	public int getIdGerant() {
		if(this.idGerant == -1) {
			this.init();
		}
		return idGerant;
	}

	protected void setNom(String nom) {
		this.nom = nom;
	}

	protected void setPortee(Portee portee) {
		this.portee = portee;
	}

	protected void setDateFinInscriptions(Date dateFinInscriptions) {
		this.dateFinInscriptions = dateFinInscriptions;
	}

	protected void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	protected void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	protected void setIdJeu(int idJeu) {
		this.idJeu = idJeu;
	}

	protected void setIdGerant(int idGerant) {
		this.idGerant = idGerant;
	}
	
	public int getNombreInscrits() {
		return BDSelect.getNombreInscritTournois(this.getId());
	}
	
	public boolean isTournoiPlein() {
		return BDSelect.getNombreInscritTournois(this.getId()) >= 16;
	}
	

	public List<Equipe> getListEquipesParticipantes() {
		return BDSelect.getListeEquipesFromTournoi(this.getId());
	}

	public static String[] toStrings(List<Tournoi> l) {
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
		return this.getNom();
	}
	
	public Date getDateInscriptionEquipe(int idEquipe) {
		return BDSelect.getDateInscriptionEquipe(this.getId(), idEquipe);
	}
	
	public static List<Tournoi> getTournoisEnCours() {
		return BDSelect.getTournoisEnCours();
	}
	
	public static List<Tournoi> getTournoisFinis() {
		return BDSelect.getTournoisFinis();
	}
	
	public static List<Tournoi> getTournoisAVenir() {
		return BDSelect.getTournoisAVenir();
	}
	
	public static void insererTournoi(String nomTounoi, Portee porteeTournoi, Date dateFinInscription, Date dateDebutTournoi, Date dateFinTournoi, Jeu j, int idGerant) throws IllegalArgumentException {
		if(!isValidNom(nomTounoi)) {
			throw new IllegalArgumentException("Le nom donné au tournoi est déjà pris");
		}
		
		if(!isValidDates(dateFinInscription, dateDebutTournoi, dateFinTournoi)) {
			throw new IllegalArgumentException("Les dates données ne corélent pas");
		}	
		if(!isvalidGerant(idGerant)) {
			throw new IllegalArgumentException("Le gérant"+ idGerant +" n'existe pas");
		}
		
		BDInsert.insererTournoi(nomTounoi, porteeTournoi, dateFinInscription, dateDebutTournoi, dateFinTournoi, j.getId(), idGerant);
	}
	
	public static boolean isvalidGerant(int i ) {
		return BDPredicats.existeGerant(i);
	}
	
	public static void insererTournoisMultigaming(String nomTournoi, Portee porteeTournoi, Date dateFinInscription, Date dateDebutTournoi, Date dateFinTournoi, List<Jeu> jeux, int idGerant) {
		for (Jeu j :jeux) {
			insererTournoi(nomTournoi + " - " + j.getNom(), porteeTournoi, dateFinInscription, dateDebutTournoi, dateFinTournoi, j, idGerant);
		}
	}

	private static boolean isValidDates(Date dateFinInscription, Date dateDebutTournoi, Date dateFinTournoi) {
		return !dateFinInscription.after(dateDebutTournoi) && !dateDebutTournoi.after(dateFinTournoi);
	}

	private static boolean isValidNom(String nomTounoi) {
		return !BDPredicats.existeNomTournoi(nomTounoi);
	}
	
	public static Tournoi getTournoiFromNom(String nom) {
		return new Tournoi(BDSelect.getIdTournoiFromNom(nom));
	}
	
	public void genererPoules() {
		BDInsert.genererPoules(this.getId());
	}

	public Poule getPouleFinale() {
		return BDSelect.getFinaleFromTournoi(this.getId());
	}
	
	public List<Poule> getListePoules(){
		return BDSelect.getPoulesTournoi(getId());
	}
	
	public List<Poule> getListePoulesSimples(){
		List<Poule> l = BDSelect.getPoulesTournoi(getId());
		Poule pf = null;
		for (Poule poule : l) {
			if(poule.isFinale()) {
				pf = poule;
			}
		}
		l.remove(pf);
		return l;
	}

	public void procedureTournoiPlein() {
		this.genererPoules();
		this.peuplerPoules();
		
		List<Poule> l = this.getListePoulesSimples();
		
		for (Poule poule : l) {
			poule.genererRencontres();
			poule.populateRencontres();
		}
	}
	
	public void inscrireEquipe(Equipe e) {
		BDInsert.insererInscrit(e, this);
		if(this.isTournoiPlein()) {
			procedureTournoiPlein();
		}
	}
	
	private void peuplerPoules() {
		BDInsert.peuplerPoules(this.getId());
		}

	public boolean isInscrite(Equipe e) {
		return BDPredicats.isIscriteTournoi(e, this);
	}
	
	public boolean isFini() {
		return BDPredicats.estTournoiFini(this.getId());
	}
	
	public List<Equipe> getClassement() {
		return BDSelect.getClassementTournoi(this.getId());
	}
}
