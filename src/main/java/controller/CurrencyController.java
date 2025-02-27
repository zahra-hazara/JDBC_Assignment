package controller;

import dao.CurrencyDao;
import entity.Currency;
import ui.CurrencyView;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;


public class CurrencyController {
    private final CurrencyView view;
    private final CurrencyDao currencyDao;

    public CurrencyController(CurrencyView view, CurrencyDao currencyDao) {
        this.view = view;
        this.currencyDao = currencyDao;
        initializeCurrencies();
        this.view.setController(this);
    }

    private void initializeCurrencies() {
        try {
            List<Currency> currencies = currencyDao.getAllCurrencies();
            // Convert to List<String> using Java 8 Streams
            List<String> abbreviations = currencies.stream()
                    .map(Currency::getAbbreviation)
                    .collect(Collectors.toList());

            view.populateCurrencyDropdowns(abbreviations);
        } catch (SQLException e) {
            view.showError("Failed to load currencies: " + e.getMessage());
        }
    }

    public void convertCurrency() {
        try {
            String fromAbbr = view.getFromCurrency();
            String toAbbr = view.getToCurrency();
            double amount = view.getAmount();

            double fromRate = currencyDao.getConversionRate(fromAbbr);
            double toRate = currencyDao.getConversionRate(toAbbr);

            double result = (amount / fromRate) * toRate;
            view.displayResult(result);
        } catch (NumberFormatException e) {
            view.showError("Invalid amount. Enter a valid number.");
        } catch (SQLException e) {
            view.showError("Database error: " + e.getMessage());
        }
    }
}
