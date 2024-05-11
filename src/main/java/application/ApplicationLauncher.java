package application;

import application.controller.CurrencyController;
import application.view.CurrencyConverterUI;

public class ApplicationLauncher {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            CurrencyController controller = new CurrencyController();
            CurrencyConverterUI frame = new CurrencyConverterUI(controller);
            frame.setVisible(true);
        });
    }
}

