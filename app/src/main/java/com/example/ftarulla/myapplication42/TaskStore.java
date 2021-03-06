package com.example.ftarulla.myapplication42;

import android.content.Context;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by ftarulla on 04/09/15.
 */
public class TaskStore {
    private static TaskStore instance;
    private Context appContext;

    //
    private ArrayList<Task> tasks;

    private TaskStore(Context appContext) {
        this.appContext = appContext;
        this.tasks = new ArrayList<Task>();

        // TODO: remove this
        this.addTestingTasks();
    }

    public static TaskStore getInstance(Context c) {
        if (instance == null) {
            instance = new TaskStore(c.getApplicationContext());
        }
        return instance;
    }

    public Task getTask(UUID id) {
        Task rtask = null;

        for (Task task : this.tasks) {
            if(task.getId().equals(id)) {
                rtask = task;
            }
        }
        return rtask;
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public Task getAt(int position) {
        return this.tasks.get(position);
    }

//    public ArrayList<Task> getTasks() {
//        return this.tasks;
//    }

    public int getPosition(UUID taskId) {
        int i = 0;
        for (i = 0; i < this.tasks.size() &&
                    !(this.tasks.get(i).getId().equals(taskId)); i++);

        return i;
    }

    public int size() {
        return this.tasks.size();
    }

    public ArrayList<Task> toArray() {
        return this.tasks;
    }

    private void addTestingTasks() {
        for (int i=0; i < 100; i++) {
            Task task = new Task("Task #" + i);
            task.setDone(i % 2 == 0);
            this.addTask(task);
        }
    }
}
