import javax.swing.*;
import java.awt.*;

public class DamageCalculator extends JFrame {

    // Declare input fields, checkboxes, and button
    public final JTextField playerLevelField;
    public final JTextField strengthField;
    public final JTextField rankLevelField;
    public final JTextField weaponBonusField;
    public final JTextField hitCountField;
    public final JTextField boostBonusField;
    public final JCheckBox checkbox1;

    public DamageCalculator() {
        // Set the title and layout of the frame
        setTitle("eDom Damage Calculator");
        setLayout(new FlowLayout());

        // To get player level
        playerLevelField = new JTextField("Player level ", 10);
        add(playerLevelField);

        // To get strength
        strengthField = new JTextField("Strength", 10);
        add(strengthField);

        // To get rank level
        rankLevelField = new JTextField("Rank level", 10);
        add(rankLevelField);

        // To get weapon bonus
        weaponBonusField = new JTextField("Weapon bonus", 10);
        add(weaponBonusField);

        // To get boost bonus
        boostBonusField = new JTextField("Boost bonus", 10);
        add(boostBonusField);

        // To get hit count
        hitCountField = new JTextField("Hit count", 10);
        add(hitCountField);

        // Create the checkboxes and add them to the frame
        checkbox1 = new JCheckBox("NE Bonus");
        add(checkbox1);


        // Create the button and add an action listener to it
        JButton button = new JButton("Calculate my damage");
        button.addActionListener(e -> {
            int playerLevel = Integer.parseInt(playerLevelField.getText());
            int strength = Integer.parseInt(strengthField.getText());
            int rankLevel = Integer.parseInt(rankLevelField.getText());
            int weaponBonus = Integer.parseInt(weaponBonusField.getText());
            int hitCount = Integer.parseInt(hitCountField.getText());

            double naturalEnemyBonus = 1.0;
            double boostBonus = 1.0;

            if (checkbox1.isSelected()) {
                naturalEnemyBonus = 1.1;
            }

            double damage = (((playerLevel * 5) + strength) * (1 + (rankLevel * 0.05)) * weaponBonus * naturalEnemyBonus * hitCount * boostBonus);

            // Show the sum in a message dialog
            JOptionPane.showMessageDialog(null, "The damage is: " + damage);
        });
        add(button);

        // Set the frame size and make it visible
        setSize(240, 180);
        setVisible(true);
    }

    public static void main(String[] args) {
        new DamageCalculator();
    }
}