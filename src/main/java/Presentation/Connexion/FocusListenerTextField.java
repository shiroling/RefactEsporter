package Presentation.Connexion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class FocusListenerTextField implements FocusListener {
    private JTextField textField;
    private String texteParDefault;

    public FocusListenerTextField(JTextField textField, String texteParDefault) {
        super();
        this.textField = textField;
        this.texteParDefault = texteParDefault;
    }

    @Override
    public void focusGained(FocusEvent e) {
        // Lorsque le JTextField gagne le focus, vérifiez si le contenu est égal au texte par défaut.
        // Si c'est le cas, effacez le contenu.
        if (textField.getText().equals(this.texteParDefault)) {
            textField.setText("");
            textField.setForeground(Color.BLACK);
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        // Lorsque le JTextField perd le focus, vérifiez si le contenu est vide.
        // Si c'est le cas, remettez le texte par défaut.
        if (textField.getText().isEmpty()) {
            textField.setText(this.texteParDefault);
            textField.setForeground(Color.GRAY);
        }
    }
}
