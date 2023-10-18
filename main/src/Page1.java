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
        JButton buyTicketButton = new JButton("Buy a ticket");
        JButton viewScheduleButton = new JButton("Reload your card");
        JButton helpButton = new JButton("Help");

        buyTicketButton.setFont(new Font("Arial", Font.PLAIN, 35));
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
        viewScheduleButton.setFont(new Font("Arial", Font.PLAIN, 35));
        helpButton.setFont(new Font("Arial", Font.PLAIN, 35));


        viewScheduleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.add(new NavigoPage(frame)); // Naviguer vers la page de recharge
                frame.revalidate();
                frame.repaint();
            }
        });

        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.add(new Help1(frame)); // Naviguer vers Help1
                frame.revalidate();
                frame.repaint();
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
