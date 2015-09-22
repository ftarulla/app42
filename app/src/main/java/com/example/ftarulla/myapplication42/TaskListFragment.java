package com.example.ftarulla.myapplication42;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.TextView;
import java.util.ArrayList;


public class TaskListFragment extends Fragment implements AbsListView.OnItemClickListener {

    private static final String TAG = "TaskListFragment";

    // The fragment's ListView/GridView.
    private AbsListView mListView;

    // The Adapter which will be used to populate the ListView/GridView with Views.
    private ListAdapter mAdapter;

    public static TaskListFragment newInstance() {
        return new TaskListFragment();
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public TaskListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TaskStore tasks = TaskStore.getInstance(getActivity());

        //
        mAdapter = new TaskAdapter(tasks);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tasklist, container, false);

        // Set the adapter
        mListView = (AbsListView) view.findViewById(android.R.id.list);
        mListView.setAdapter(mAdapter);

        // Set OnItemClickListener so we can be notified on item clicks
        mListView.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        // refresh list
        ((TaskAdapter)this.mAdapter).notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Task task = (Task)mAdapter.getItem(position);
        Log.d(TAG, task.getTitle() + " was clicked!");

        // show the details
        //Intent intent = new Intent(this.getActivity(), TaskActivity.class);
        Intent intent = new Intent(this.getActivity(), TaskPagerActivity.class);
        intent.putExtra(TaskFragment.EXTRA_TASK_ID, task.getId());

        this.startActivity(intent);
    }

    /**
     * The default content for this Fragment has a TextView that is shown when
     * the list is empty. If you would like to change the text, call this method
     * to supply the text it should use.
     */
    public void setEmptyText(CharSequence emptyText) {
        View emptyView = mListView.getEmptyView();

        if (emptyView instanceof TextView) {
            ((TextView) emptyView).setText(emptyText);
        }
    }

//    /**
//     * This interface must be implemented by activities that contain this
//     * fragment to allow an interaction in this fragment to be communicated
//     * to the activity and potentially other fragments contained in that
//     * activity.
//     * <p/>
//     * See the Android Training lesson <a href=
//     * "http://developer.android.com/training/basics/fragments/communicating.html"
//     * >Communicating with Other Fragments</a> for more information.
//     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        public void onFragmentInteraction(String id);
//    }

    private class TaskAdapter extends ArrayAdapter<Task> {

        public TaskAdapter(TaskStore tasks) {
            super(getActivity(), // context
                  android.R.layout.simple_list_item_1, // layout used to create view object
                  android.R.id.text1, // The id of the TextView within the layout resource to be populated
                  tasks.toArray()); // items
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getActivity().getLayoutInflater()
                        .inflate(R.layout.list_item_task, null);
            }

            // the model...
            Task task = this.getItem(position);

            // the view...
            TextView titleTextView =
                    (TextView) convertView.findViewById(R.id.task_list_item_titleTextView);
            titleTextView.setText(task.getTitle());
            //
            TextView dateTextView =
                    (TextView) convertView.findViewById(R.id.task_list_item_dateTextView);
            dateTextView.setText(task.getDate().toString());
            //
            CheckBox doneCheckBox =
                    (CheckBox) convertView.findViewById(R.id.task_list_item_doneCheckBox);
            doneCheckBox.setChecked(task.isDone());

            return convertView;
        }
    }
}
