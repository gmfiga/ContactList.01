package com.example.contactlist.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.contactlist.DAO.StudentDAO;
import com.example.contactlist.R;

public class StudentListActivity extends AppCompatActivity {

    public static final String APPBAR_TITLE = "Student List";
    private final StudentDAO dao = new StudentDAO();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.student_list_activity);
        setTitle(APPBAR_TITLE);

        configureFabNewStudent();


    }

    private void configureFabNewStudent() {
        FloatingActionButton newStudentButton = findViewById(R.id.activity_student_list_fab_newStudent);

        newStudentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openStudentFormActivity();
            }
        });
    }

    private void openStudentFormActivity() {
        startActivity(new Intent(this, StudentFormActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();


        configureList();

    }

    private void configureList() {
        ListView studentList = findViewById(R.id.activity_student_list_listview);
        studentList.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,dao.allStudents()));
    }
}
