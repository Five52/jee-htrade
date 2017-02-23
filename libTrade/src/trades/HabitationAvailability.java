package trades;

import habitations.Habitation;

import java.time.LocalDateTime;

public class HabitationAvailability {
    /**
     * The available habitation.
     */
    protected Habitation habitation;

    /**
     * The availability start date.
     */
    protected LocalDateTime startDate;

    /**
     * The availability end date.
     */
    protected LocalDateTime endDate;

    /**
     * Empty constructor for Hibernate.
     */
    public HabitationAvailability() {}

    /**
     * Builds a new habitation availability.
     * @param habitation The habitation that is available
     * @param startDate The start date of the availability
     * @param endDate The end date of the availability
     */
    public HabitationAvailability(Habitation habitation, LocalDateTime startDate, LocalDateTime endDate) {
        this.habitation = habitation;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * Returns the habitation.
     * @return The habitation
     */
    public Habitation getHabitation() {
        return this.habitation;
    }

    /**
     * Sets the habitation.
     * @param newHabitation The new habitation
     */
    public void setHabitation(Habitation newHabitation) {
        this.habitation = newHabitation;
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
     * @param newEndDate The new start date
     */
    public void setEndDate(LocalDateTime newEndDate) {
        this.endDate = newEndDate;
    }
}
