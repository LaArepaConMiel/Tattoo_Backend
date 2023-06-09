package com.example.tattoo.models;

import jakarta.persistence.*;

@Entity
public class tattoo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String style;
    private String color;
    private boolean firstTattoo;
    private String bodyShape;
    private String bodyPart;
    private String size;
    private String description;
    private String availability;
    private Long budget;

    public tattoo() {
    }

    public tattoo(String style, String color, boolean firstTattoo, String bodyShape, String bodyPart, String size,
            String description, String availability, Long budget) {
        this.style = style;
        this.color = color;
        this.firstTattoo = firstTattoo;
        this.bodyShape = bodyShape;
        this.bodyPart = bodyPart;
        this.size = size;
        this.description = description;
        this.availability = availability;
        this.budget = budget;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFirstTattoo() {
        return firstTattoo;
    }

    public void setFirstTattoo(boolean firstTattoo) {
        this.firstTattoo = firstTattoo;
    }

    public String getBodyShape() {
        return bodyShape;
    }

    public void setBodyShape(String bodyShape) {
        this.bodyShape = bodyShape;
    }

    public String getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(String bodyPart) {
        this.bodyPart = bodyPart;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public Long getBudget() {
        return budget;
    }

    public void setBudget(Long budget) {
        this.budget = budget;
    }
}