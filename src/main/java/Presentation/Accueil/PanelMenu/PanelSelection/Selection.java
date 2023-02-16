package Presentation.Accueil.PanelMenu.PanelSelection;

public enum Selection {
    TOURNOI("Tournois"), RENCONTRE("Matchs"), JEU("Jeux"), EQUIPE("Equipes"), ECURIE("Ecuries");

    private String label;

    private Selection(String lbl) {
        this.label = lbl;
    }

    public String getLabel() {
        return this.label;
    }
}