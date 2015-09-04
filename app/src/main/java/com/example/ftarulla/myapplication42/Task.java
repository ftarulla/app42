package com.example.ftarulla.myapplication42;

import java.util.Date;
import java.util.UUID;

/**
 * Created by ftarulla on 02/09/15.
 */
public class Task {

    private UUID id;

    private String title;
    private Date date;
    private boolean done;

    public Task(String title) {
        this.id = UUID.randomUUID();

        this.title = title;
        this.date = new Date();
        this.done = false;
    }

    public UUID getId() {
        return id;
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

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
