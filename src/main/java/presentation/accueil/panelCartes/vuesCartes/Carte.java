package presentation.accueil.panelCartes.vuesCartes;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public abstract class Carte extends JPanel {
    private final int id;

    public Carte(int id) {
        this.id= id;
        setBackground(Color.WHITE);
        setBorder(new EmptyBorder(0,0,0,0));
        setLayout(new GridLayout(0, 1, 0, 0));
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 55));
        setBackground(new Color(255,255,255));
    }

    public int getId(){
        return id;
    }
}

