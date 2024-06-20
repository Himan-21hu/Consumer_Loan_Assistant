import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleLoanAssistant extends JFrame implements ActionListener {
    // GUI components
    private JTextField tfBalance, tfInterest, tfPayments;
    private JButton btnCalculate;
    private JLabel lblResult;

    public SimpleLoanAssistant() {
        // Set up the frame
        setTitle("Simple Loan Assistant");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10)); // Use GridLayout for simplicity

        // Initialize components
        tfBalance = new JTextField();
        tfInterest = new JTextField();
        tfPayments = new JTextField();
        btnCalculate = new JButton("Calculate");
        lblResult = new JLabel("Monthly Payment: ");

        // Add components to the frame
        add(new JLabel("Loan Balance:"));
        add(tfBalance);
        add(new JLabel("Interest Rate:"));
        add(tfInterest);
        add(new JLabel("Number of Payments:"));
        add(tfPayments);
        add(btnCalculate);
        add(lblResult);

        // Add action listener to the button
        btnCalculate.addActionListener(this);

        // Make the frame visible
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Perform the loan calculation
        try {
            double balance = Double.parseDouble(tfBalance.getText());
            double interest = Double.parseDouble(tfInterest.getText()) / 100 / 12;
            int payments = Integer.parseInt(tfPayments.getText());
            double monthlyPayment = (balance * interest) / (1 - Math.pow(1 + interest, -payments));

            // Display the result
            lblResult.setText(String.format("Monthly Payment: %.2f", monthlyPayment));
        } catch (NumberFormatException ex) {
            lblResult.setText("Please enter valid numbers.");
        }
    }

    public static void main(String[] args) {
        new SimpleLoanAssistant();
    }
}
