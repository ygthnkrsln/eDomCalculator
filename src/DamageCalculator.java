import javax.swing.*;
import java.awt.*;

public class DamageCalculator extends JFrame {

    // Declare input fields, checkboxes, and button
    public final JTextField playerLevelField;
    public final JTextField strengthField;
    public final JTextField rankLevelField;
    public final JTextField hitCountField;
    public final JCheckBox checkbox1;
    public final JComboBox<String> combo1;
    public final JComboBox<String> combo2;

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

        // To get hit count
        hitCountField = new JTextField("Hit count", 10);
        add(hitCountField);

        // To check NE Bonus is available or not
        checkbox1 = new JCheckBox("NE Bonus");
        add(checkbox1);

        // To get booster quality
        String[] boosters = {"No booster", "Q1 Booster", "Q2 Booster", "Q3 Booster", "Q4 Booster", "Q5 Booster"};
        combo1 = new JComboBox<>(boosters);
        add(combo1);

        // To get weapon quality
        String[] weapons = {"Q1 Weapon", "Q2 Weapon", "Q3 Weapon", "Q4 Weapon", "Q5 Weapon",
                "Q1 Tank", "Q2 Tank", "Q3 Tank", "Q4 Tank", "Q5 Tank",
                "Q1 Aircraft", "Q2 Aircraft", "Q3 Aircraft", "Q4 Aircraft", "Q5 Aircraft",
                "Rocket", "Mortar", "AK47", "Panzer", "Falcon", "Fist"};
        combo2 = new JComboBox<>(weapons);
        add(combo2);

        // Create the button and add an action listener to it
        JButton button = new JButton("Calculate my damage");
        button.addActionListener(e -> {
            int playerLevel = Integer.parseInt(playerLevelField.getText());
            int strength = Integer.parseInt(strengthField.getText());
            int rankLevel = Integer.parseInt(rankLevelField.getText());
            int hitCount = Integer.parseInt(hitCountField.getText());
            String boostUsed = (String) combo1.getSelectedItem();
            String weaponUsed = (String) combo2.getSelectedItem();

            double naturalEnemyBonus = 1.0;

            if (checkbox1.isSelected()) {
                naturalEnemyBonus = 1.1;
            }

            assert boostUsed != null;
            double boosterBonus = switch (boostUsed) {
                case "Q1 Booster" -> 1.1;
                case "Q2 Booster" -> 1.2;
                case "Q3 Booster" -> 1.3;
                case "Q4 Booster" -> 1.4;
                case "Q5 Booster" -> 1.5;
                default -> 1.0;
            };

            assert weaponUsed != null;
            double weaponBonus = switch (weaponUsed) {
                case "Q1 Weapon" -> 1.2;
                case "Q2 Weapon" -> 1.4;
                case "Q3 Weapon" -> 1.6;
                case "Q4 Weapon", "Q1 Tank" -> 1.8;
                case "Q5 Weapon" -> 2;
                case "Q2 Tank" -> 2.2;
                case "Q3 Tank" -> 2.5;
                case "Q4 Tank" -> 2.8;
                case "Q5 Tank" -> 3;
                case "Q1 Aircraft" -> 2.7;
                case "Q2 Aircraft" -> 2.9;
                case "Q3 Aircraft" -> 3.3;
                case "Q4 Aircraft" -> 3.6;
                case "Q5 Aircraft", "AK47" -> 4;
                case "Mortar" -> 5;
                case "Panzer" -> 6;
                case "Falcon" -> 8;
                default -> 1.0;
            };

            double damage = ((((playerLevel * 5) + strength)) * (1 + (rankLevel * 0.05)) * weaponBonus * naturalEnemyBonus * hitCount * boosterBonus);
            String damageString = String.format("%.2f", damage);

            // Show the sum in a message dialog
            JOptionPane.showMessageDialog(null, "The damage is: " + damageString + "\twepBonus: " + weaponBonus + "\tboostBonus: " + boosterBonus);
        });
        add(button);

        // Set the frame size and make it visible
        setSize(300, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new DamageCalculator();
    }
}