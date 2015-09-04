package com.example.ftarulla.myapplication42;

import android.os.Bundle;
import android.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import android.text.format.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TaskFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TaskFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TaskFragment extends Fragment {

    private Task task = null;

    public static TaskFragment newInstance() {
        TaskFragment fragment = new TaskFragment();
        return fragment;
    }

    public TaskFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.task = new Task("Not null but I need a title.");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_task, container, false);

        // Wire the model to the view
        this.wireTitle(view);
        this.wireDate(view);
        this.wireCheckBox(view);
        return view;
    }

    private void wireTitle(View view) {
        EditText titleText = (EditText) view.findViewById(R.id.task_title);
        titleText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // nothing here to do
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                task.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // nothing here to do
            }
        });
    }

    private void wireDate(View view) {
        Button dateButton = (Button) view.findViewById(R.id.task_date);

        // INPOT: Noooo, está teniendo en cuenta que el date del task cuando
        // es creado es "today". Está mal esta linea en el libro!!
        // dateButton.setText(this.task.getDate().toString());
        dateButton.setText(new SimpleDateFormat("MMM dd, yyyy hh:mm a")
                .format(new Date()));

        // TODO:
        dateButton.setEnabled(false);
    }

    private void wireCheckBox(View view) {
        CheckBox doneCheckBox = (CheckBox) view.findViewById(R.id.task_solved);
        doneCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                task.setDone(isChecked);
            }
        });
    }

}
