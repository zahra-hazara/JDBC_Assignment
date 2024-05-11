package currrencyconverter.view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class CurrencyConverterFrame extends JFrame {
    private JButton convertButton;
    private JTextField amountField;
    private JComboBox<String> currencyDropdown;

    public CurrencyConverterFrame() {
        // Set up the frame components
        initializeUI();
    }

    private void initializeUI() {
        // Initialize and place all UI components like buttons, text fields, etc.
        convertButton = new JButton("Convert");
        amountField = new JTextField(10);
        currencyDropdown = new JComboBox<>(new String[] {"USD", "EUR", "GBP"});

        // Layout setup, e.g., using BorderLayout, GridLayout, etc.
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.add(amountField);
        this.add(currencyDropdown);
        this.add(convertButton);
        this.pack();
        this.setVisible(true);
    }

    public void setConvertButtonListener(ActionListener listener) {
        convertButton.addActionListener(listener);
    }

    // Other methods to update the UI based on model updates
}
