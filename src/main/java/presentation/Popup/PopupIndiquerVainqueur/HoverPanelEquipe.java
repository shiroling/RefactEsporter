package presentation.Popup.PopupIndiquerVainqueur;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;


public class HoverPanelEquipe implements MouseListener{

    private PopupIndiquerVainqueur vue;

    public static final Color COULEUR_BASE = new Color(238,238,238);
    public static final Color COULEUR_HOVER_SANS_SELECTION = new Color(220,220,220);
    public static final Color COULEUR_VAINQUEUR = new Color(111, 247, 148);
    public static final Color COULEUR_VAINQUEUR_HOVER = new Color(66, 252, 116);
    public static final Color COULEUR_PERDANT = new Color(252, 98, 106);
    public static final Color COULEUR_PERDANT_HOVER = new Color(252, 66, 75);

    public HoverPanelEquipe(PopupIndiquerVainqueur vue) {
        super();
        this.vue = vue;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JPanel panelClic = (JPanel) e.getSource();

        switch (panelClic.getName()) {
            case "panelEquipe1" :
                this.vue.setVainqueur(this.vue.getEquipe1());
                this.vue.getPanelEquipe1().setBackground(HoverPanelEquipe.COULEUR_VAINQUEUR_HOVER);
                this.vue.getPanelEquipe2().setBackground(HoverPanelEquipe.COULEUR_PERDANT);
                this.vue.getPanelEquipe1().updateUI();
                this.vue.getPanelEquipe2().updateUI();
                this.vue.getPanelEquipe1().revalidate();
                this.vue.getPanelEquipe1().repaint();
                this.vue.getPanelEquipe2().revalidate();
                this.vue.getPanelEquipe2().repaint();
                break;
            case "panelEquipe2" :
                this.vue.setVainqueur(this.vue.getEquipe2());
                this.vue.getPanelEquipe2().setBackground(HoverPanelEquipe.COULEUR_VAINQUEUR_HOVER);
                this.vue.getPanelEquipe1().setBackground(HoverPanelEquipe.COULEUR_PERDANT);
                this.vue.getPanelEquipe1().updateUI();
                this.vue.getPanelEquipe2().updateUI();
                this.vue.getPanelEquipe1().revalidate();
                this.vue.getPanelEquipe1().repaint();
                this.vue.getPanelEquipe2().revalidate();
                this.vue.getPanelEquipe2().repaint();
                break;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JPanel panel = (JPanel) e.getSource();
        if(panel.getBackground().equals(COULEUR_BASE)) {
            panel.setBackground(COULEUR_HOVER_SANS_SELECTION);
        } else if(panel.getBackground().equals(COULEUR_VAINQUEUR)) {
            panel.setBackground(COULEUR_VAINQUEUR_HOVER);
        } else if(panel.getBackground().equals(COULEUR_PERDANT)) {
            panel.setBackground(COULEUR_PERDANT_HOVER);;
        }
        this.vue.getPanelEquipe1().revalidate();
        this.vue.getPanelEquipe1().repaint();
        this.vue.getPanelEquipe2().revalidate();
        this.vue.getPanelEquipe2().repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JPanel panel = (JPanel) e.getSource();
        if(panel.getBackground().equals(COULEUR_HOVER_SANS_SELECTION)) {
            panel.setBackground(COULEUR_BASE);
        } else if(panel.getBackground().equals(COULEUR_VAINQUEUR_HOVER)) {
            panel.setBackground(COULEUR_VAINQUEUR);
        } else if(panel.getBackground().equals(COULEUR_PERDANT_HOVER)) {
            panel.setBackground(COULEUR_PERDANT);;
        }
        this.vue.getPanelEquipe1().revalidate();
        this.vue.getPanelEquipe1().repaint();
        this.vue.getPanelEquipe2().revalidate();
        this.vue.getPanelEquipe2().repaint();
    }

}