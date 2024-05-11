package application.view;

import application.controller.CurrencyController;
import javax.swing.*;

public class CurrencyConverterUI extends JFrame {
    private JComboBox<String> currencyFrom;
    private JComboBox<String> currencyTo;
    private JTextField amountField;
    private JButton convertButton;
    private JLabel resultLabel;

    private CurrencyController controller;  // Reference to the controller

    public CurrencyConverterUI(CurrencyController controller) {
        this.controller = controller;
        initializeUI();
        setupEventHandlers();
    }

    private void initializeUI() {
        // Initialization of UI components like comboBoxes, textField, button, and label
        setTitle("Currency Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        currencyFrom = new JComboBox<>(new String[]{"USD", "EUR", "JPY"});
        currencyTo = new JComboBox<>(new String[]{"USD", "EUR", "JPY"});
        amountField = new JTextField(10);
        convertButton = new JButton("Convert");
        resultLabel = new JLabel("Result: ");

        add(currencyFrom);
        add(currencyTo);
        add(amountField);
        add(convertButton);
        add(resultLabel);

        pack();  // Size the frame
        setLocationRelativeTo(null);  // Center the window
    }

    private void setupEventHandlers() {
        convertButton.addActionListener(e -> performConversion());
    }

    private void performConversion() {
        String fromCurrency = (String) currencyFrom.getSelectedItem();
        String toCurrency = (String) currencyTo.getSelectedItem();
        try {
            double amount = Double.parseDouble(amountField.getText());
            double result = controller.convertCurrency(fromCurrency, toCurrency, amount);
            resultLabel.setText("Result: " + String.format("%.2f", result));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Conversion Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}