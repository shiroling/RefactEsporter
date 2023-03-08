package presentation.accueil.panelCartes.vuesCartes;

import nouveauModele.dataRepresentation.Ecurie;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class CarteEcurie extends Carte {

    private Ecurie ecurie;

    public CarteEcurie(Ecurie ecurie) {
        super();
        this.ecurie = ecurie;

        JLabel lblNomEcurie = new JLabel(ecurie.getNomEcurie());
        lblNomEcurie.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
        add(lblNomEcurie);

        JPanel listPanelAHover = new JPanel();
        listPanelAHover.add(this);
        super.addHoverPannels(listPanelAHover);
        this.setName("CarteEcurie");
        this.setBorder(new LineBorder(new Color(0, 0, 0)));

    }

    public Ecurie getEcurie() {
        return ecurie;
    }

    @Override
    public Carte clone() {
        return null;
    }

}