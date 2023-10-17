import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Application Multi-Page");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);
            frame.add(new Page1(frame)); // Commencez par afficher la Page1
            frame.setVisible(true);
        });
    }
}
