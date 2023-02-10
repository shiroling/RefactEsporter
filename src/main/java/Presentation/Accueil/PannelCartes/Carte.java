package Presentation.Accueil.PannelCartes;

public abstract class Carte implements Cloneable {

    @Override
    public Carte clone() {
        try {
            return (Carte) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
