package dao;

import datasource.MariaDbConnection;
import entity.Currency;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CurrencyDao {
    public List<Currency> getAllCurrencies() throws SQLException {
        List<Currency> currencies = new ArrayList<>();
        String sql = "SELECT abbreviation, name, conversion_rate FROM currencies";

        try (Connection conn = MariaDbConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                currencies.add(new Currency(
                        rs.getString("abbreviation"),
                        rs.getString("name"),
                        rs.getDouble("conversion_rate")
                ));
            }
        }
        return currencies;
    }

    public double getConversionRate(String abbreviation) throws SQLException {
        String sql = "SELECT conversion_rate FROM currencies WHERE abbreviation = ?";
        try (Connection conn = MariaDbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, abbreviation);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return rs.getDouble("conversion_rate");
                else throw new SQLException("Currency not found: " + abbreviation);
            }
        }
    }
}