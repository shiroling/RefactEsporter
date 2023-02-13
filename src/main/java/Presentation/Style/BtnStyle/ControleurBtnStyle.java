package Presentation.Style.BtnStyle;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControleurBtnStyle implements MouseListener {

    private BtnStyle btn;

    public ControleurBtnStyle(BtnStyle btnStyle) {
        super();
        this.btn = btnStyle;
    }

    public void mouseClicked(MouseEvent e) {}

    public void mousePressed(MouseEvent e) {
        this.btn.setBackground(this.btn.getCouleurClick());
    }

    public void mouseReleased(MouseEvent e) {
        this.btn.setBackground(this.btn.getCouleurOver());
    }

    public void mouseEntered(MouseEvent e) {
        this.btn.setBackground(this.btn.getCouleurOver());
    }

    public void mouseExited(MouseEvent e) {
        this.btn.setBackground(this.btn.getCouleurDeBase());
    }
}
