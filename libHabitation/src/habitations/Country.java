package habitations;

/**
 * An enum for the available countries
 */
public enum Country {
    FRANCE("France"),
    UNITED_KINGDOM("Royaume Uni"),
    BELGIUM("Belgique"),
    SWITZERLAND("Suisse"),
    SPAIN("Espagne"),
    ITALY("Italie"),
    GREECE("Grèce"),
    UNITED_STATES("Etats-Unis"),
    NORWAY("Norvège"),
    SWEDEN("Suède"),
    FINLAND("Finlande");

    /**
     * The text representation of the country.
     */
    private final String text;
    
    /**
     * Builds a new Country.
     * @param text The text representation of the country
     */
    private Country(final String text) {
        this.text = text;
    }
    
    /**
     * Returns a representation of the country as a string;
     * @return A representation of the country as a string
     */
    public String toString() {
        return this.text;
    }
}
