import javax.swing.*;
import java.awt.*;

public class Help2 extends JPanel {
    private JFrame frame;

    public Help2(JFrame frame) {
        this.frame = frame;
        setLayout(new BorderLayout());

        JLabel messageLabel = new JLabel("Calling Customer Service...", SwingConstants.CENTER);
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 40));
        add(messageLabel, BorderLayout.CENTER);

        // Image du téléphone (remplacez "path/vers/votre/image.png" par le chemin de votre image)
        ImageIcon phoneIcon = new ImageIcon("path/vers/votre/image.png");
        JLabel phoneLabel = new JLabel(phoneIcon);
        add(phoneLabel, BorderLayout.NORTH);

        // Redirigez vers une autre page (par exemple, Page1) après un certain délai
        Timer redirectionTimer = new Timer(5000, (e) -> {
            navigateToPage1();
        });
        redirectionTimer.setRepeats(false); // Ne répétez pas le timer
        redirectionTimer.start();
    }

    private void navigateToPage1() {
        frame.getContentPane().removeAll();
        frame.add(new Page1(frame)); // Redirigez vers Page1 (ou toute autre page de votre choix)
        frame.revalidate();
        frame.repaint();
    }
}
