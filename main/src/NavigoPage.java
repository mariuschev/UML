import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NavigoPage extends JPanel {
    private JFrame frame;
    private String selectedZone = "Zone 1-2";
    private double subscriptionPrice = 75.0;

    public NavigoPage(JFrame frame) {
        this.frame = frame;
        setLayout(new BorderLayout());

        JLabel messageLabel = new JLabel("Please place your Navigo card...", SwingConstants.CENTER);
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 40));
        add(messageLabel, BorderLayout.CENTER);

        // Créez un Timer pour afficher la page pendant 6 secondes
        Timer timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lorsque le timer expire, naviguez vers la page EtatNavigo
                navigateToEtatNavigo();
            }
        });
        timer.setRepeats(false); // Ne répétez pas le timer

        timer.start(); // Démarrez le timer

        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.PLAIN, 35));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigateToPage1();
            }
        });

        add(backButton, BorderLayout.SOUTH);
    }

    private void navigateToPage1() {
        frame.getContentPane().removeAll();
        frame.add(new Page1(frame));
        frame.revalidate();
        frame.repaint();
    }

    private void navigateToEtatNavigo() {
        frame.getContentPane().removeAll();
        frame.add(new EtatNavigo(frame,selectedZone,subscriptionPrice));
        frame.revalidate();
        frame.repaint();
    }
}
