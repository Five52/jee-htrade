package trades;

import habitations.Habitation;

import java.time.LocalDateTime;

public class Trade {
    /**
     * The id
     */
    protected long id;

    /**
     * The first habitation concerned by the trade.
     */
    protected Habitation firstHabitation;

    /**
     * The second habitation concerned by the trade.
     */
    protected Habitation secondHabitation;

    /**
     * The start date of the trade.
     */
    protected LocalDateTime startDate;

    /**
     * The end date of the trade.
     */
    protected LocalDateTime endDate;

    /**
     * Empty constructor for Hibernate.
     */
    public Trade() {}

    /**
     * Builds a new trade.
     * @param firstHabitation The first habitation
     * @param secondHabitation The second habitation
     * @param startDate The start date
     * @param endDate The end date
     */
    public Trade(Habitation firstHabitation, Habitation secondHabitation, LocalDateTime startDate, LocalDateTime endDate) {
        this.firstHabitation = firstHabitation;
        this.secondHabitation = secondHabitation;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * Returns the trade id
     * @return long the trade id
     */
    public long getId() {
        return this.id;
    }

    /**
     * Sets the trade id
     * @param long id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Returns the first habitation.
     * @return The first habitation
     */
    public Habitation getFirstHabitation() {
        return this.firstHabitation;
    }

    /**
     * Sets the first habitation.
     * @param newFirstHabitation The new first home
     */
    public void setFirstHabitation(Habitation newFirstHabitation) {
        this.firstHabitation = newFirstHabitation;
    }

    /**
     * Returns the second habitation.
     * @return The second habitation
     */
    public Habitation getSecondHabitation() {
        return this.secondHabitation;
    }

    /**
     * Sets the second habitation.
     * @param newSecondHabitation The new first home
     */
    public void setSecondHabitation(Habitation newSecondHabitation) {
        this.secondHabitation = newSecondHabitation;
    }

    /**
     * Returns the start date.
     * @return The start date
     */
    public LocalDateTime getStartDate() {
        return this.startDate;
    }

    /**
     * Sets the start date.
     * @param newStartDate The new start date
     */
    public void setStartDate(LocalDateTime newStartDate) {
        this.startDate = newStartDate;
    }

    /**
     * Returns the end date.
     * @return The end date
     */
    public LocalDateTime getEndDate() {
        return this.endDate;
    }

    /**
     * Sets the end date.
     * @param newEndDate The new end date
     */
    public void setEndDate(LocalDateTime newEndDate) {
        this.endDate = newEndDate;
    }
}
