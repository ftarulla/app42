package com.example.ftarulla.myapplication42;


import android.support.v4.app.Fragment;

public class TaskListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return TaskListFragment.newInstance();
    }
}
