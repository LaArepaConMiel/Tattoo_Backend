package com.example.tattoo.models;

import jakarta.persistence.*;

@Entity
public class application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(targetEntity = user.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_user",referencedColumnName = "username")
    @MapKey
    private user user;

    @OneToOne(targetEntity = tattoo.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_tattoo",referencedColumnName = "id")
    private tattoo tattoo;

    @OneToOne(targetEntity = client.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_client",referencedColumnName = "id")
    private client client;

    public application() {
    }

    public application(user user, tattoo tattoo, client client) {
        this.user = user;
        this.tattoo = tattoo;
        this.client = client;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public user getUser() {
        return user;
    }

    public void setUser(user user) {
        this.user = user;
    }

    public tattoo getTattoo() {
        return tattoo ;
    }

    public void setTattoo(tattoo tattoo ) {
        this.tattoo  = tattoo;
    }

    public client getClient() {
        return client;
    }

    public void setClient(client client) {
        this.client = client;
    }
}