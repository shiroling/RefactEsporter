package presentation.accueil.panelFonctionnalite.panelMenu.panelSelection;

public enum Selection {
    TOURNOI("Tournois"), RENCONTRE("Matchs"), JEU("Jeux"), EQUIPE("Equipes"), ECURIE("Ecuries");

    private final String label;

    Selection(String lbl) {
        this.label = lbl;
    }

    public String getLabel() {
        return this.label;
    }
}