package com.example.tattoo.models;

import jakarta.persistence.*;

@Entity
public class user {
    @Id
    @Column(unique = true,nullable = false)
    private String username;
    private String email;
    private String password;
    @OneToOne(targetEntity = person.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_person",referencedColumnName = "id")
    private person person;

    public user() {
    }

    public user(String username) {
       this.username = username;
        this.email = "";
        this.password =  "";
        this.person = null; 
    }

    public user(String username, String email, String password, person person) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.person = person;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public person getPerson(){
        return person;
    }

    public void setPerson(person person){
        this.person = person;
    }

    @Override
    public String toString() {
        return "{" +
            " username='" + getUsername() + "'" +
            ", email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            ", person='" + getPerson() + "'" +
            "}";
    }

}