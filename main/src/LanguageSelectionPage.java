import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LanguageSelectionPage extends JPanel {
    private JFrame frame;

    public LanguageSelectionPage(JFrame frame) {
        this.frame = frame;
        setLayout(new BorderLayout());

        // Titre de la page
        JLabel titleLabel = new JLabel("Sélection de la langue", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        // Créez un panneau pour les composants
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Ajoutez un espace vertical pour centrer la liste déroulante
        panel.add(Box.createVerticalGlue());

        // Liste déroulante pour la sélection de la langue
        String[] languages = {"Français", "English", "Español", "Deutsch", "Italiano"};
        JComboBox<String> languageComboBox = new JComboBox<>(languages);
        languageComboBox.setSelectedIndex(0);

        // Bouton "Continuer"
        JButton continueButton = new JButton("Continuer");
        continueButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Récupérez la langue sélectionnée
                String selectedLanguage = (String) languageComboBox.getSelectedItem();

                // Affichez un message de confirmation (à personnaliser)
                JOptionPane.showMessageDialog(frame, "Langue sélectionnée : " + selectedLanguage);

                // Ajoutez ici la logique pour passer à la page suivante
            }
        });

        // Ajoutez les composants au panneau
        panel.add(languageComboBox);
        panel.add(Box.createRigidArea(new Dimension(10, 10)));
        panel.add(continueButton);

        // Ajoutez le panneau au centre de la page
        add(panel, BorderLayout.CENTER);
        //Lorsque l'on clique sur le bouton "Continuer" on arrive sur la page Page1
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.add(new Page1(frame)); // Naviguer vers Page1
                frame.revalidate();
                frame.repaint();
            }
        });
    }
}
