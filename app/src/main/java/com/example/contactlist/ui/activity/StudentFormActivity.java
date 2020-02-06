package com.example.contactlist.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.contactlist.DAO.StudentDAO;
import com.example.contactlist.R;
import com.example.contactlist.model.Student;

public class StudentFormActivity extends AppCompatActivity {

    public static final String APPBAR_TITLE = "New Student";
    private EditText nameField;
    private EditText telephoneField;
    private EditText emailField;
    private final StudentDAO dao = new StudentDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_form);
        setTitle(APPBAR_TITLE);
        fieldInitialization();
        saveButtonConfiguration();
    }

    private void saveButtonConfiguration() {
        Button saveButton = findViewById(R.id.activity_student_form_save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student addedStudent = createStudent();
                save(addedStudent);
            }
        });
    }

    private void fieldInitialization() {
        nameField = findViewById(R.id.activity_student_form_name);
        telephoneField = findViewById(R.id.activity_student_form_telephone);
        emailField = findViewById(R.id.activity_student_form_email);
    }

    private void save(Student addedStudent) {
        dao.save(addedStudent);

        finish();
    }

    private Student createStudent() {
        String name = nameField.getText().toString();
        String telephone = telephoneField.getText().toString();
        String email = emailField.getText().toString();

        return new Student(name, telephone, email);
    }
}
