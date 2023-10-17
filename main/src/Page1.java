import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Page1 extends JPanel {
    private JFrame frame;

    public Page1(JFrame frame) {
        this.frame = frame;
        setLayout(new BorderLayout());

        // Ajoutez un libellé pour le titre
        JLabel titleLabel = new JLabel("Ticket Vending Machine", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

        // Ajoutez des boutons pour les différentes options de vente de billets
        JButton buyTicketButton = new JButton("Acheter un ticket, coupons");
        JButton viewScheduleButton = new JButton("Recharger un pass Navigo");
        JButton helpButton = new JButton("Aide");

        buyTicketButton.setFont(new Font("Arial", Font.PLAIN, 18));
        //je veux que lorsque l'on clique sur le bouton "Acheter un ticket, coupons" on arrive sur la page BuyTickets
        buyTicketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.add(new BuyTickets(frame)); // Naviguer vers Page1
                frame.revalidate();
                frame.repaint();
            }
        });
        viewScheduleButton.setFont(new Font("Arial", Font.PLAIN, 18));
        helpButton.setFont(new Font("Arial", Font.PLAIN, 18));

        buyTicketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code pour gérer l'achat de billets
            }
        });

        viewScheduleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code pour afficher l'horaire
            }
        });

        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code pour afficher l'aide
            }
        });

        // Ajoutez les composants à la page
        add(titleLabel, BorderLayout.NORTH);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 10, 10));
        buttonPanel.add(buyTicketButton);
        buttonPanel.add(viewScheduleButton);
        buttonPanel.add(helpButton);
        add(buttonPanel, BorderLayout.CENTER);
    }
}
