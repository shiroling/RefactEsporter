package Presentation.FenMessage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FenMessage extends JDialog {
    private final JPanel contentPanel = new JPanel();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            FenMessage dialog = new FenMessage("Ceci est un message de test... coucou blablabalablablabla");
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public FenMessage(String message) {
        setBounds(100, 100, 350, 150);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 30));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        getContentPane().add(contentPanel, BorderLayout.CENTER);
        JTextArea areaMessage = new JTextArea(message);
        areaMessage.setBackground(contentPanel.getBackground());
        contentPanel.add(areaMessage);

        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("OK");
                okButton.setActionCommand("OK");
                okButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                    }
                });
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
        }
    }
}
