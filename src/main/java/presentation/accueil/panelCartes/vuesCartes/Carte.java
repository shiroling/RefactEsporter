package presentation.accueil.panelCartes.vuesCartes;

import presentation.accueil.panelCartes.controleursCarte.HoverCarte;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public abstract class Carte extends JPanel implements Cloneable  {
    private int id;

    @Override
    public Carte clone() {
        Carte cloned = null;
        try {
            cloned = (Carte) super.clone();
        } catch (CloneNotSupportedException e) {
            // Ne devrait jamais arriver car Carte implémente l'interface Cloneable
            throw new AssertionError();
        }
        cloned.setId(this.getId());
        return cloned;
    }



    public Carte() {
        setBackground(Color.WHITE);
        setBorder(new EmptyBorder(0,0,0,0));
        setLayout(new GridLayout(0, 1, 0, 0));
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 55));
        setBackground(new Color(255,255,255));
    }
    public void addHoverPannels(JPanel panelAHover) {
        HoverCarte hoverCarte = new HoverCarte(this, panelAHover);
        addMouseListener(hoverCarte);
    }
    public void setId(int id){
        this.id=id;
    }

    public int getId(){
        return id;
    }
}

