import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentPage extends JPanel {
    private JFrame frame;
    private String selectedZone;

    public PaymentPage(JFrame frame, String selectedZone) {
        this.frame = frame;
        this.selectedZone = selectedZone;
        setLayout(new BorderLayout());

        // Affichez les détails de la zone et du prix sélectionnés
        JLabel detailsLabel = new JLabel("Zone sélectionnée : " + selectedZone, SwingConstants.CENTER);
        add(detailsLabel, BorderLayout.NORTH);
        detailsLabel.setFont(new Font("Arial", Font.PLAIN, 75));

        // Panel pour les boutons de paiement
        JPanel paymentButtonsPanel = new JPanel();
        paymentButtonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        paymentButtonsPanel.setFont(new Font("Arial", Font.PLAIN, 100));

        // Créez des boutons pour les options de paiement
        JButton carteButton = new JButton("Payer par Carte");
        carteButton.setPreferredSize(new Dimension(900, 400));
        carteButton.setFont(new Font("Arial", Font.PLAIN, 45));
        JButton monnaieButton = new JButton("Payer en Monnaie");
        monnaieButton.setFont(new Font("Arial", Font.PLAIN, 45));
        monnaieButton.setPreferredSize(new Dimension(900, 400));

        // Ajoutez des actions aux boutons
        carteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logique pour le paiement par carte
                // Ajoutez votre logique de paiement ici
                System.out.println("Paiement par carte effectué.");
            }
        });

        monnaieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logique pour le paiement en monnaie
                // Ajoutez votre logique de paiement ici
                System.out.println("Paiement en monnaie effectué.");
            }
        });

        paymentButtonsPanel.add(carteButton);
        paymentButtonsPanel.add(monnaieButton);
        add(paymentButtonsPanel, BorderLayout.CENTER);

        // Bouton de retour à la page précédente
        JButton previousPageButton = new JButton("Page précédente");
        previousPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.add(new BuyTickets(frame)); // Naviguer vers la page d'achat
                frame.revalidate();
                frame.repaint();
            }
        });
        paymentButtonsPanel.setPreferredSize(new Dimension(900, 400)); // Définir la taille personnalisée*
        detailsLabel.setPreferredSize(new Dimension(900, 400)); // Définir la taille personnalisée
        add(previousPageButton, BorderLayout.SOUTH);
    }
}
