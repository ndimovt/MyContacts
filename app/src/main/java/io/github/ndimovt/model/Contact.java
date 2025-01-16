package io.github.ndimovt.model;

import java.util.Objects;

public class Contact{
    private int id;
    private String name;
    private String phoneType;
    private String phone;
    private String emailType;
    private String email;

    public Contact(int id, String name, String phoneType, String phone, String emailType, String email) {
        this.id = id;
        this.name = name;
        this.phoneType = phoneType;
        this.phone = phone;
        this.emailType = emailType;
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmailType(String emailType) {
        this.emailType = emailType;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Contact(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public String getEmailType() {
        return emailType;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return Objects.equals(name, contact.name) && Objects.equals(phoneType, contact.phoneType) && Objects.equals(phone, contact.phone) && Objects.equals(emailType, contact.emailType) && Objects.equals(email, contact.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return name+ "\n" + phone;
    }
}
