package presentation.accueil.panelCartes.vuesCartes;

import presentation.accueil.panelCartes.controleursCarte.ControleurCarte;
import presentation.accueil.panelCartes.controleursCarte.ControleurCarteEquipe;
import presentation.style.ElementCommun;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class CarteEquipe extends Carte{

    private JLabel lblNomEquipe;
    private JLabel lblPoint;

    public CarteEquipe(int idEquipe,  int points, String nomEquipe) {
        super(idEquipe);
        this.addMouseListener(new ControleurCarteEquipe(this));
        setBackground(new Color(255,255,255));
        setLayout(new GridLayout(2, 1, 0, 0));

        JPanel panelNom = new JPanel();
        add(panelNom);
        lblNomEquipe = new JLabel("nomEquipe");
        lblNomEquipe.setFont(ElementCommun.getFontPrincipal());
        panelNom.add(lblNomEquipe);

        super.addHoverPannels(this);

        this.setName("CarteEquipe");
        this.setBorder(new LineBorder(new Color(0, 0, 0)));


        JPanel panelPoint = new JPanel();
        add(panelPoint);

        lblPoint = new JLabel("Nombre de points ");
        lblPoint.setFont(ElementCommun.getFontPrincipal());
        panelPoint.add(lblPoint);
        panelPoint.setBackground(new Color(0,0,0,0));
        panelNom.setBackground(new Color(0,0,0,0));

        setNombrePoint(points);
        setNomEquipe(nomEquipe);
    }

    public void setNomEquipe(String nom) {
        lblNomEquipe.setText(nom);
    }
    public void setNombrePoint(int i){
        lblPoint.setText("Nombre de points: "+i);
    }
}
