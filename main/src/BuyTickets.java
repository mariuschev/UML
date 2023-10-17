import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuyTickets extends JPanel {
    private JFrame frame;

    public BuyTickets(JFrame frame) {
        this.frame = frame;
        setLayout(new BorderLayout());

        JButton previousPageButton = new JButton("Page précédente");
        previousPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.add(new Page1(frame)); // Naviguer vers Page1
                frame.revalidate();
                frame.repaint();
            }
        });

        add(new JLabel("Page 2", SwingConstants.CENTER), BorderLayout.CENTER);
        add(previousPageButton, BorderLayout.SOUTH);
    }
}
