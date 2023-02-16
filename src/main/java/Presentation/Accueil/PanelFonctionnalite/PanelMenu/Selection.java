<<<<<<<< HEAD:src/main/java/Presentation/Accueil/PanelFonctionnalite/PanelMenu/PanelSelection/Selection.java
package Presentation.Accueil.PanelMenu.PanelSelection;
========
package Presentation.Accueil.PanelFonctionnalite.PanelMenu;
>>>>>>>> e1f8e011ce374dc788656b6ccbbca8fda7745749:src/main/java/Presentation/Accueil/PanelFonctionnalite/PanelMenu/Selection.java

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