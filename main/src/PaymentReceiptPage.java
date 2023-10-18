import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentReceiptPage extends JPanel {
    private JFrame frame;

    public PaymentReceiptPage(JFrame frame) {
        this.frame = frame;
        setLayout(new BorderLayout());

        JLabel confirmationLabel = new JLabel("Payment made! Do you want a receipt?", SwingConstants.CENTER);
        confirmationLabel.setPreferredSize(new Dimension(600, 400));
        confirmationLabel.setFont(new Font("Arial", Font.PLAIN, 45));

        JButton yesButton = new JButton("Yes");
        yesButton.setFont(new Font("Arial", Font.PLAIN, 45));
        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Afficher un message "Merci pour votre achat !" si "Oui" est cliqué
                JOptionPane.showMessageDialog(frame, "Thank you for your purchase!");
                // Naviguer vers la Page1
                navigateToPage1();
            }
        });

        JButton noButton = new JButton("No");
        noButton.setFont(new Font("Arial", Font.PLAIN, 45));
        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Afficher un message "Merci pour votre achat !" si "Non" est cliqué
                JOptionPane.showMessageDialog(frame, "Thank you for your purchase!");
                // Naviguer vers la Page1
                navigateToPage1();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(yesButton);
        buttonPanel.add(noButton);

        add(confirmationLabel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }

    private void navigateToPage1() {
        frame.getContentPane().removeAll();
        frame.add(new Page1(frame)); // Naviguer vers Page1
        frame.revalidate();
        frame.repaint();
    }
}
