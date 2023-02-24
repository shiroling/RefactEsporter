package application;

import application.donneesPersistantes.ModeleGlobal;
import application.donneesPersistantes.Selection;
import presentation.accueil.VueAccueil;

public class Application {
    private static Application instance;
    private VueAccueil vueAccueil;
    public static void main(String[] args) {
        (new  Application()).runApp();
    }

    public static Application getinstance() {
        if(instance == null) {
            instance = new Application();
        }
        return instance;
    }

    public void runApp() {
        vueAccueil =  new VueAccueil();
        vueAccueil.setVisible(true);
    }

    public void changerEtatAffichage(Selection select) {
        ModeleGlobal.getInstance().updateListeCourante(select);
        this.vueAccueil.updateToState(select);
    }


    // Regarder si votre truc a mettre ici ne convient pas déjà à FonctionUtilisateurs
    // si il sagit d'un validateur (priére de le mettre dans le paquer du méme nom)
    // si il sagit d'un Filtre (priére de le mettre dans le paquer du méme nom)
    // si il sagit d'un truc en rapport avec la connexion checkez dans donneesPersistantes


    // sinon
    // fourrez tout ici, je ferais le tri

}
