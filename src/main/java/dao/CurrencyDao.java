package dao;

import entity.Currency;
import datasource.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CurrencyDao {

    public double getExchangeRate(String currencyCode) {
        String query = "SELECT rate FROM currencies WHERE code = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, currencyCode);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble("rate");
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return -1; // Indicate an error
        }
        return 0; // Default value if not found
    }
}
