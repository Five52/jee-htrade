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
     * The person's password.
     */
    protected String password;

    /**
     * Empty constructor for Hibernate.
     */
    public Person() {}

    /**
     * Builds a new person.
     * @param email The person's email
     * @param firstName The person's firstName
     * @param lastName The person's lastName
     */
    public Person(String email, String firstName, String lastName, String plainPassword) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = this.hash(plainPassword);
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
     * Sets the person's first name.
     * @param firstName The new person's first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the person's last name.
     * @return The person's last name
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Sets the person's last name.
     * @param lastName The new person's last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return this.password;
    }
    
    /**
     * Sets the person's password.
     * @param password The new person's password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * Sets the person's plain password.
     * @param plainPassword The new person's password
     */
    public void setPlainPassword(String plainPassword) {
        this.password = hash(plainPassword);
    }

    /**
     * TODO : Hashing and return the given password using BCrypt.
     *
     * Hashes the given password.
     * @param plainPassword The password to hash
     * @return password The hashed given password
     */
    public String hash(String plainPassword) {
        return plainPassword; 
    }


    /**
     * Returns a representation of the person as a string.
     * @return A representation of the person as a string
     */
    public String toString() {
        return email + " : " + firstName + " " + lastName;
    }
}
