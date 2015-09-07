package com.example.ftarulla.myapplication42;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

/**
 * Created by ftarulla on 07/09/15.
 */
public abstract class SingleFragmentActivity extends Activity {

    // to implement in subclasses
    protected abstract Fragment createFragment();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        FragmentManager fm = this.getFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.activitySingleFragment);

        if (fragment == null) {
            fragment = this.createFragment();
            fm.beginTransaction()
                    .add(R.id.activitySingleFragment, fragment)
                    .commit();
        }
    }
}
