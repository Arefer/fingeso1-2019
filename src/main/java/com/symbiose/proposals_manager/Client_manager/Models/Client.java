package com.symbiose.proposals_manager.Client_manager.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Client {
    @Id
    private String id;
    private String nameOfCompany;
    private String nameOfContact;
    private String contactMail;
    private String contactNumber;
    private String address;

    public Client(String nameOfCompany, String nameOfContact, String contactMail, String contactNumber, String address) {
        this.nameOfCompany = nameOfCompany;
        this.nameOfContact = nameOfContact;
        this.contactMail = contactMail;
        this.contactNumber = contactNumber;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public String getNameOfCompany() {
        return nameOfCompany;
    }

    public String getNameOfContact() {
        return nameOfContact;
    }

    public String getContactMail() {
        return contactMail;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNameOfCompany(String nameOfCompany) {
        this.nameOfCompany = nameOfCompany;
    }

    public void setNameOfContact(String nameOfContact) {
        this.nameOfContact = nameOfContact;
    }

    public void setContactMail(String contactMail) {
        this.contactMail = contactMail;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setAddress(String addres) {
        this.address = addres;
    }

    @Override
    public String toString() {
        return "cliente{" +
                "id='" + id + '\'' +
                ", nameOfCompany='" + nameOfCompany + '\'' +
                ", nameOfContact=" + nameOfContact +
                ", contactMail=" + contactMail +
                ", address=" + address +
                ", contactNumber=" + contactNumber +
                '}';
    }
}
