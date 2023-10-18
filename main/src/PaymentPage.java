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

        JLabel detailsLabel = new JLabel("Selected Zone : " + selectedZone, SwingConstants.CENTER);
        detailsLabel.setFont(new Font("Arial", Font.PLAIN, 75));
        detailsLabel.setPreferredSize(new Dimension(900, 400));
        add(detailsLabel, BorderLayout.NORTH);

        JPanel paymentButtonsPanel = new JPanel();
        paymentButtonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        paymentButtonsPanel.setPreferredSize(new Dimension(600, 400));

        JButton carteButton = new JButton("Pay by card");
        carteButton.setPreferredSize(new Dimension(400, 150));
        carteButton.setFont(new Font("Arial", Font.PLAIN, 45));
        JButton monnaieButton = new JButton("Pay by cash");
        monnaieButton.setPreferredSize(new Dimension(400, 150));
        monnaieButton.setFont(new Font("Arial", Font.PLAIN, 45));

        carteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPaymentReceiptPage();
            }
        });

        monnaieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPaymentReceiptPage();
            }
        });

        paymentButtonsPanel.add(carteButton);
        paymentButtonsPanel.add(monnaieButton);
        add(paymentButtonsPanel, BorderLayout.CENTER);

        JButton previousPageButton = new JButton("Previous page");
        previousPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.add(new BuyTickets(frame));
                frame.revalidate();
                frame.repaint();
            }
        });

        previousPageButton.setPreferredSize(new Dimension(100, 75));
        add(previousPageButton, BorderLayout.SOUTH);
    }

    private void showPaymentReceiptPage() {
        frame.getContentPane().removeAll();
        frame.add(new PaymentReceiptPage(frame));
        frame.revalidate();
        frame.repaint();
    }
}
