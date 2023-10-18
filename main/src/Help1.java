import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Help1 extends JPanel {
    private JFrame frame;

    public Help1(JFrame frame) {
        this.frame = frame;
        setLayout(new BorderLayout());

        JLabel messageLabel = new JLabel("You will be contacted by customer service", SwingConstants.CENTER);
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 40));
        add(messageLabel, BorderLayout.NORTH);

        // Animation de la barre de chargement (trois petits points)
        JLabel loadingLabel = new JLabel("Loading", SwingConstants.CENTER);
        loadingLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        add(loadingLabel, BorderLayout.CENTER);

        Timer timer = new Timer(1000, new ActionListener() {
            int dotsCount = 1;

            @Override
            public void actionPerformed(ActionEvent e) {
                // Mettez à jour les points de chargement
                dotsCount = (dotsCount % 4) + 1;
                StringBuilder loadingText = new StringBuilder("Loading");
                for (int i = 0; i < dotsCount; i++) {
                    loadingText.append(".");
                }
                loadingLabel.setText(loadingText.toString());
            }
        });
        timer.start();

        // Redirigez vers Help2 après 3 secondes
        Timer redirectionTimer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigateToHelp2();
            }
        });
        redirectionTimer.setRepeats(false); // Ne répétez pas le timer
        redirectionTimer.start();
    }

    private void navigateToHelp2() {
        frame.getContentPane().removeAll();
        frame.add(new Help2(frame));
        frame.revalidate();
        frame.repaint();
    }
}
