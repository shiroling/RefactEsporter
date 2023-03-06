package presentation.accueil.panelCartes.vuesCartes;

import nouveauModele.dataRepresentation.Ecurie;
import presentation.style.ElementCommun;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class CarteEcurie extends Carte {

    private JLabel lblNomEcurie;
    private JLabel lblPoint;
    private int point;
    public CarteEcurie() {
        super();
        setLayout(new GridLayout(2, 1, 0, 0));
        JPanel panelNom = new JPanel();
        add(panelNom);

        lblNomEcurie = new JLabel("NomEcurie()");
        lblNomEcurie.setFont(ElementCommun.getFontPrincipal());
        add(lblNomEcurie);


        super.addHoverPannels(this);
        this.setName("CarteEcurie");
        this.setBorder(new LineBorder(new Color(0, 0, 0)));

        JPanel panelPoint = new JPanel();
        add(panelPoint);

        lblPoint = new JLabel("Nombre de points ");
        lblPoint.setFont(ElementCommun.getFontPrincipal());
        panelPoint.add(lblPoint);
        panelPoint.setBackground(new Color(0,0,0,0));
        panelNom.setBackground(new Color(0,0,0,0));

    }
    public void setNomEcurie(String nom){
        lblNomEcurie.setText(nom);
    }

    public void setPoint(int i){
        lblPoint.setText("Nombre de points: "+i);
    }


    @Override
    public Carte clone() {
        return null;
    }

}