package com.example.tattoo.models;

import jakarta.persistence.*;

@Entity
public class person {
    @Id
    @Column(unique = true, nullable = false)
    private String id;
    private String name;
    private String lastname;
    private String born_date;
    private String insta_handle;
    private int phone;

    public person() {
    }

    public person(String id, String name, String lastname, String born_date, String insta_handle, int phone) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.born_date = born_date;
        this.insta_handle = insta_handle;
        this.phone = phone;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBorn_date() {
        return this.born_date;
    }

    public void setBorn_date(String born_date) {
        this.born_date = born_date;
    }

    public String getInsta_handle() {
        return this.insta_handle;
    }

    public void setInsta_handle(String insta_handle) {
        this.insta_handle = insta_handle;
    }

    public int getPhone() {
        return this.phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}