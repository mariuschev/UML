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

        // Panneau pour les composants
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Liste déroulante pour la sélection de la langue
        String[] languages = {"Français", "English", "Español", "Deutsch", "Italiano"};
        JComboBox<String> languageComboBox = new JComboBox<>(languages);
        languageComboBox.setSelectedIndex(0);
        languageComboBox.setAlignmentX(Component.CENTER_ALIGNMENT);

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

            }
        });

        add(panel, BorderLayout.CENTER);
        panel.add(languageComboBox);
        panel.add(continueButton);
    }
}
