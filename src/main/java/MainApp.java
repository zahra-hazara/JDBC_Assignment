

import controller.CurrencyController;
import dao.CurrencyDao;
import ui.CurrencyView;
import javax.swing.SwingUtilities;

public class MainApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CurrencyView view = new CurrencyView();
            CurrencyDao dao = new CurrencyDao();
            new CurrencyController(view, dao);
        });
    }
}