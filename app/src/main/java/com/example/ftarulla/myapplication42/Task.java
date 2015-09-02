package com.example.ftarulla.myapplication42;

import java.util.UUID;

/**
 * Created by ftarulla on 02/09/15.
 */
public class Task {

    private UUID id;

    private String title;

    public Task(String title) {
        id = UUID.randomUUID();
        this.title = title;
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
}
