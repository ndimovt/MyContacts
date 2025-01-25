package io.github.ndimovt.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * The class Contact
 */
public class Contact implements Serializable {
    private int id;
    private String name;
    private String phoneType;
    private String phone;
    private String emailType;
    private String email;

    /**
     * Instantiates Contact
     * @param id Int primitive
     * @param name String object
     * @param phoneType String object
     * @param phone String object
     * @param emailType String object
     * @param email String object
     */
    public Contact(int id, String name, String phoneType, String phone, String emailType, String email) {
        this.id = id;
        this.name = name;
        this.phoneType = phoneType;
        this.phone = phone;
        this.emailType = emailType;
        this.email = email;
    }

    /**
     * Update id
     * @param id Int primitive
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Update name
     * @param name String object
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Update phoneType
     * @param phoneType String object
     */
    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    /**
     * Update phone
     * @param phone String object
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Update emailType
     * @param emailType String object
     */
    public void setEmailType(String emailType) {
        this.emailType = emailType;
    }

    /**
     * Update email
     * @param email String object
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Return id
     * @return Int primitive
     */
    public int getId() {
        return id;
    }

    /**
     * Return phone
     * @return String object
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Return phoneType
     * @return String object
     */
    public String getPhoneType() {
        return phoneType;
    }

    /**
     * Return emailType
     * @return String object
     */
    public String getEmailType() {
        return emailType;
    }

    /**
     * Return email
     * @return String object
     */
    public String getEmail() {
        return email;
    }

    /**
     * Return name
     * @return String object
     */
    public String getName() {
        return name;
    }

    /**
     * Checks for object equality
     * @param o Object
     * @return Boolean value
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return id == contact.id;
    }

    /**
     * Generates hashcodes
     * @return Int primitive
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * String representation of the object
     * @return String object
     */
    @Override
    public String toString() {
        return name+ "\n" + phone;
    }
}
