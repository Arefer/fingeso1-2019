package com.symbiose.proposals_manager.Models;


public class User {
    private String id;
    private String name;
    private String mail;
    private String number;
    private String code;

    public User(String name, String mail, String number, String code) {
        this.name = name;
        this.mail = mail;
        this.number = number;
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public String getNumber() {
        return number;
    }

    public String getPassword() {
        return code;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
