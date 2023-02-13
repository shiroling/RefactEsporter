package Presentation.Style.PanelArrondi;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

public class PanelArrondi extends JPanel {
    private int roundHautDroit;
    private int roundHautGauche;
    private int roundBasDroit;
    private int roundBasGauche;

    public PanelArrondi(int roundHautDroit, int roundHautGauche, int roundBasDroit, int roundBasGauche) {
        super();
        this.roundHautDroit = roundHautDroit;
        this.roundHautGauche = roundHautGauche;
        this.roundBasDroit = roundBasDroit;
        this.roundBasGauche = roundBasGauche;
        setOpaque(false);
    }

    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        Area area = new Area(createRoundHautGauche());
        if(roundHautDroit > 0) {
            area.intersect(new Area(createRoundHautDroit()));
        }
        if(roundBasGauche > 0) {
            area.intersect(new Area(createRoundBasGauche()));
        }
        if(roundBasDroit > 0) {
            area.intersect(new Area(createRoundBasDroit()));
        }
        g2.fill(area);
        g2.dispose();
        super.paintComponent(g);
    }

    private Shape createRoundHautGauche() {
        int roundX = Math.min(getWidth(), roundHautGauche);
        int roundY = Math.min(getHeight(), roundHautGauche);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(roundX / 2, 0, getWidth() - roundX / 2, getHeight())));
        area.add(new Area(new Rectangle2D.Double(0, roundY / 2, getWidth(), getHeight() - roundY / 2)));
        return area;
    }

    private Shape createRoundHautDroit() {
        int roundX = Math.min(getWidth(), roundHautDroit);
        int roundY = Math.min(getHeight(), roundHautDroit);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(0, 0, getWidth() - roundX / 2, getHeight())));
        area.add(new Area(new Rectangle2D.Double(0, roundY / 2, getWidth(), getHeight() - roundY / 2)));
        return area;
    }

    private Shape createRoundBasGauche() {
        int roundX = Math.min(getWidth(), roundBasGauche);
        int roundY = Math.min(getHeight(), roundBasGauche);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(roundX / 2, 0, getWidth() - roundX / 2, getHeight())));
        area.add(new Area(new Rectangle2D.Double(0, 0 , getWidth(), getHeight() - roundY / 2)));
        return area;
    }

    private Shape createRoundBasDroit() {
        int roundX = Math.min(getWidth(), roundBasDroit);
        int roundY = Math.min(getHeight(), roundBasDroit);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(0, 0, getWidth() - roundX / 2, getHeight())));
        area.add(new Area(new Rectangle2D.Double(0, 0, getWidth(), getHeight() - roundY / 2)));
        return area;
    }
}
