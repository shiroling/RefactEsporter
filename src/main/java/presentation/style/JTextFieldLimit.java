package presentation.style;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * TextField pour limiter le nombre de charactere dans lui meme
 * Utiliser le format **textField.setDocument(new JTextFieldLimit(10));**
 *
 */
public class JTextFieldLimit extends PlainDocument {
    private int limit;

    public JTextFieldLimit(int limit) {
        super();
        this.limit = limit;
    }

    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null)
            return;

        if ((getLength() + str.length()) <= limit) {
            super.insertString(offset, str, attr);
        }
    }
}