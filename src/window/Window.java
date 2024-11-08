package window;
import javax.swing.*;

public class Window {

    private int width, height;
    private JFrame mensaState; //Fenster
    private JTextArea menuDisplay;
    public JTextField linkField;

    public Window(int width, int height) {
        this.width = width;
        this.height = height;
        this.mensaState = new JFrame("MensaState"); //Fenster Titel
        this.mensaState.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mensaState.setSize(this.width, this.height); //Height & Width
        this.menuDisplay = new JTextArea();
        linkField = new JTextField(25); //Textfeld
        this.menuDisplay.setEditable(false); // Nur Lesemodus
        this.menuDisplay.setLineWrap(true); // automatischer Textumbruch
        this.menuDisplay.setWrapStyleWord(true); //Textumbruch auf Wörter achten!
        JScrollPane scrollPane = new JScrollPane(menuDisplay);

        this.mensaState.add(scrollPane);
        this.mensaState.setVisible(true); //Anzeigen
    }

    public void updateMenuDisplay(String menuText) {
        this.menuDisplay.setText(menuText);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String toString() {
        return "de.mensaState.window.Window [width=" + width + ", height=" + height + "]";
    }
}
