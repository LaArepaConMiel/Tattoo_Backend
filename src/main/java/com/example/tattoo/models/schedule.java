package com.example.tattoo.models;
import jakarta.persistence.*;
import java.util.Date;

@Entity
public class schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    //puede ser many to one, ampliaremos jj
    @OneToOne(targetEntity = application.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_application",referencedColumnName = "id")
    private application application;

    private Date date;
    private String start;
    private String end;
    private String message;
    private String status;
    private Float price;
    private String category;
    private Float deposit;

    
    
     

    public schedule(Integer id, application app, Date date, String start, String end, String message, String status,
            Float price, String category, Float deposit) {
        this.id = id;
        this.application = app;
        this.date = date;
        this.start = start;
        this.end = end;
        this.message = message;
        this.status = status;
        this.price = price;
        this.category = category;
        this.deposit = deposit;
    }



    public String getStatus() {
        return status;
    }



    public void setStatus(String status) {
        this.status = status;
    }



    public Float getPrice() {
        return price;
    }



    public void setPrice(Float price) {
        this.price = price;
    }



    public String getCategory() {
        return category;
    }



    public void setCategory(String category) {
        this.category = category;
    }



    public Float getDeposit() {
        return deposit;
    }



    public void setDeposit(Float deposit) {
        this.deposit = deposit;
    }



    public schedule() {
    }



    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public application getApp() {
        return application;
    }
    public void setApp(application app) {
        this.application = app;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getStart() {
        return start;
    }
    public void setStart(String start) {
        this.start = start;
    }
    public String getEnd() {
        return end;
    }
    public void setEnd(String end) {
        this.end = end;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    
}
