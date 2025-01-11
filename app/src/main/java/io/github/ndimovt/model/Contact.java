package io.github.ndimovt.model;

public class Contact {
    private String id;
    private String name;
    private String phoneType;
    private String phone;
    private String emailType;
    private String email;

    public Contact(String name, String phoneType, String phone, String emailType, String email) {
        this.id = phone;
        this.name = name;
        this.phoneType = phoneType;
        this.phone = phone;
        this.emailType = emailType;
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }
}
