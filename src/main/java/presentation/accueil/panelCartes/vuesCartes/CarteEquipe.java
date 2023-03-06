package presentation.accueil.panelCartes.vuesCartes;

import nouveauModele.dataRepresentation.Ecurie;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class CarteEquipe extends Carte{
    private Ecurie ecurie;

    public CarteEcurie() {
        super();

        JLabel lblNomEcurie = new JLabel(ecurie.getNomEcurie());
        lblNomEcurie.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
        add(lblNomEcurie);

        JPanel panelAHover = new JPanel();
        panelAHover.add(this);
        super.addHoverPannels(panelAHover);
        this.setName("CarteEcurie");
        this.setBorder(new LineBorder(new Color(0, 0, 0)));

    }

    public Ecurie getEcurie() {
        return ecurie;
    }
}
