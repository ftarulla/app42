package com.example.ftarulla.myapplication42;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.UUID;

public class TaskActivity extends SingleFragmentActivity {

    public static final String EXTRA_MESSAGE = "com.example.ftarulla.myapplication42.MESSAGE";

    @Override
    protected Fragment createFragment() {
        UUID taskId = (UUID)this.getIntent()
                .getSerializableExtra(TaskFragment.EXTRA_TASK_ID);

        return TaskFragment.newInstance(taskId);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.action_search:
                openSearch();
                return true;
            case R.id.action_settings:
                openSettings();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void openSettings() {

    }

    private void openSearch() {
        this.getActionBar().hide();
    }



    public void sendMessage(View view) {
//        EditText editText = (EditText) findViewById(R.id.edit_message);
//        String message = editText.getText().toString();
        String message = "blablabla";

        Intent intent = new Intent(this, DisplayMessageActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        this.startActivity(intent);
    }
}
