package entity;

public class Currency {
    private final String abbreviation;
    private final String name;
    private final double conversionRate;

    public Currency(String abbreviation, String name, double conversionRate) {
        this.abbreviation = abbreviation;
        this.name = name;
        this.conversionRate = conversionRate;
    }

    // Getters
    public String getAbbreviation() { return abbreviation; }
    public String getName() { return name; }
    public double getConversionRate() { return conversionRate; }
}