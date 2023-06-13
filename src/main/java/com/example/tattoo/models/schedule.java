package com.example.tattoo.models;
import jakarta.persistence.*;
import java.util.Date;

@Entity
public class schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(targetEntity = application.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_application",referencedColumnName = "id")
    private application app;

    private Date date;
    private String start;
    private String end;
    private String message;

    
    public schedule(application app, Date date, String start, String end, String message) {
        this.app = app;
        this.date = date;
        this.start = start;
        this.end = end;
        this.message = message;
    }


    
    public schedule(Integer id, application app, Date date, String start, String end, String message) {
        this.id = id;
        this.app = app;
        this.date = date;
        this.start = start;
        this.end = end;
        this.message = message;
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
        return app;
    }
    public void setApp(application app) {
        this.app = app;
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
