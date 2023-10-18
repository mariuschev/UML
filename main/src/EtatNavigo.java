import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EtatNavigo extends JPanel {
    private JFrame frame;
    private String selectedZone;
    private double subscriptionPrice;

    public EtatNavigo(JFrame frame, String selectedZone, double subscriptionPrice) {
        this.frame = frame;
        this.selectedZone = selectedZone;
        this.subscriptionPrice = subscriptionPrice;

        setLayout(new BorderLayout());

        JLabel detailsLabel = new JLabel("Zone selected: " + selectedZone + " | Subscription Price: " + subscriptionPrice + "€", SwingConstants.CENTER);
        detailsLabel.setFont(new Font("Arial", Font.PLAIN, 40));
        add(detailsLabel, BorderLayout.CENTER);

        JButton rechargeButton = new JButton("Recharge Navigo");
        rechargeButton.setFont(new Font("Arial", Font.PLAIN, 35));
        rechargeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigateToPaymentPage(); // Rediriger vers la page PaymentPage
            }
        });

        JButton noRechargeButton = new JButton("No Recharge");
        noRechargeButton.setFont(new Font("Arial", Font.PLAIN, 35));
        noRechargeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigateToPage1();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2, 10, 10));
        buttonPanel.add(rechargeButton);
        buttonPanel.add(noRechargeButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void navigateToPage1() {
        frame.getContentPane().removeAll();
        frame.add(new Page1(frame));
        frame.revalidate();
        frame.repaint();
    }

    private void navigateToPaymentPage() {
        frame.getContentPane().removeAll();
        frame.add(new BuySubscribe(frame));
        frame.revalidate();
        frame.repaint();
    }
}
