package com.example.ftarulla.myapplication42;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import java.util.UUID;

public class TaskPagerActivity extends FragmentActivity {

    private ViewPager mViewPager;
    //private ArrayList<Task> mTasks;
    private TaskStore mTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // create viewPager
        this.mViewPager = new ViewPager(this);
        this.mViewPager.setId(R.id.viewPager);
        this.setContentView(this.mViewPager);

        //
        //mTasks = TaskStore.getInstance(this).getTasks();
        mTasks = TaskStore.getInstance(this);


        // view pager adapter
        FragmentManager fm = this.getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
            @Override
            public Fragment getItem(int position) {
                Task task = mTasks.getAt(position);
                return TaskFragment.newInstance(task.getId());
            }

            @Override
            public int getCount() {
                return mTasks.size();
            }
        });

        // set selected task in view
        UUID taskId = (UUID)this.getIntent()
                .getSerializableExtra(TaskFragment.EXTRA_TASK_ID);
        int position = mTasks.getPosition(taskId);
        this.mViewPager.setCurrentItem(position);
    }

}
