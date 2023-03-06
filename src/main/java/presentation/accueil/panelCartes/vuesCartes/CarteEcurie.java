package presentation.accueil.panelCartes.vuesCartes;

import nouveauModele.dataRepresentation.Ecurie;
import presentation.style.ElementCommun;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class CarteEcurie extends Carte {

    private JLabel lblNomEcurie;
    public CarteEcurie() {
        super();

        lblNomEcurie = new JLabel("NomEcurie()");
        lblNomEcurie.setFont(ElementCommun.getFontPrincipal());
        add(lblNomEcurie);


        super.addHoverPannels(this);
        this.setName("CarteEcurie");
        this.setBorder(new LineBorder(new Color(0, 0, 0)));

    }
    public void setNomEcurie(String nom){
        lblNomEcurie.setText(nom);
    }


    @Override
    public Carte clone() {
        return null;
    }

}