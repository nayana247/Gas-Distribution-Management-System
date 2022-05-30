package com.example.gdms;

public class Customer {

    // attributes
    private int id;
    private String name;
    private String nic;
    private String contact;
    private String email;
    private String address;
    private String password;
    private String rePassword;

    // default constructor
    public Customer() {
    }

    // parameterized constructor


    public Customer(int id, String name, String nic, String contact, String email, String address, String password, String rePassword) {
        this.id = id;
        this.name = name;
        this.nic = nic;
        this.contact = contact;
        this.email = email;
        this.address = address;
        this.password = password;
        this.rePassword = rePassword;
    }

    public Customer(String name, String nic, String contact, String email, String address, String password, String rePassword) {
        this.name = name;
        this.nic = nic;
        this.contact = contact;
        this.email = email;
        this.address = address;
        this.password = password;
        this.rePassword = rePassword;
    }

// getters & setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }
}
