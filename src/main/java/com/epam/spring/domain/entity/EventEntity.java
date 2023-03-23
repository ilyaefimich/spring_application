package com.epam.spring.domain.entity;

import java.util.Date;

public class EventEntity {

    private Long id;
    private String title;
    private Date date;

    public EventEntity() {
    }

    public EventEntity(Long id, String title, Date date) {
        this.id = id;
        this.title = title;
        this.date = date;
    }

    public EventEntity(String title, Date date) {
        this.title = title;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
