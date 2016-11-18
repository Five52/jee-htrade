package habitations;

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

    private final String text;
    
    private Country(final String text) {
        this.text = text;
    }
    
    public String toString() {
        return this.text;
    }
}
