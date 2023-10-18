import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuySubscribe extends JPanel {
    private JFrame frame;

    public BuySubscribe(JFrame frame) {
        this.frame = frame;
        setLayout(new BorderLayout());

        JButton previousPageButton = new JButton("Previous page");
        previousPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.add(new Page1(frame)); // Naviguer vers Page1
                frame.revalidate();
                frame.repaint();
            }
        });

        // Création d'une grille de boutons pour les zones de métro et leurs prix
        JPanel metroGridPanel = new JPanel();
        metroGridPanel.setLayout(new GridLayout(1, 2)); // 4 lignes et 3 colonnes pour 12 zones possibles

        // Création des boutons pour les différentes zones de métro avec leurs prix
        String[] metroZones = { "Zone 1-3 - 85.00€/month",
                "Zone 4-6 - 100.00€/month"};
        Font buttonFont = new Font("Arial", Font.PLAIN, 35); // Créer une police avec taille 35

        for (String zone : metroZones) {
            JButton zoneButton = new JButton(zone);
            zoneButton.setFont(buttonFont);
            zoneButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Logique pour traiter la sélection de la zone de métro
                    // Vous pouvez ajouter votre logique ici
                    System.out.println("Zone sélectionnée : " + zone);


                    frame.getContentPane().removeAll();
                    frame.add(new PaymentPage(frame, zone)); // Naviguer vers la page de paiement
                    frame.revalidate();
                    frame.repaint();
                }
            });
            metroGridPanel.add(zoneButton);
        }

        // Ajouter la grille de boutons à la page
        add(metroGridPanel, BorderLayout.CENTER);
        add(previousPageButton, BorderLayout.SOUTH);
    }
}
