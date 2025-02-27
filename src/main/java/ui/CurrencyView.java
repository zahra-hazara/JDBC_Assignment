package ui;

import javax.swing.*;
import controller.CurrencyController;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class CurrencyView {
    private final JFrame frame;
    private final JTextField amountField;
    private final JComboBox<String> fromCombo;  // Correct variable name
    private final JComboBox<String> toCombo;    // Correct variable name
    private final JLabel resultLabel;
    private CurrencyController controller;

    public CurrencyView() {
        frame = new JFrame("Currency Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(5, 2, 10, 10));

        // Initialize components with correct names
        amountField = new JTextField();
        fromCombo = new JComboBox<>();  // Matches variable declaration
        toCombo = new JComboBox<>();    // Matches variable declaration
        JButton convertButton = new JButton("Convert");
        resultLabel = new JLabel("Result: ");

        // Add components to layout
        frame.add(new JLabel("Amount:"));
        frame.add(amountField);
        frame.add(new JLabel("From Currency:"));
        frame.add(fromCombo);
        frame.add(new JLabel("To Currency:"));
        frame.add(toCombo);
        frame.add(new JLabel());
        frame.add(convertButton);
        frame.add(new JLabel());
        frame.add(resultLabel);

        // Event listener
        convertButton.addActionListener(this::performConversion);

        frame.setVisible(true);
    }

    private void performConversion(ActionEvent e) {
        if (controller != null) {
            controller.convertCurrency();
        }
    }

    public void populateCurrencyDropdowns(List<String> abbreviations) {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (String abbr : abbreviations) {
            model.addElement(abbr);
        }
        fromCombo.setModel(model);  // Fixed variable name
        toCombo.setModel(model);    // Fixed variable name
    }


    public String getFromCurrencyAbbreviation() {
        return (String) fromCombo.getSelectedItem();
    }

    public String getToCurrencyAbbreviation() {
        return (String) toCombo.getSelectedItem();
    }

    public double getAmount() throws NumberFormatException {
        return Double.parseDouble(amountField.getText());
    }

    public void displayResult(double result) {
        resultLabel.setText(String.format("Result: %.2f", result));
    }

    public void showError(String message) {
        JOptionPane.showMessageDialog(frame, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void setController(CurrencyController controller) {
        this.controller = controller;
    }

    public String getFromCurrency() {
        return (String) fromCombo.getSelectedItem();
    }

    public String getToCurrency() {
        return (String) toCombo.getSelectedItem();
    }
}