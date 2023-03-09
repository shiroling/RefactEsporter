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
        FlowLayout flowLayout = (FlowLayout) panelNom.getLayout();
        flowLayout.setVgap(40);

        lblNomEcurie = new JLabel("NomEcurie");
        panelNom.add(lblNomEcurie);
        this.setName("CarteEcurie");
        this.setBorder(new LineBorder(new Color(0, 0, 0)));

        JPanel panelPoint = new JPanel();
        add(panelPoint);

        lblPoint = new JLabel("Nombre de points ");
        panelPoint.add(lblPoint);
        panelPoint.setBackground(new Color(0,0,0,0));
        panelNom.setBackground(new Color(0,0,0,0));
        lblPoint.setFont(ElementCommun.getFontPrincipal());
        lblNomEcurie.setFont(ElementCommun.getFontPrincipal());
        add(panelNom);
        add(panelPoint);

    }
    public void setNomEcurie(String nom){
        lblNomEcurie.setText(nom);
    }

    public void setPoint(int i){
        lblPoint.setText("Nombre de points: "+i);
    }


    @Override
    public Carte clone() {
        return (CarteEcurie) super.clone();
    }

}