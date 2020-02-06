package com.example.contactlist.DAO;

import com.example.contactlist.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private final static List<Student> students = new ArrayList<>();

    public void save(Student student) {
        students.add(student);
    }

    public List<Student> allStudents() {
        return new ArrayList<>(students);
    }
}
