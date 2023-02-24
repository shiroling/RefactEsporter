package presentation.accueil.panelFonctionnalite.panelMenu.panelSelection;
import application.donneesPersistantes.Selection;

import java.awt.*;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class PanelSelection extends JPanel {

    private JPanel panelLigneHover;
    private ContoleurPanelSelection hover;


    public void setPannelLineON() {
        this.getPanelLigneHover().setPreferredSize(new Dimension(10, 0));
        this.getPanelLigneHover().repaint();
        this.revalidate();
    }

    public void setPannelLineOFF() {
        this.getPanelLigneHover().setPreferredSize(new Dimension(10, 0));
        this.getPanelLigneHover().repaint();
        this.revalidate();
    }
    public PanelSelection(Selection selection) {
        ContoleurPanelSelection hover = new ContoleurPanelSelection(this, selection);

        setLayout(new BorderLayout(0, 0));
        addMouseListener(hover);
        setPreferredSize(new Dimension(0, 50));
        setBackground(Color.WHITE);
        setBorder(new LineBorder(Color.GRAY));

        panelLigneHover = new JPanel();
        panelLigneHover.setBackground(new Color(0, 153, 255));
        panelLigneHover.setPreferredSize(new Dimension(10, 0));
        add(panelLigneHover, BorderLayout.EAST);

        JPanel panelLbl = new JPanel();
        panelLbl.setBackground(new Color(0,0,0,0));
        FlowLayout flowLayout = (FlowLayout) panelLbl.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        flowLayout.setHgap(10);
        flowLayout.setVgap(getHeight()/2 + 15);
        add(panelLbl, BorderLayout.CENTER);
        JLabel lblSelection = new JLabel(selection.getLabel());
        lblSelection.setHorizontalAlignment(SwingConstants.LEFT);
        panelLbl.add(lblSelection);

    }
    public JPanel getPanelLigneHover() {
        return this.panelLigneHover;
    }
    public ContoleurPanelSelection getHover() {
        return hover;
    }

}
