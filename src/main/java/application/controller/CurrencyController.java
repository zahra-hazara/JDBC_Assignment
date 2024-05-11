package application.controller;

import dao.CurrencyDao;

public class CurrencyController {
    private CurrencyDao currencyDao;

    public CurrencyController() {
        this.currencyDao = new CurrencyDao(); // Ensure this is initialized properly
    }

    // Method to perform currency conversion
    public double convertCurrency(String fromCurrency, String toCurrency, double amount) {
        try {
            double fromRate = currencyDao.getExchangeRate(fromCurrency);
            double toRate = currencyDao.getExchangeRate(toCurrency);

            // Debugging output to verify rates (can be removed in production)
            System.out.println("Converting from " + fromCurrency + " (" + fromRate + ") to " + toCurrency + " (" + toRate + ") with amount " + amount);

            // Perform the currency conversion calculation
            double result = (amount / fromRate) * toRate;

            return result; // Return the result of the conversion
        } catch (Exception e) {
            // Log error or handle exception appropriately
            System.out.println("Error during currency conversion: " + e.getMessage());
            return -1; // Indicative of an error
        }
    }
}
