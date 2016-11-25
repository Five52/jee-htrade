package persons;
/**
 * A class for representing a person with an email, a first name and a last name.
 */
public class Person {
    
    /** 
     * The person's email.
     */
    protected String email;

    /**
     * The person's first name.
     */
    protected String firstName;

    /**
     * The person's last name.
     */
    protected String lastName;

    /**
     * Builds a new person.
     * @param email The person's email
     * @param firstName The person's firstName
     * @param lastName The person's lastName
     */
    public Person(String email, String firstName, String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Returns the person's email.
     * @return The person's email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Sets the person's email.
     * @param email The new person's email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the person's first name.
     * @return The person's first name
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Returns the person's last name.
     * @return The person's last name
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Sets the person's last name (e.g., a married woman).
     * @param lastName The new person's last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns a representation of the person as a string.
     * @return A representation of the person as a string
     */
    public String toString() {
        return email + " : " + firstName + " " + lastName;
    }
}
