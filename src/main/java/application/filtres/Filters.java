package application.filtres;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import application.modele.Portee;
import modele.*;
import static modele.BDPredicats.*;
import static modele.BDPredicats.estTournoiDePortee;
import static modele.BDPredicats.estTournoiSurJeu;


public class Filters {
	// Tournoi
	// Avancement
	public static Predicate<Tournoi> estTournoiEnCours = t -> estTournoiEnCours(t.getId());
	public static Predicate<Tournoi> estTournoiFini = t -> estTournoiFini(t.getId());
	public static Predicate<Tournoi> estTournoiAVenir = t -> estTournoiAVenir(t.getId());
	
	// Inscriptions
	public static Predicate<Tournoi> sontInscriptionsFinies = t -> sontInscriptionsFinies(t.getId());
	public static Predicate<Tournoi> sontInscriptionsEnCours = Filters.sontInscriptionsFinies.negate();
	
	// Multijoueurs
	public static Predicate<Tournoi> estTournoiMulti = BDPredicats::estTournoiMulti;
	public static Predicate<Tournoi> estTournoiJeuUnique = estTournoiMulti.negate();
	
	// Jeu
	public static BiPredicate<Tournoi, Integer> estTournoiSurJeu = (t, idJeu)  -> estTournoiSurJeu(t.getId(), idJeu);
	
	// Portée
	public static BiPredicate<Tournoi, Portee> estTournoiDePortee = (t, p) -> estTournoiDePortee(t.getId(), p);
	
	
	// Rencontre
	// Avancement
	public static Predicate<Rencontre> estRencontreFini = BDPredicats::estRencontreFinie;
	public static Predicate<Rencontre> estRencontreAVenir = estRencontreFini.negate();
	
	// Jeu / Jouée sur
	public static BiPredicate<Rencontre, Integer> estRencontreSurJeu = BDPredicats::estMatchSurJeu;
	
	// Tournoi
	public static BiPredicate<Rencontre, Integer> estRencontreDansTournoi = BDPredicats::estMatchTournoi;
	
	// Jouées par
	public static BiPredicate<Rencontre, Integer> estRencontreAvecEquipe = BDPredicats::estMatchAvecEquipe;

	// ne pas mettre dans l'IHM
	public static BiPredicate<Rencontre, Integer> estRencontreDansPoule = BDPredicats::estMatchPoule;
	
	
	// Equipe
	// Ecurie
	public static BiPredicate<Equipe, Integer> estEquipeFromEcurie = (equipe, idEcurie) -> equipe.getIdEcurie() == idEcurie;
	// Jeu
	public static BiPredicate<Equipe, Integer> estEquipeSurJeu = (equipe, idJeu) -> equipe.getIdJeu() == idJeu;

	
	public static List<BDEntity> filtrer(List<BDEntity> lt, List<Predicate<BDEntity>> lp) {
		for(Predicate<BDEntity> p : lp) {
			 lt = Filters.filtrer(lt, p);
		}
		return lt;
	}
	

	public static <T extends BDEntity, TypeSecondPart> List<T> filtrer(List<T> lt, List<BiPredicate<T, TypeSecondPart>> lp, TypeSecondPart secondPart) {
		for(BiPredicate<T, TypeSecondPart> p : lp) {
			 lt = Filters.filtrer(lt, p, secondPart);
		}
		return lt;
	}
	
	public static <T extends BDEntity> List<T> filtrer(List<T> tl, Predicate<T> p) {
		return tl.stream().filter(p).collect(Collectors.toList());
	}
	
	
	public static <T extends BDEntity, TypeSecondPart> List<T> filtrer(List<T> lt, BiPredicate<T, TypeSecondPart> p, TypeSecondPart secondPart) {
		return lt.stream().filter(x -> p.test(x, secondPart)).collect(Collectors.toList());
	}
}
