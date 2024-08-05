import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProbabilityCalculator extends JFrame {
    JTextField prevalenceField;
    JTextField sensitivityField;
    JTextField specificityField;
    JLabel positiveResultLabel;
    JLabel negativeResultLabel;

    public ProbabilityCalculator() {
        setTitle("Diagnostic Test Probability Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel prevalenceLabel = new JLabel("Prevalence (P(Disease)):");
        prevalenceLabel.setBounds(10, 10, 200, 25);
        add(prevalenceLabel);

        prevalenceField = new JTextField();
        prevalenceField.setBounds(220, 10, 150, 25);
        add(prevalenceField);

        JLabel sensitivityLabel = new JLabel("Sensitivity (P(Test+|Disease+)):");
        sensitivityLabel.setBounds(10, 50, 200, 25);
        add(sensitivityLabel);

        sensitivityField = new JTextField();
        sensitivityField.setBounds(220, 50, 150, 25);
        add(sensitivityField);

        JLabel specificityLabel = new JLabel("Specificity (P(Test-|Disease-)):");
        specificityLabel.setBounds(10, 90, 200, 25);
        add(specificityLabel);

        specificityField = new JTextField();
        specificityField.setBounds(220, 90, 150, 25);
        add(specificityField);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.setBounds(150, 130, 100, 30);
        add(calculateButton);

        positiveResultLabel = new JLabel("P(Disease|Test+): ");
        positiveResultLabel.setBounds(10, 170, 360, 25);
        add(positiveResultLabel);

        negativeResultLabel = new JLabel("P(Disease|Test-): ");
        negativeResultLabel.setBounds(10, 200, 360, 25);
        add(negativeResultLabel);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateProbabilities();
            }
        });
    }

    void calculateProbabilities() {
        try {
            double prevalence = Double.parseDouble(prevalenceField.getText());
            double sensitivity = Double.parseDouble(sensitivityField.getText());
            double specificity = Double.parseDouble(specificityField.getText());

            double pDiseaseGivenPositive = calculatePositiveProbability(prevalence, sensitivity, specificity);
            double pDiseaseGivenNegative = calculateNegativeProbability(prevalence, sensitivity, specificity);

            positiveResultLabel.setText(String.format("P(Disease|Test+): %.4f", pDiseaseGivenPositive));
            negativeResultLabel.setText(String.format("P(Disease|Test-): %.4f", pDiseaseGivenNegative));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    double calculatePositiveProbability(double prevalence, double sensitivity, double specificity) {
        double pTestPositive = sensitivity * prevalence + (1 - specificity) * (1 - prevalence);
        return (sensitivity * prevalence) / pTestPositive;
    }

    double calculateNegativeProbability(double prevalence, double sensitivity, double specificity) {
        double pTestNegative = specificity * (1 - prevalence) + (1 - sensitivity) * prevalence;
        return ((1 - sensitivity) * prevalence) / pTestNegative;
    }

    public static void main(String[] args) {
        new ProbabilityCalculator().setVisible(true);
    }
}
