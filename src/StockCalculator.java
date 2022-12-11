import javax.swing.*;
import java.awt.*;

public class StockCalculator extends JFrame {

    public final JTextField q1AdrenalineDoseField;
    public final JTextField q2AdrenalineDoseField;
    public final JTextField q3AdrenalineDoseField;
    public final JTextField q4AdrenalineDoseField;
    public final JTextField q5AdrenalineDoseField;
    public final JTextField energyBarField;

    public StockCalculator() {
        // Set the title and layout of the frame
        setTitle("eDom Damage Calculator");
        setLayout(new FlowLayout());

        // To get player level
        q1AdrenalineDoseField = new JTextField("Q1AD", 10);
        add(q1AdrenalineDoseField);

        // To get player level
        q2AdrenalineDoseField = new JTextField("Q2AD", 10);
        add(q2AdrenalineDoseField);

        // To get player level
        q3AdrenalineDoseField = new JTextField("Q3AD", 10);
        add(q3AdrenalineDoseField);

        // To get player level
        q4AdrenalineDoseField = new JTextField("Q4AD", 10);
        add(q4AdrenalineDoseField);

        // To get player level
        q5AdrenalineDoseField = new JTextField("Q5AD", 10);
        add(q5AdrenalineDoseField);

        // To get player level
        energyBarField = new JTextField("EB", 10);
        add(energyBarField);

        // Create the button and add an action listener to it
        JButton button = new JButton("Calculate my stock");
        button.addActionListener(e -> {
            int q1AdrenalineDose = Integer.parseInt(q1AdrenalineDoseField.getText());
            int q2AdrenalineDose = Integer.parseInt(q2AdrenalineDoseField.getText());
            int q3AdrenalineDose = Integer.parseInt(q3AdrenalineDoseField.getText());
            int q4AdrenalineDose = Integer.parseInt(q4AdrenalineDoseField.getText());
            int q5AdrenalineDose = Integer.parseInt(q5AdrenalineDoseField.getText());
            int energyBar = Integer.parseInt(energyBarField.getText());

            double total = (double) (q1AdrenalineDose * 400 + q2AdrenalineDose * 800 + q3AdrenalineDose * 1200 +
                    q4AdrenalineDose * 1600 + q5AdrenalineDose * 2000 + energyBar * 100) / 10000;

            // Show the sum in a message dialog
            JOptionPane.showMessageDialog(null, "The stock is: " + total + " k");
        });
        add(button);

        // Set the frame size and make it visible
        setSize(240, 150);
        setVisible(true);
    }

    public static void main(String[] args) {
        new StockCalculator();
    }
}
