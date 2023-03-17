package presentation.accueil.panelCartes.vuesCartes;

import presentation.accueil.panelCartes.controleursCarte.ControleurCarteEcurie;
import presentation.accueil.panelCartes.controleursCarte.ControleurCarteEquipe;
import presentation.style.ElementCommun;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class CarteEcurie extends Carte {
    public static void main(String[] args) {
        CarteEcurie c1 = new CarteEcurie(1, "1", 1);
        System.out.println("c1 ; "+c1);
        CarteEcurie c2 = new CarteEcurie(2, "2", 2);
        System.out.println("c1 ; "+c1);
        System.out.println("c2 : " +c2);
    }

    private JLabel lblNomEcurie;
    private JLabel lblPoint;
    public CarteEcurie(int id, String nom, int nbPoints) {
        super(id);
        this.addMouseListener(new ControleurCarteEcurie(this));
        setLayout(new GridLayout(2, 1, 0, 0));
        JPanel panelNom = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panelNom.getLayout();
        flowLayout.setVgap(40);

        lblNomEcurie = new JLabel(nom);
        panelNom.add(lblNomEcurie);
        this.setName("CarteEcurie");
        this.setBorder(new LineBorder(new Color(0, 0, 0)));

        JPanel panelPoint = new JPanel();
        add(panelPoint);

        lblPoint = new JLabel("Nombre de points : " + nbPoints);
        panelPoint.add(lblPoint);
        panelPoint.setBackground(new Color(0, 0, 0, 0));
        panelNom.setBackground(new Color(0, 0, 0, 0));
        lblPoint.setFont(ElementCommun.getFontPrincipal());
        lblNomEcurie.setFont(ElementCommun.getFontPrincipal());
        add(panelNom);
        add(panelPoint);

    }

    @Override
    public String toString() {
        return "CarteEcurie{" +
                " id=" + super.getId()+
                " lblNomEcurie=" + lblNomEcurie +
                ", lblPoint=" + lblPoint +
                '}';
    }
}